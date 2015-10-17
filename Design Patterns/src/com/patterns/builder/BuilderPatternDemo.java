/**
 * Package com.patterns.builder: contains classes and interfaces for implementation of Builder design pattern.
 */
package com.patterns.builder;

/**
 * Class BuilderPatternDemo uses MealBuilder Class to demonstrate builder pattern.
 */
public class BuilderPatternDemo {
	
	/**
	 * Method main : that uses MealBuilder class to show items and price of each meal.
	 * @param args
	 */
	public static void main(String args[]) {
		
		MealBuilder mealBuilder = new MealBuilder();
		Meal nonVegMealWithCoke = mealBuilder.prepareNonVegMealWithCoke();
		Meal vegMealWithCoke = mealBuilder.prepareVegMealWithCoke();
		Meal nonVegMealWithPepsi = mealBuilder.prepareNonVegMealWithPepsi();
		Meal vegMealWithPepsi = mealBuilder.prepareVegMealWithPepsi();
		System.out.println("\n****************************************************");
		System.out.println("Non Veg Meal With Coke");
		nonVegMealWithCoke.showItems();
		System.out.println("Total Cost : Rs "+nonVegMealWithCoke.getCost());
		
		System.out.println("\n****************************************************");
		System.out.println("Veg Meal With Coke");
		vegMealWithCoke.showItems();
		System.out.println("Total Cost : Rs "+vegMealWithCoke.getCost());
		
		System.out.println("\n****************************************************");
		System.out.println("Non Veg Meal With Pepsi");
		nonVegMealWithPepsi.showItems();
		System.out.println("Total Cost : Rs "+nonVegMealWithPepsi.getCost());
		
		System.out.println("\n****************************************************");
		System.out.println("Veg Meal With Pepsi");
		vegMealWithPepsi.showItems();
		System.out.println("Total Cost : Rs "+vegMealWithPepsi.getCost());
		System.out.println("\n****************************************************");
	}

}
