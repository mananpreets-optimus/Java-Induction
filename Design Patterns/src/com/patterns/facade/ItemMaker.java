/**
 * Package com.patterns.facade contains classes and 
 * interfaces for implementation of Facade design pattern.
 */
package com.patterns.facade;

/**
 * Class ItemMaker used for making different food items.
 */
public class ItemMaker {

	/** Food item : burger*/
	private FoodItems burger;
	/** Food item : pizza*/
	private FoodItems pizza;
	/** Food item : pasta*/
	private FoodItems pasta;
	
	/**
	 * Constructor : initializes class variables.
	 */
	public ItemMaker() {
		burger = new Burger();
		pizza = new Pizza();
		pasta = new Pasta();
	}
	
	/**
	 * Method makePizza : For making pizza.
	 */
	public void makePizza() {
		pizza.make();
	}
	
	/**
	 * Method makePasta : For making pasta.
	 */
	public void makePasta() {
		pasta.make();
	}
	
	/**
	 * Method makeBurger : For making burger.
	 */
	public void makeBurger() {
		burger.make();
	}
}
