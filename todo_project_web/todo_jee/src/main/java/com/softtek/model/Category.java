package com.softtek.model;

public enum Category {
	
	TODAY	(1),
	FOLLOWING	(2),
	SOMEDAY	(3);
	
	private final int categoryCode;
	
	private Category(int categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	public static Category valueOf(int categorynumber) {
		for(Category c : values()) {
			if(c.categoryCode == categorynumber) {
				return c; 
			}
		}
		return null;
	}
}
