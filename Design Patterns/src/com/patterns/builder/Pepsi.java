/**
 * Package com.patterns.builder: contains classes and interfaces for implementation of Builder design pattern.
 */
package com.patterns.builder;

/**
 * Class Pepsi inherits ColdDrink 
 */
public class Pepsi extends ColdDrink{

	/**
	 * Name of ColdDrink.
	 */
	@Override
	public String name() {
		return "Pepsi";
	}

	/**
	 * Price of ColdDrink.
	 */
	@Override
	public float price() {
		return 40.0f;
	}

}
