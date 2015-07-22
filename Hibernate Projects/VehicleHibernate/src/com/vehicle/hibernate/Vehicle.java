package com.vehicle.hibernate;

public class Vehicle {
	private int Id;
	private String manufacturerName;
	private String vehicleName;
	
	public Vehicle() {
		
	}
	public Vehicle(String manufacturerName, String vehicleName) {
		this.manufacturerName = manufacturerName;
		this.vehicleName = vehicleName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int vehicleId) {
		this.Id = vehicleId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}
