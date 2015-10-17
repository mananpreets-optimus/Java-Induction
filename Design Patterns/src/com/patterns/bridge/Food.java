/**
 * Package com.patterns.bridge contains classes and interfaces for implementation
 * of Bridge design pattern.
 */
package com.patterns.bridge;

/**
 * Class abstract Food for cooking food
 */
public abstract class Food {
	   protected CookApi cookApi;
	   
	   protected Food(CookApi cookApi){
	      this.cookApi = cookApi;
	   }
	   public abstract void cook();	
	}