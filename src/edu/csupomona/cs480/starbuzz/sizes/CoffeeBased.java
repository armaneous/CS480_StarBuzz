package edu.csupomona.cs480.starbuzz.sizes;

import edu.csupomona.cs480.starbuzz.interfaces.SizeFactor;

public class CoffeeBased implements SizeFactor {
	private String size = "unknown";

	/**
	 * Constructor for implementing coffee-based beverage size
	 * @param s			=	size of beverage
	 */
	public CoffeeBased(String s) {
		setSize(s);
	}

	/**
	 * Returns cost of beverage
	 */
	public double cost() {
		if(size.equals("small"))
			return 0.4;
		else if(size.equals("medium"))
			return 0.7;
		else if(size.equals("large"))
			return 1;
		else
			System.err.println("ERROR: Size unknown");
		
		return 0;
	}
	
	/**
	 * Sets size of beverage
	 */
	public void setSize(String s){
		size = s;
	}
}
