package edu.csupomona.cs480.starbuzz.drinks;

import edu.csupomona.cs480.starbuzz.interfaces.Recipe;
import edu.csupomona.cs480.starbuzz.interfaces.Tea;

public class RedTea extends Tea {
	private Recipe r;

	public RedTea(Recipe r){
		this.r = r;
	}
	
	public String getDescription() {
		return "Red Tea";
	}

	public double cost() {
		return super.sf.cost() + 0.8;
	}

	public String prepare() {
		return "(" + getDescription() + ")\n" + r.prepare();
	}
}
