package edu.csupomona.cs480.starbuzz.drinks;

import edu.csupomona.cs480.starbuzz.interfaces.Coffee;
import edu.csupomona.cs480.starbuzz.interfaces.Recipe;

public class HouseBlend extends Coffee {
	private Recipe r;

	public HouseBlend(Recipe r){
		this.r = r;
	}
	
	public String getDescription() {
		return "House Blend";
	}

	public double cost() {
		return super.sf.cost() + 0.8;
	}

	public String prepare() {
		return "(" + getDescription() + ")\n" + r.prepare();
	}
}
