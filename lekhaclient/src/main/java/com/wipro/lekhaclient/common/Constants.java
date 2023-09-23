package com.wipro.lekhaclient.common;

public class Constants {


	public static final String LEKHA_ENDPOINT = "https://192.168.8.133";
	public static final String GET_ALL_REGIONS_URL = LEKHA_ENDPOINT + "/nms/getallregions";

	// ----------------- Operation Constants --------------
	public static final String ALARM = "Alarm";
	public static final String ALARM_INFO = "AlarmInfo";
	public static final String GNB = "gNB";
	public static final String REGIONS = "Regions";
	public static final String NODES = "Nodes";
	public static final String NODE = "Node";


	// --------------- Poll Interval Constants ---------------

	public static final int POLL_INTERVAL_5_SEC = 5000;
	public static final int POLL_INTERVAL_10_SEC = 10000;
	public static final int POLL_INTERVAL_15_SEC = 15000;
	public static final String[] SEVIRITY = { "Critical", "Major", "Warning", "Minor" };
	public static final String[] ALARM_STATUS = { "Closed", "Open" };


	// http metods
	public static final String HTTP_METHOD_POST = "POST";
	public static final String HTTP_METHOD_GET = "GET";

}
