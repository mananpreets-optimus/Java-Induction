package com.patterns.prototype;

public abstract class Item implements Cloneable{
	
	private String id;
	protected String type;
	
	abstract void makeItem();
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}

	public Object itemClone() {
		
		Object clone = null;
		
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
		
	}
}
