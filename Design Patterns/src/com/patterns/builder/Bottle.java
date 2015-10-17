/**
 * Package com.patterns.builder: contains classes and interfaces for implementation of Builder design pattern.
 */
package com.patterns.builder;

/**
 * Class Bottle includes method pack which returns Bottle.
 */
public class Bottle implements Packing {

	/** Method pack() : type of packing.
	 * @return Bottle string "Bottle" 
	 */
	@Override
	public String pack() {
		return "Bottle";
	}

}
