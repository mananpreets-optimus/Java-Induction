/**
 * Package com.patterns.builder: contains classes and interfaces for implementation of Builder design pattern.
 */
package com.patterns.builder;

/**
 * Abstract Class Burger implements interface Item 
 */
public abstract class Burger implements Item {

	/** Method pack() : type of packing.
	 * @return Wrapper() wrapper class object 
	 */
	@Override
	public Packing packing() {
		return new Wrapper();
	}

	/** Method name : price of product.*/
	@Override
	public abstract float price();

}
