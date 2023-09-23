package com.wipro.lekhaclient.model;


public class Node {
	
	private int id;
	
	private int oru_id; 
	
	private String oru_name;
	
	private String siteName;
	
	private int region_id;
	
	private int transactionId;
	
	private String timeStamp;
	
	private String sourceName;
	
	private NodeInterfaceInfo nodeinterfaceinfo;
	
	private StatusInfo statusinfo;
	
	private Location location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOru_id() {
		return oru_id;
	}

	public void setOru_id(int oru_id) {
		this.oru_id = oru_id;
	}

	public String getOru_name() {
		return oru_name;
	}

	public void setOru_name(String oru_name) {
		this.oru_name = oru_name;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public NodeInterfaceInfo getNodeInterfaceInfo() {
		return nodeinterfaceinfo;
	}

	public void setNodeInterfaceInfo(NodeInterfaceInfo nodeinterfaceinfo) {
		this.nodeinterfaceinfo = nodeinterfaceinfo;
	}

	public StatusInfo getStatusinfo() {
		return statusinfo;
	}

	public void setStatusinfo(StatusInfo statusinfo) {
		this.statusinfo = statusinfo;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
