/**
 * Package com.patterns.builder: contains classes and interfaces for implementation of Builder design pattern.
 */
package com.patterns.builder;

/**
 * Class ColdDrink implements Item
 */
public abstract class ColdDrink implements Item {

	/**
	 * Packing type of cold drink.
	 */
	@Override
	public Packing packing() {
		return new Bottle();
	}

	/**
	 * Price of cold drink.
	 */
	@Override
	public abstract float price();

}
