package edu.csupomona.cs480.starbuzz.preparation;

import edu.csupomona.cs480.starbuzz.interfaces.Recipe;

public class CoffeeMilkRecipe implements Recipe {

	/**
	 * Returns String describing recipe
	 */
	public String prepare() {
		String s = "steam milk\n" +
				"brew coffee\n" +
				"mix steamed milk and coffee\n" +
				"process ingredients\n";
		return s;
	}

}
