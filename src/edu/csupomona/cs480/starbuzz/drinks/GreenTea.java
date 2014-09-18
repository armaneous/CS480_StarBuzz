package edu.csupomona.cs480.starbuzz.drinks;

import edu.csupomona.cs480.starbuzz.interfaces.Recipe;
import edu.csupomona.cs480.starbuzz.interfaces.Tea;

public class GreenTea extends Tea {
	private Recipe r;

	public GreenTea(Recipe r){
		this.r = r;
	}
	
	public String getDescription() {
		return "Green Tea";
	}

	public double cost() {
		return super.sf.cost() + 1;
	}

	public String prepare() {
		return "(" + getDescription() + ")\n" + r.prepare();
	}
}
