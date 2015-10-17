package com.patterns.decorative;

public class DecorativePatternDemo {

	public static void main(String[] args) {
		Vehicle car = new Car();
		Vehicle redCar = new RedVehicleDecorator(car);
		Vehicle bike = new Bike();
		Vehicle yellowBike = new YellowVehicleDecorator(bike);
		Vehicle truck = new Truck();
		Vehicle redTruck = new RedVehicleDecorator(truck);
		System.out.println("**********************************");
		System.out.println("Normal Bike with Default color");
		bike.create();
		System.out.println("**********************************");
		yellowBike.create();
		System.out.println("**********************************");
		System.out.println("Normal Car with Default color");
		car.create();
		System.out.println("**********************************");
		redCar.create();
		System.out.println("**********************************");
		System.out.println("Normal Truck with Default color");
		truck.create();
		System.out.println("**********************************");
		redTruck.create();
		
	   }
}
