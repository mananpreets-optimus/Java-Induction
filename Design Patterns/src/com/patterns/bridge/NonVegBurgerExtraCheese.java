/**
 * Package com.patterns.bridge contains classes and interfaces for implementation
 * of Bridge design pattern.
 */
package com.patterns.bridge;

/**
 * Class NonVegBurgerExtraCheese implements CookApi
 */
public class NonVegBurgerExtraCheese implements CookApi{

	/**
	 * Method makeBurger for making Burger.
	 */
	@Override
	public void makeBurger(String cheeseType, float price) {
		System.out.println("Making Non Vegetable with " + cheeseType + ". Amount = " + price );
		
	}

}
