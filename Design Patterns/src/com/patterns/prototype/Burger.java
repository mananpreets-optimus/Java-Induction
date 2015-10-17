package com.patterns.prototype;

public class Burger extends Item {

	public Burger() {
		type = "Burger";
	}
	@Override
	void makeItem() {
		System.out.println("Making Burger");
	}

}
