/**
 * Package com.patterns.builder: contains classes and interfaces for implementation of Builder design pattern.
 */
package com.patterns.builder;

/**
 * Class VegBurger inherits Burger 
 */
public class VegBurger extends Burger{

	/**
	 * Name of Burger.
	 */
	@Override
	public String name() {
		return "Veg Burger";
	}

	/**
	 * Price of Burger.
	 */
	@Override
	public float price() {
		return 30.0f;
	}

}
