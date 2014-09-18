package edu.csupomona.cs480.starbuzz.preparation;

import edu.csupomona.cs480.starbuzz.interfaces.Recipe;

public class TeaRecipe implements Recipe {

	/**
	 * Returns String describing recipe
	 */
	public String prepare() {
		String s = "add water\n" +
				"add tea bag\n";
		return s;
	}

}
