package edu.csupomona.cs480.starbuzz.interfaces;

public interface SizeFactor {
	
	/**
	 * Sets size of beverage
	 * @param s			=	String to set size of beverage
	 */
	public void setSize(String s);
	
	/**
	 * Returns double with cost for beverage
	 */
	public double cost();
}
