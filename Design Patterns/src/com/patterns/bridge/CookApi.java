/**
 * Package com.patterns.bridge contains classes and interfaces for implementation
 * of Bridge design pattern.
 */
package com.patterns.bridge;

/**
 * Interface CookApi for making burger
 */
public interface CookApi {
	
	public void makeBurger(String cheeseType, float price);
}
