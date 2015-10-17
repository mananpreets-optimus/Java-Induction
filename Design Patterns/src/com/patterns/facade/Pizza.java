/**
 * Package com.patterns.facade contains classes and 
 * interfaces for implementation of Facade design pattern.
 */
package com.patterns.facade;

/**
 * Class Pizza implements FoodItems interface
 * and is used for making Pizza.
 */
public class Pizza implements FoodItems{

	/**
	 * Method make : used for making Pizza.
	 */
	@Override
	public void make() {
		System.out.println("Pizza is getting ready.");
	}
}
