package com.patterns.prototype;

public class HotDog extends Item {

	public HotDog() {
		type = "HotDog";
	}
	@Override
	void makeItem() {
		System.out.println("Making HotDog");
	}

}
