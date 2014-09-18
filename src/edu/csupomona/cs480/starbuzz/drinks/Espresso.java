package edu.csupomona.cs480.starbuzz.drinks;

import edu.csupomona.cs480.starbuzz.interfaces.Coffee;
import edu.csupomona.cs480.starbuzz.interfaces.Recipe;

public class Espresso extends Coffee {
	private Recipe r;

	public Espresso(Recipe r){
		this.r = r;
	}
	
	public String getDescription() {
		return "Espresso";
	}

	public double cost() {
		return super.sf.cost() + 1;
	}

	public String prepare() {
		return "(" + getDescription() + ")\n" + r.prepare();
	}
}
