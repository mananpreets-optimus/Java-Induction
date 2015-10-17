/**
 * Package com.patterns.builder: contains classes and interfaces for implementation of Builder design pattern.
 */
package com.patterns.builder;

/**
 * Class coke inherits ColdDrink.
 */
public class Coke extends ColdDrink {

	/**
	 * Name of Cold drink.
	 * @return Coke String "Coke"
	 */
	@Override
	public String name() {
		return "Coke";
	}

	/**
	 * Price of Cold drink.
	 * @return Price price of coke
	 */
	@Override
	public float price() {
		return 35.0f;
	}

}
