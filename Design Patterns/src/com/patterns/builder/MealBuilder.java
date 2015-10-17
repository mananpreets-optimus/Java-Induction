package com.patterns.builder;

public class MealBuilder {

	/**
	 * Method prepare veg meal with coke.
	 * @return meal veg meal with coke
	 */
	public Meal prepareVegMealWithCoke() {
		
		Meal meal = new Meal();
		meal.addItems(new VegBurger());
		meal.addItems(new Coke());
		return meal;
	}
	
	/**
	 * Method prepare non veg meal with coke.
	 * @return meal non veg meal with coke
	 */
	public Meal prepareNonVegMealWithCoke() {
		
		Meal meal = new Meal();
		meal.addItems(new NonVegBurger());
		meal.addItems(new Coke());
		return meal;
	}
	
	/**
	 * Method prepare veg meal with coke.
	 * @return meal veg meal with coke
	 */
	public Meal prepareVegMealWithPepsi() {
		
		Meal meal = new Meal();
		meal.addItems(new VegBurger());
		meal.addItems(new Pepsi());
		return meal;
	}
	
	/**
	 * Method prepare non veg meal with pepsi
	 * @return meal non veg meal with pepsi
	 */
	public Meal prepareNonVegMealWithPepsi() {
		
		Meal meal = new Meal();
		meal.addItems(new NonVegBurger());
		meal.addItems(new Pepsi());
		return meal;
	}
}
