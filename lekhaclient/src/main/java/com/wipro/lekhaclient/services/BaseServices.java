package com.wipro.lekhaclient.services;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wipro.lekhaclient.certificate.Certificate;
import com.wipro.lekhaclient.common.Constants;
import com.wipro.lekhaclient.model.Nodes;
import com.wipro.lekhaclient.model.Region;
import com.wipro.lekhaclient.utils.Util;

public class BaseServices extends LekhaService {

	@SuppressWarnings("unchecked")
	public static List<Region> getAllRegions() throws KeyManagementException, NoSuchAlgorithmException {
		Certificate.doTrustToCertificates();
		List<Region> regions = null;
		try {
			String responseJson = pullData(Constants.GET_ALL_REGIONS_URL, Constants.HTTP_METHOD_GET);
			// String responseJson = AlarmDetailsData.REGIONS_DATA;
			System.out.println("REGIONS RESPONSE ----: " + responseJson);
			regions = (List<Region>) Util.parseJsonStrToObject(responseJson, Constants.REGIONS);
		} catch (IOException e) {
			System.out.println("Exception occur while pulling all regions from lekha server");
		}
		return regions;
	}

	@SuppressWarnings("unchecked")
	public static Map<Region, List<Nodes>> getAllNodes() throws Exception {
		Certificate.doTrustToCertificates();
		List<Nodes> nodes = new ArrayList<Nodes>();
		Map<Region, List<Nodes>> nodeMapByRegion = new HashMap<Region, List<Nodes>>();
		try {
			List<Region> regions = getAllRegions();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("type", "ORU");
			for (Region region : regions) {
				String responseJson = pullData(Constants.LEKHA_ENDPOINT + "/nms/" + region.getId() + "/nodes", params,
						Constants.HTTP_METHOD_POST);
				// String responseJson = AlarmDetailsData.NODES_DATA;

				System.out.println("NODES RESPONSE ----: " + responseJson);
				Nodes node = (Nodes) Util.parseJsonStrToObject(responseJson, Constants.NODES);
				nodes.add(node);
				nodeMapByRegion.put(region, nodes);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception occur while pulling all regions from lekha server");
		}
		return nodeMapByRegion;
	}
}
