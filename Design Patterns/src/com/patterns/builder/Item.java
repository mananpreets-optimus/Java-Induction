/**
 * Package com.patterns.builder: contains classes and interfaces for implementation of Builder design pattern.
 */
package com.patterns.builder;

/**
 * Interface Item includes methods name, pack and price.
 */
public interface Item {

	/** Method name() : name of item.*/
	public String name();
	/** Method pack() : type of packing.*/
	public Packing packing();
	/** Method price() : price of product.*/
	public float price();
}
