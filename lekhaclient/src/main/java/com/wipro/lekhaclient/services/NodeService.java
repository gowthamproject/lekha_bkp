package com.wipro.lekhaclient.services;

import com.wipro.lekhaclient.certificate.Certificate;
import com.wipro.lekhaclient.common.Constants;
import com.wipro.lekhaclient.dao.LocationDAO;
import com.wipro.lekhaclient.dao.NodeDAO;
import com.wipro.lekhaclient.model.Location;
import com.wipro.lekhaclient.model.Node;
import com.wipro.lekhaclient.model.Nodes;
import com.wipro.lekhaclient.model.Region;
import com.wipro.lekhaclient.test.AlarmDetailsData;
import com.wipro.lekhaclient.utils.Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NodeService extends BaseServices {

	protected static Map<Region, List<Nodes>> nodeMapByRegion = null;

	static {
		try {
			pull_NodeDetailsFromLekhaAPI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static void pull_NodeDetailsFromLekhaAPI() throws Exception {

		Certificate.doTrustToCertificates();
		nodeMapByRegion = getAllNodes();
		for (Region region : nodeMapByRegion.keySet()) {
			int region_id = region.getId();
			String state = region.getName();
			List<Nodes> nodes = nodeMapByRegion.get(region);
			for (Nodes node : nodes) {
				List<Integer> nodeIds = node.getOru_list();
				for (Integer nodeId : nodeIds) {
					String responseJson = pullData(Constants.LEKHA_ENDPOINT + "/nms/nodes/" + region_id + "/" + nodeId, Constants.HTTP_METHOD_GET);
					//String responseJson = AlarmDetailsData.NODE_DATA;
					if (responseJson != null && !responseJson.isEmpty()) {
						System.out.println("Node response ----:"+ responseJson);
						//List<Node> nodeList = (List<Node>) Util.parseJsonStrToObject(responseJson, Constants.NODE);
						Node nodeLi = (Node) Util.parseJsonStrToObject(responseJson, Constants.NODE);
						List<Node> nodeList = new ArrayList<Node>();
						nodeList.add(nodeLi);
						new NodeDAO().pollRecords(nodeList);
						List<Location> locationList = new ArrayList<Location>();
						for (Node nodeObj : nodeList) {
							Location location = nodeObj.getLocation();
							location.setOru_id(nodeId);
							location.setOru_name(nodeLi.getOru_name());
							location.setRegion_state(state);
							locationList.add(location);
						}
						pollLocationDetails(locationList);
					}
				}
			}
		}
	}

	public Map<Region, List<Nodes>> getNodeMapByRegion() {
		return nodeMapByRegion;
	}

	public static void pollLocationDetails(List<Location> data) throws SQLException, InterruptedException {
		new LocationDAO().pollRecords(data);
	}
}
