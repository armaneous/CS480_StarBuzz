package edu.csupomona.cs480.starbuzz.interfaces;


public interface Beverage {


	/**
	 * Returns String with description of item
	 */
	public abstract String getDescription();

	/**
	 * Returns double with cost for beverage
	 */
	public abstract double cost();

	/**
	 * Returns String with recipe instructions
	 */
	abstract public String prepare();

	/**
	 * Sets the size of the beverage
	 */
	public void setSizeFactor(SizeFactor sf);
	
}
