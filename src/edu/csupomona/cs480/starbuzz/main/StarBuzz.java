/**
 * @author Andrew Armaneous
 * 
 * Description: Uses design patterns to accept orders for StarBuzz
 * 				coffee shop.
 */

package edu.csupomona.cs480.starbuzz.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import edu.csupomona.cs480.starbuzz.drinks.*;
import edu.csupomona.cs480.starbuzz.ingredients.*;
import edu.csupomona.cs480.starbuzz.interfaces.Beverage;
import edu.csupomona.cs480.starbuzz.preparation.*;
import edu.csupomona.cs480.starbuzz.sizes.*;

public class StarBuzz {
	
	private Map<String, Beverage> orders;
	
	public static void main(String[] args) {
		String[] order;
		Beverage drink;
		
		order = getOrderDetails();
		
		drink = evalDrink(order);

		// Print drink cost and recipe
		System.out.println("Total: $" + drink.cost() + "\n");
		System.out.println("Preparation:\n" + drink.prepare());
	}
	
	/**
	 * Evaluates input using array of strings
	 * @param order		=	String array used for ordering
	 * @return			=	drink order
	 */
	private static Beverage evalDrink(String[] order) {
		Beverage drink = null;
		
		// If order commands are greater than two to ensure name and size
		if(order.length >= 2) {
			// Check what first command is to determine beverage type
			switch(order[0]){
				case "espresso":
					drink = new Espresso(new CoffeeRecipe());
					drink.setSizeFactor(new CoffeeBased(order[1]));
					if(order.length > 2)
						drink = evalCondiments(order, drink, 2);
					break;
				// If decaf, check if pure decaf or decafienated mixed drink
				case "decaf":
					drink = decafOrder(order);
					break;
				case "houseblend":
					drink = new HouseBlend(new CoffeeRecipe());
					drink.setSizeFactor(new CoffeeBased(order[1]));
					if(order.length > 2)
						drink = evalCondiments(order, drink, 2);
					break;
				case "mocha":
					drink = new Espresso(new CoffeeRecipe());
					drink.setSizeFactor(new CoffeeBased(order[1]));
					drink = new Chocolate(drink);
					if(order.length > 2)
						drink = evalCondiments(order, drink, 2);
					break;
				case "latte":
					drink = new Espresso(new CoffeeMilkRecipe());
					drink.setSizeFactor(new CoffeeBased(order[1]));
					drink = new Milk(drink);
					if(order.length > 2)
						drink = evalCondiments(order, drink, 2);
					break;
				case "cappuccino":
					drink = new Espresso(new CoffeeRecipe());
					drink.setSizeFactor(new CoffeeBased(order[1]));
					drink = new WhipCream(drink);
					if(order.length > 2)
						drink = evalCondiments(order, drink, 2);
					break;
				// Check if tea latte
				case "tea":
					drink = new RedTea(new TeaMilkRecipe());
					if(order.length > 2)
						drink.setSizeFactor(new TeaBased(order[2]));
					else{
						System.err.println("ERROR: Invalid order, name or size not listed properly");
						System.exit(0);
					}
					drink = new Milk(drink);
					if(order.length > 3)
						drink = evalCondiments(order, drink, 3);
					break;
				// Assume tea beverage otherwise
				default:
					drink = teaOrder(order);
					break;
			}
		}
		// Invalid commands if length of commands is less than 2
		else {
			System.err.println("ERROR: Invalid order, too few commands");
			System.exit(0);
		}
		
		return drink;
	}
	
	private void setOrderOptions(){
		orders = new HashMap<String, Beverage>();

		orders.put("espresso", new Espresso(new CoffeeRecipe()));
		orders.put("decaf", new Decaf(new CoffeeRecipe()));
		orders.put("houseblend", new HouseBlend(new CoffeeRecipe()));
		orders.put("mocha", new Chocolate(new Espresso(new CoffeeRecipe())));
		orders.put("latte", new Espresso(new CoffeeMilkRecipe()));
		orders.put("cappuccino", new WhipCream(new Espresso(new CoffeeRecipe())));
		orders.put("tea", new RedTea(new TeaMilkRecipe()));
		orders.put("green", new GreenTea(new TeaRecipe()));
		orders.put("red", new RedTea(new TeaRecipe()));
		orders.put("white", new WhiteTea(new TeaRecipe()));
		orders.put("flower", new Jasmine(new GreenTea(new TeaRecipe())));
		orders.put("ginger", new Ginger(new Espresso(new TeaRecipe())));
	}
	
	private Beverage beverageOrder(String s){
		if(orders.containsKey(s))
			return orders.get(s);
		return null;
	}

	/**
	 * Evaluate all commands for additions to beverage
	 * @param order		=	order commands to be evaluated
	 * @param drink		=	beverage original state
	 * @param startIndex=	start index in order commands
	 * @return			=	return beverage modified state
	 */
	private static Beverage evalCondiments(String[] order, Beverage drink, int startIndex) {
		for(int i = startIndex; i < order.length; i++){
			switch(order[i]){
				case "chocolate":
					drink = new Chocolate(drink);
					break;
				case "ginger":
					drink = new Ginger(drink);
					break;
				case "jasmine":
					drink = new Jasmine(drink);
					break;
				case "milk":
					drink = new Milk(drink);
					break;
				case "whipcream":
					drink = new WhipCream(drink);
					break;
				default:
					break;
			}
		}
		return drink;
	}

	/**
	 * Evaluate tea order
	 * @param order		=	order commands
	 * @return			=	return beverage
	 */
	private static Beverage teaOrder(String[] order) {
		Beverage drink = null;
		
		// Tea must be at least 3 commands, checks if orders size is greater than 2
		if(order.length < 3) {
			System.err.println("ERROR: Invalid order, name or size not listed properly");
			System.exit(0);
		}
		
		switch(order[0]){
			case "green":
				drink = new GreenTea(new TeaRecipe());
				drink.setSizeFactor(new TeaBased(order[2]));
				break;
			case "red":
				drink = new RedTea(new TeaRecipe());
				drink.setSizeFactor(new TeaBased(order[2]));
				break;
			case "white":
				drink = new WhiteTea(new TeaRecipe());
				drink.setSizeFactor(new TeaBased(order[2]));
				break;
			case "flower":
				drink = new GreenTea(new TeaRecipe());
				drink.setSizeFactor(new TeaBased(order[2]));
				drink = new Jasmine(drink);
				break;
			case "ginger":
				drink = new GreenTea(new TeaRecipe());
				drink.setSizeFactor(new TeaBased(order[2]));
				drink = new Ginger(drink);
				break;
			default:
				drink = null;
				System.err.println("ERROR: Invalid order, beverage does not exist");
				System.exit(0);
				break;
		}
		
		// If order commands are greater than 3, check for beverage condiments
		if(order.length > 3)
			drink = evalCondiments(order, drink, 3);
		
		return drink;
	}

	/**
	 * Evaluate decaf orders
	 * @param drink		=	original beverage state	
	 * @param order		=	order commands
	 * @return			=	return modified beverage
	 */
	private static Beverage decafOrder(String[] order) {
		Beverage drink = null;
		
		// If second command is a size, process order
		if(isSize(order[1])){
			drink = new Decaf(new CoffeeRecipe());
			drink.setSizeFactor(new CoffeeBased(order[1]));
			if(order.length > 2)
				drink = evalCondiments(order, drink, 2);
			return drink;
		}
		
		// Decaf mix must be at least 3 commands, checks if orders size is greater than 2
		if(order.length < 3) {
			System.err.println("ERROR: Invalid order, name or size not listed properly");
			System.exit(0);
		}

		// Check type of decaf order
		switch(order[1]){
			case "mocha":
				drink = new Decaf(new CoffeeRecipe());
				drink.setSizeFactor(new CoffeeBased(order[2]));
				drink = new Chocolate(drink);
				break;
			case "latte":
				drink = new Decaf(new CoffeeMilkRecipe());
				drink.setSizeFactor(new CoffeeBased(order[2]));
				break;
			case "cappuccino":
				drink = new Decaf(new CoffeeRecipe());
				drink.setSizeFactor(new CoffeeBased(order[2]));
				drink = new WhipCream(drink);
				break;
			default:
				drink = null;
				System.err.println("ERROR: Invalid order, beverage does not exist");
				System.exit(0);
				break;
		}
		
		// Evaluate condiment commands if there are any
		if(order.length > 3)
			drink = evalCondiments(order, drink, 3);
		
		return drink;
	}

	/**
	 * Checks if string is a size
	 * @param size		=	String to be read
	 * @return			=	true if String is a size, false otherwise
	 */
	private static boolean isSize(String size) {
		return size.equals("small") || size.equals("medium") || size.equals("large");
	}
	
	/**
	 * Reads line of input from console
	 * @return			=	returns line of input as a single String 
	 */
	private static String getOrder(){
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.println("Place your order in the following format:\n" +
				"<beverage name> <size> [<ingredient 1> <ingredient 2> <ingredient 3> ...]\n");
		s = sc.nextLine();
		sc.close();
		return s;
	}
	
	/**
	 * Uses getOrder() method to split string into commands
	 * @return			=	returns commands as String array
	 */
	private static String[] getOrderDetails(){
		return getOrder().toLowerCase().split("\\s+");
	}
}
