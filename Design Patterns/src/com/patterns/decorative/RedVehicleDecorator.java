package com.patterns.decorative;

public class RedVehicleDecorator extends VehicleDecorator{

	public RedVehicleDecorator(Vehicle decorativeVehicle) {
		super(decorativeVehicle);
	}
	public void create() {
		decorativeVehicle.create();
		setColor(decorativeVehicle);
	}
	public void setColor(Vehicle decorativeVehicle) {
		System.out.println("Vehicle color is yellow ");
	}
}
