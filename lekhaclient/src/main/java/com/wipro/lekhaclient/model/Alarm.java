package com.wipro.lekhaclient.model;

import com.wipro.lekhaclient.common.Core5GDetails;

public class Alarm {
	
	private int region_Id;
	
	private int node_id;
	
	private String node_type = Core5GDetails.GNB;
	
	private String node_name;
		
	private String alarm_id;
	
	private String alarm_type;
	
	private String alarm_name;
	
	private String alarm_cause;
	
	private String alarm_severity;
	
	private String alarm_occurance_time;
	
	private String corrective_action;
	
	private String alarm_state;
	

	public int getNode_id() {
		return node_id;
	}

	public void setNode_id(int node_id) {
		this.node_id = node_id;
	}

	public String getNode_type() {
		return node_type;
	}

	public void setNode_type(String node_type) {
		this.node_type = node_type;
	}

	public String getNode_name() {
		return node_name;
	}

	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}

	public String getAlarm_id() {
		return alarm_id;
	}

	public void setAlarm_id(String alarm_id) {
		this.alarm_id = alarm_id;
	}

	public String getAlarm_type() {
		return alarm_type;
	}

	public void setAlarm_type(String alarm_type) {
		this.alarm_type = alarm_type;
	}

	public String getAlarm_name() {
		return alarm_name;
	}

	public void setAlarm_name(String alarm_name) {
		this.alarm_name = alarm_name;
	}

	public String getAlarm_cause() {
		return alarm_cause;
	}

	public void setAlarm_cause(String alarm_cause) {
		this.alarm_cause = alarm_cause;
	}

	public String getAlarm_severity() {
		return alarm_severity;
	}

	public void setAlarm_severity(String alarm_severity) {
		this.alarm_severity = alarm_severity;
	}

	public String getAlarm_occurance_time() {
		return alarm_occurance_time;
	}

	public void setAlarm_occurance_time(String alarm_occurance_time) {
		this.alarm_occurance_time = alarm_occurance_time;
	}

	public String getCorrective_action() {
		return corrective_action;
	}

	public void setCorrective_action(String corrective_action) {
		this.corrective_action = corrective_action;
	}

	public String getAlarm_state() {
		return alarm_state;
	}

	public void setAlarm_state(String alarm_state) {
		this.alarm_state = alarm_state;
	}
	
	public int getRegion_Id() {
		return region_Id;
	}

	public void setRegion_Id(int region_Id) {
		this.region_Id = region_Id;
	}

	public Alarm() {}

	@Override
	public String toString() {
		return "Alarm [region_Id=" + region_Id + ", node_id=" + node_id + ", node_type=" + node_type + ", node_name="
				+ node_name + ", alarm_id=" + alarm_id + ", alarm_type=" + alarm_type + ", alarm_name=" + alarm_name
				+ ", alarm_cause=" + alarm_cause + ", alarm_severity=" + alarm_severity + ", alarm_occurance_time="
				+ alarm_occurance_time + ", corrective_action=" + corrective_action + ", alarm_state=" + alarm_state
				+ "]";
	}
	

}
