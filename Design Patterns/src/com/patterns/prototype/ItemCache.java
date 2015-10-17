package com.patterns.prototype;

import java.util.Hashtable;

public class ItemCache {
	private static Hashtable<String, Item> itemMap = new Hashtable<String, Item>();
	
		public static Item getItem(String itemId) {
			Item cachedItem = itemMap.get(itemId);
			return (Item) cachedItem.itemClone();
	    }
		
		public static void loadCache() {
			Burger burger = new Burger();
			burger.setId("1");
			itemMap.put(burger.getId(), burger);
			
			Pizza pizza = new Pizza();
			pizza.setId("2");
			itemMap.put(pizza.getId(), pizza);
			
			HotDog hotDog = new HotDog();
			hotDog.setId("3");
			itemMap.put(hotDog.getId(), hotDog);
			
		}

}
