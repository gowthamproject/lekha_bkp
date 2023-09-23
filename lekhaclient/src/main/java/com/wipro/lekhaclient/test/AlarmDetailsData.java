package com.wipro.lekhaclient.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.wipro.lekhaclient.common.Constants;
import com.wipro.lekhaclient.dao.AlarmDAO;
import com.wipro.lekhaclient.dao.LocationDAO;
import com.wipro.lekhaclient.dao.NodeDAO;
import com.wipro.lekhaclient.model.Alarm;
import com.wipro.lekhaclient.model.AlarmInfo;
import com.wipro.lekhaclient.model.Location;
import com.wipro.lekhaclient.model.Node;
import com.wipro.lekhaclient.model.Nodes;
import com.wipro.lekhaclient.model.Region;
import com.wipro.lekhaclient.services.AlarmService;
import com.wipro.lekhaclient.utils.Util;

import okhttp3.HttpUrl;
import okhttp3.Request;

public class AlarmDetailsData {

	public static final String ALARM_DATA = "[{'region_id':1,'alarmInfo':[{'node_id':251,'alarm_id':'2394','alarm_name':'O-RUdisconnected','alarm_type':'NCCLIENT','alarm_cause':'O-RUdisconnected','alarm_severity':'Critical','alarm_occurance_time':'2023-09-15T17:02:20+0530','corrective_action':'O-RUhardwarenotreachable,checktheO-RUserverstatus','alarm_state':'Open'}]}]";

	public static final String NODE_DATA = "{ 'id':19,'oru_id':205,'oru_name':'o-rutest1205','siteName':'LekhaHQ','region_id':1,'transactionId':1001,'timeStamp':'2023-09-20T12:08:21+0530','sourceName':'EMS','nodeinterfaceinfo':{'ipAddress':'192.168.9.201'},'statusinfo':{'status':'Disconnected'},'location':{'latitude':12.9155,'longitude':77.5859}}";

	public static final String NODES_DATA = "{'oru_list':[205,250,251]}";

	public static final String REGIONS_DATA = "[{'id': 1,'name': 'Karnataka'}]";

	public static void main(String[] args) {

		/*
		 * try { //new NodeDAO().pollRecords(nodeList);
		 * 
		 * List<Location> locs = new ArrayList<Location>(); Location loc = new
		 * Location(); loc.setLatitude(12.9155); loc.setLongitude(77.5859);
		 * loc.setOru_id(2222); loc.setRegion_state("Singapore");
		 * loc.setOru_name("gnbbb"); locs.add(loc); new LocationDAO().pollRecords(locs);
		 * } catch (SQLException | InterruptedException e) { e.printStackTrace(); }
		 */

		/*
		 * AlarmService als = new AlarmService(); try {
		 * als.pull_AlarmDetailsFromLekhaAPI(); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		/*
		 * Node node = new Gson().fromJson(NODE_DATA, Node.class);
		 * 
		 * Nodes nodes = new Gson().fromJson(NODES_DATA, Nodes.class);
		 * 
		 * List<Region> regions = Arrays.asList(new Gson().fromJson(REGIONS_DATA,
		 * Region[].class));
		 * 
		 * List<Node> nodeList = new ArrayList<Node>(); nodeList.add(node);
		 * 
		 * System.out.println(nodes);
		 */

		List<AlarmInfo> alarms = Arrays.asList(new Gson().fromJson(ALARM_DATA, AlarmInfo[].class));
		List<Alarm> alarmList = alarms.get(0).getAlarmInfo();
		alarmList.forEach(p -> p.setRegion_Id(1));
		alarmList.forEach(p -> p.setNode_name("o-rutest1205"));

		for (Alarm al : alarmList) {
			al.setAlarm_occurance_time(Util.parseDate(al.getAlarm_occurance_time()));
		}
		try {
			new AlarmDAO().pollRecords(alarmList);
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}

	}
}
