package com.wipro.lekhaclient.model;

import java.util.List;

public class AlarmInfo {
	
	private String region_id;
	
	private List<Alarm> alarmInfo;

	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	public List<Alarm> getAlarmInfo() {
		return alarmInfo;
	}

	public void setAlarmInfo(List<Alarm> alarmInfo) {
		this.alarmInfo = alarmInfo;
	}
	
	
}
