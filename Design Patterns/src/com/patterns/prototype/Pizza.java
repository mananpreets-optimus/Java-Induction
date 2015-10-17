package com.patterns.prototype;

public class Pizza extends Item {

	public Pizza() {
		type = "Pizza";
	}
	@Override
	void makeItem() {
		System.out.println("Making Pizza");
	}

}
