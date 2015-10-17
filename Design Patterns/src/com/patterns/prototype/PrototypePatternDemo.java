package com.patterns.prototype;

public class PrototypePatternDemo {
	   public static void main(String[] args) {
	      ItemCache.loadCache();

	      Item clonedItem = ItemCache.getItem("1");
	      System.out.println("Item : "+clonedItem.getType());
	      
	      Item clonedItem2 = ItemCache.getItem("2");
	      System.out.println("Item : "+clonedItem2.getType());
	      
	      Item clonedItem3 = ItemCache.getItem("3");
	      System.out.println("Item : "+clonedItem3.getType());
	   }
	}
