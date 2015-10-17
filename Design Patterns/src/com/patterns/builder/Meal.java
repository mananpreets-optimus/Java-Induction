/**
 * Package com.patterns.builder: contains classes and interfaces for implementation of Builder design pattern.
 */
package com.patterns.builder;

import java.util.List;
import java.util.ArrayList;

/**
 * Class Meal : used for Making meal.
 */
public class Meal {

	/** items list*/
	private List<Item> items = new ArrayList<Item>();
	
	/**
	 * Method addItems : used to add items to list.
	 * @param item
	 */
	public void addItems(Item item) {
		items.add(item);
	}
	
	/**
	 * Method getCost : used to get cost of item.
	 * @return cost cost of item.
	 */
	public float getCost() {
		float cost = 0.0f;
		
		for(Item item : items) {
			cost += item.price();
		}
		return cost;
	}
	
	/**
	 * Method showItems : used to display item, its price and packing.
	 */
	public void showItems() {
		for(Item item : items) {
		System.out.print(" Item : " +item.name());
		System.out.print(" Price : " + item.price());
		System.out.println(" Packing : " + item.packing().pack());
		
		}
	}
	
}
