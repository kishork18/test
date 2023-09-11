package com.masai.models;

public class Ride {

	private int rideId;
	private int userId;
	private String startLocation;
	private String endLocation;
	
	public Ride(int rideId, int userId, String startLocation, String endLocation) {
		this.rideId = rideId;
		this.userId = userId;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}
	
	public Ride() {}

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
		
	
}
