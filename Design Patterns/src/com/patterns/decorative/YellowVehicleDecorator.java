package com.patterns.decorative;

public class YellowVehicleDecorator extends VehicleDecorator{

	public YellowVehicleDecorator(Vehicle decorativeVehicle) {
		super(decorativeVehicle);
	}
	public void create() {
		decorativeVehicle.create();
		setColor(decorativeVehicle);
	}
	public void setColor(Vehicle decorativeVehicle) {
		System.out.println("Vehicle color is red ");
	}
}
