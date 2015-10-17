/**
 * Package com.patterns.bridge contains classes and interfaces for implementation
 * of Bridge design pattern.
 */
package com.patterns.bridge;

/**
 * Class VegBurgerExtraCheese implements CookApi
 */
public class VegBurgerExtraCheese implements CookApi {

	/**
	 * Method for making burger
	 */
	@Override
	public void makeBurger(String cheeseType, float price) {
		System.out.println("Making Vegetable with " + cheeseType + ". Amount = " + price );
		
	}

}
