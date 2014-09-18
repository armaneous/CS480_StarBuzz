package edu.csupomona.cs480.starbuzz.preparation;

import edu.csupomona.cs480.starbuzz.interfaces.Recipe;

public class CoffeeRecipe implements Recipe {

	/**
	 * Returns String describing recipe
	 */
	public String prepare() {
		String s = "brew coffee\n" +
				"process ingredients\n";
		return s;
	}

}
