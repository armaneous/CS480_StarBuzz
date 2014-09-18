package edu.csupomona.cs480.starbuzz.sizes;

import edu.csupomona.cs480.starbuzz.interfaces.SizeFactor;

public class TeaBased implements SizeFactor {
	private String size = "unknown";

	/**
	 * Constructor for implementing tea-based beverage size
	 * @param s			=	size of beverage
	 */
	public TeaBased(String s){
		setSize(s);
	}

	/**
	 * Returns cost of beverage
	 */
	public double cost() {
		if(size.equals("small"))
			return 0.2;
		else if(size.equals("medium"))
			return 0.5;
		else if(size.equals("large"))
			return 0.7;
		else
			System.err.println("ERROR: Size unknown");
		
		return 0;
	}

	/**
	 * Sets size of beverage
	 */
	public void setSize(String s) {
		size = s;
	}
}
