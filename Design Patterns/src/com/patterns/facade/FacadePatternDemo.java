/**
 * Package com.patterns.facade contains classes and 
 * interfaces for implementation of Facade design pattern.
 */
package com.patterns.facade;

/**
 * Use the facade to make various food items.
 */
public class FacadePatternDemo {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		ItemMaker itemMaker = new ItemMaker();
		itemMaker.makeBurger();
		itemMaker.makePasta();
		itemMaker.makePizza();
	}
}
