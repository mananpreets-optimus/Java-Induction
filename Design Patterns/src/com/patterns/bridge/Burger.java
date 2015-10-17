/**
 * Package com.patterns.bridge contains classes and interfaces for implementation
 * of Bridge design pattern.
 */
package com.patterns.bridge;

/**
 * Class Burger inherits Food
 */
public class Burger extends Food {

	/** type of cheese */
	private String cheeseType; 
	/** price of burger*/
	private float price;
	
	/**
	 * Constructor of Burger class
	 * @param cheeseType cheese type
	 * @param price price
	 * @param cookApi CookApi reference 
	 */
	public Burger(String cheeseType, float price, CookApi cookApi) {
		super(cookApi);
		this.cheeseType = cheeseType;
		this.price = price;
	}
	
	/**
	 * Method cook : for making burger
	 */
	@Override
	public void cook() {
		cookApi.makeBurger(cheeseType, price);
	}

}
