/**
 * Package com.patterns.bridge contains classes and interfaces for implementation
 * of Bridge design pattern.
 */
package com.patterns.bridge;

/**
 * Class BridgePatternDemo : demo class to show implementation of bridge design pattern.
 */
public class BridgePatternDemo {
	
	/**
	 * main method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Food nonVeg = new Burger("Extra Cheese", 40.0f, new NonVegBurgerExtraCheese());
		nonVeg.cook();
		
		Food veg = new Burger("Normal Cheese", 35.0f, new VegBurgerExtraCheese());
		veg.cook();
	} 
}
