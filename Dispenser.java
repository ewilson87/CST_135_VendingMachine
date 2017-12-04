/**Program: Vending Machine
 * File: Dispenser.java
 * Summary: Dispenser class for vending machine program
 * Authors: Evan Wilson, Jake Babcock, Robert Nichols
 * Date: December 3, 2017
 **/

import java.util.*;

public class Dispenser extends Product {

	//default method with no constructors
	public Dispenser() {
	}

	//begin main method
	public static void main(String[] args){
		displayProducts();
	}


	public static void displayProducts(){
	//create products of each type
	Stack<Drink> drinks1 = new Stack<>();
	for (int i = 0; i < 20; i++) {
		Drink drink1 = new Drink("Cola", "Coke", 1.50, 12, 210, 10, true, false);
		drinks1.push(drink1);
	}

	Stack<Drink> drinks2 = new Stack<>();
	for (int i = 0; i < 20; i++) {
		Drink drink2 = new Drink("Root Beer", "Mug", 1.50, 12, 210, 10, false, false);
		drinks2.push(drink2);
	}

	Stack<Candy> candys1 = new Stack<>();
	for (int i = 0; i < 20; i++) {
		Candy candy1 = new Candy("Chocolate", "Hersheys", 1.0, "Candy Bar", "Dark", 1, 100, 320);
		candys1.push(candy1);
	}

	Stack<Candy> candys2 = new Stack<>();
	for (int i = 0; i < 20; i++) {
		Candy candy2 = new Candy("Skittles", "Wrigley", 1.0,"Chewy", "Tropical", 2.17, 100, 250);
		candys2.push(candy2);
	}

	Stack<Chips> chips1 = new Stack<>();
	for (int i = 0; i < 20; i++) {
		Chips chip1 = new Chips("Cheetos", "Frito-Lay", .75, "Hot", "Regular", 1, 140);
		chips1.push(chip1);
	}

	Stack<Chips> chips2 = new Stack<>();
	for (int i = 0; i < 20; i++) {
		Chips chip2 = new Chips("Doritos", "Frito-Lay", .75, "Nacho Cheese", "Baked", 1, 90);
		chips2.push(chip2);
	}

	Stack<Gum> gums1 = new Stack<>();
	for (int i = 0; i < 20; i++) {
		Gum gum1 = new Gum("Juicey Fruit", "Wrigley's", 1.00, "Fruit", 1, 20, false, 15, false);
		gums1.push(gum1);
	}

	Stack<Gum> gums2 = new Stack<>();
	for (int i = 0; i < 20; i++) {
		Gum gum2 = new Gum("White", "Orbit", 1.00, "Bubblemint", 1, 10, true, 5, true);
		gums2.push(gum2);
	}

	//display drinks to console
	System.out.println("-----------------------------------------------------  DRINKS  ----------------------------" +
			"------------------------");
	System.out.printf("%-15s%-15s%-12s%-12s%-12s%-12s%-12s%-12s%-12s", "Brand", "Name", "Price", "Ounces",
			"Calories", "Sugar", "Caffeine", "Healthy", "Quantity Left\n");
	System.out.println("----------------------------------------------------------------------------------------" +
			"---------------------------");

	System.out.println(drinks1.peek() + "" + drinks1.size());
	System.out.println(drinks2.peek() + "" + drinks1.size());

	//display gums to console
	System.out.println();
	System.out.println("------------------------------------------------------------  GUM  ------------------------------" +
			"------------------------------");
	System.out.printf("%-15s%-15s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s", "Brand", "Name", "Price", "Ounces", "Flavor",
			"Pieces", "Sugar Free", "Calories", "Whitening", "Quantity Left\n");
	System.out.println("----------------------------------------------------------------------------------------------" +
			"---------------------------------");

	System.out.println(gums1.peek() + "" + gums1.size());
	System.out.println(gums2.peek() + "" + gums2.size());

	//display chips to console
	System.out.println();
	System.out.println("------------------------------------------------  CHIPS  ------------------------------" +
			"-------------------");
	System.out.printf("%-15s%-15s%-15s%-12s%-12s%-12s%-12s%-12s", "Brand", "Name", "Flavor", "Type", "Price",
			"Ounces", "Calories", "Quantity Left\n");
	System.out.println("-----------------------------------------------------------------------------------" +
			"-----------------------");

	System.out.println(chips1.peek() + "" + chips1.size());
	System.out.println(chips2.peek() + "" + chips2.size());

	//display candy to console
	System.out.println();
	System.out.println("------------------------------------------------------  CANDY  -------------------------" +
			"------------------------------");
	System.out.printf("%-15s%-15s%-15s%-12s%-12s%-12s%-12s%-12s%-12s", "Brand", "Name", "Type", "Flavor", "Price",
			"Ounces", "Calories", "Sugar", "Quantity Left\n");
	System.out.println("-----------------------------------------------------------------------------------" +
			"-----------------------------------");

	System.out.println(candys1.peek() + "" + candys1.size());
	System.out.println(candys2.peek() + "" + candys2.size());

	}
}

