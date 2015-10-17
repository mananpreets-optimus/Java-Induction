package com.patterns.builder;

/**
 * Class NonVegBurger extends Burger
 */
public class NonVegBurger extends Burger {

	/**
	 * Name of Burger.
	 */
	@Override
	public String name() {
		return "Chicken Burger";
	}

	/**
	 * Price of Burger.
	 */
	@Override
	public float price() {
		return 50.0f;
	}

}
