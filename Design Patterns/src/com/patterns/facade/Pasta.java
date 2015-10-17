/**
 * Package com.patterns.facade contains classes and 
 * interfaces for implementation of Facade design pattern.
 */
package com.patterns.facade;

/**
 * Class Pasta implements FoodItems interface
 * and is used for making Pasta.
 */
public class Pasta implements FoodItems{

	/**
	 * Method make : used for making Pasta.
	 */
	@Override
	public void make() {
		System.out.println("Pasta is getting ready.");
	}

}
