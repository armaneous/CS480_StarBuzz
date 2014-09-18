package edu.csupomona.cs480.starbuzz.drinks;

import edu.csupomona.cs480.starbuzz.interfaces.Coffee;
import edu.csupomona.cs480.starbuzz.interfaces.Recipe;

public class Decaf extends Coffee {
	private Recipe r;

	public Decaf(Recipe r){
		this.r = r;
	}
	
	public String getDescription() {
		return "Decaf";
	}

	public double cost() {
		return super.sf.cost() + 0.5;
	}

	public String prepare() {
		return "(" + getDescription() + ")\n" + r.prepare();
	}
}
