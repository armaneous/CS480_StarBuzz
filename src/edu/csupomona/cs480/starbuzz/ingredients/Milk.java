package edu.csupomona.cs480.starbuzz.ingredients;

import edu.csupomona.cs480.starbuzz.interfaces.*;

public class Milk extends Ingredient {
	private SizeFactor sf;
	private Beverage drink;

	/**
	 * Constructor creates condiment using beverage
	 * @param b			=	initial beverage
	 */
	public Milk(Beverage b){
		drink = b;
	}

	/**
	 * Returns String with name of condiment
	 */
	public String getDescription() {
		return "milk";
	}

	/**
	 * Returns new cost of beverage using old cost and current charge
	 */
	public double cost() {
		return drink.cost() + 0.3;
	}

	/**
	 * Returns and adds new item to recipe for beverage
	 */
	public String prepare() {
		return drink.prepare() + "add " + getDescription() + "\n";
	}

	/**
	 * Sets size of beverage
	 */
	public void setSizeFactor(SizeFactor sf) { this.sf = sf; }
}
