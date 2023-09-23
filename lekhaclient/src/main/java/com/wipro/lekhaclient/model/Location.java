package com.wipro.lekhaclient.model;

public class Location {
	
	private double latitude;
	
	private double longitude;
	
	private String region_state;
	
	private int oru_id; 
	
	private String oru_name;
	
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getRegion_state() {
		return region_state;
	}

	public void setRegion_state(String region_state) {
		this.region_state = region_state;
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
	
}
