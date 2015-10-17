/**
 * Package com.patterns.facade contains classes and 
 * interfaces for implementation of Facade design pattern.
 */
package com.patterns.facade;


/**
 * Class Burger implements FoodItems interface
 * and is used for making burger.
 */
public class Burger implements FoodItems{

	/**
	 * Method make : used for making burger.
	 */
	@Override
	public void make() {
		System.out.println("Burger is getting ready.");
	}
}
