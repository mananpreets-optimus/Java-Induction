/**
 * Package com.patterns.builder: contains classes and interfaces for implementation of Builder design pattern.
 */
package com.patterns.builder;

/**
 * Class Wrapper includes method pack which returns Wrapper.
 */
public class Wrapper implements Packing {

	/** Method pack() : type of packing.
	 * @return Wrapper String "Wrapper"
	 */
	@Override
	public String pack() {
		return "Wrapper";
	}

}
