package com.patterns.decorative;

public abstract class VehicleDecorator implements Vehicle {
	
	protected Vehicle decorativeVehicle;
	
	public VehicleDecorator(Vehicle decorativeVehicle) {
		this.decorativeVehicle = decorativeVehicle;
	}
	
	public void create() {
		decorativeVehicle.create();
	}

}
