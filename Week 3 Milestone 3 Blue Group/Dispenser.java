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
		for (int i = 0; i < 15; i++) {
			Drink drink1 = new Drink("Root Beer", "Mug", 2.0, 20, 320, 18, false, false);
			drinks1.push(drink1);
		}
		Stack<Drink> drinks2 = new Stack<>();
		for (int i = 0; i < 10; i++) {
			Drink drink2 = new Drink("Root Beer", "Mug", 1.50, 12, 210, 10, false, false);
			drinks2.push(drink2);
		}

		Stack<Drink> drinks3 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Drink drink3 = new Drink("Cola", "Coke", 1.50, 12, 210, 10, true, false);
			drinks3.push(drink3);
		}

		//create ArrayList to store drink stacks and sort
		ArrayList<Comparable> drinks = new ArrayList<>();
		drinks.add((drinks1.peek()) + "" + drinks1.size());
		drinks.add(drinks2.peek() + "" + drinks2.size());
		drinks.add(drinks3.peek() + "" + drinks3.size());
		Collections.sort(drinks);

		Stack<Snack> candys1 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Snack candy1 = new Candy("Chocolate", "Hershey", 1.0, "Candy Bar", "Dark", 1, 100, 320);
			candys1.push(candy1);
		}

		Stack<Snack> candys2 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Snack candy2 = new Candy("Skittles", "Wrigley's", 1.5,"Chewy", "FaveReds", 4.34, 66, 480);
			candys2.push(candy2);
		}

		Stack<Snack> candys3 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Snack candy3 = new Candy("Skittles", "Wrigley's", 1.0,"Chewy", "Tropical", 2.17, 33, 240);
			candys3.push(candy3);
		}

		//create ArrayList to store candy stacks and sort
		ArrayList<Comparable> candys = new ArrayList<>();
		candys.add(candys1.peek() + "" + candys1.size());
		candys.add(candys2.peek() + "" + candys2.size());
		candys.add(candys3.peek() + "" + candys3.size());
		Collections.sort(candys);

		Stack<Snack> chips1 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Snack chip1 = new Chips("Cheetos", "Frito-Lay", .75, "Hot", "Regular", 1, 140);
			chips1.push(chip1);
		}

		Stack<Snack> chips2 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Snack chip2 = new Chips("Fritos", "Frito-Lay", .75, "Chili", "Corn Chips", 1, 160);
			chips2.push(chip2);
		}

		Stack<Snack> chips3 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Snack chip3 = new Chips("Doritos", "Frito-Lay", .75, "Cool Ranch", "Baked", 1, 90);
			chips3.push(chip3);
		}

		//create ArrayList to store chips stacks and sort
		ArrayList<Comparable> chips = new ArrayList<>();
		chips.add(chips1.peek() + "" + chips1.size());
		chips.add(chips2.peek() + "" + chips2.size());
		chips.add(chips3.peek() + "" + chips3.size());
		Collections.sort(chips);

		Stack<Snack> gums1 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Snack gum1 = new Gum("Juicey Fruit", "Wrigley's", 1.00, "Fruit", .1, 20, false, 15, false);
			gums1.push(gum1);
		}

		Stack<Snack> gums2 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Snack gum2 = new Gum("Orbit", "Wrigley's", 1.00, "Bubblemint", .1, 10, true, 5, true);
			gums2.push(gum2);
		}

		Stack<Snack> gums3 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Snack gum3 = new Gum("5 Gum", "Wrigley's", 1.00, "Peppermint", .1, 15, true, 5, false);
			gums3.push(gum3);
		}

		//create ArrayList to store chips stacks and sort
		ArrayList<Comparable> gums = new ArrayList<>();
		gums.add(gums1.peek() + "" + gums1.size());
		gums.add(gums2.peek() + "" + gums2.size());
		gums.add(gums3.peek() + "" + gums3.size());
		Collections.sort(gums);

		//display drinks to console
		System.out.println("-----------------------------------------------------  DRINKS  ----------------------------" +
				"------------------------");
		System.out.printf("%-15s%-15s%-12s%-12s%-12s%-12s%-12s%-12s%-12s", "Brand", "Name", "Price", "Ounces",
				"Calories", "Sugar", "Caffeine", "Healthy", "Quantity Left\n");
		System.out.println("----------------------------------------------------------------------------------------" +
				"---------------------------");

		for (Comparable product : drinks)
			System.out.println(product);

		//display gums to console
		System.out.println();
		System.out.println("------------------------------------------------------------  GUM  ------------------------------" +
				"------------------------------");
		System.out.printf("%-15s%-15s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s", "Brand", "Name", "Price", "Ounces", "Flavor",
				"Pieces", "Sugar Free", "Calories", "Whitening", "Quantity Left\n");
		System.out.println("----------------------------------------------------------------------------------------------" +
				"---------------------------------");

		for (Comparable snack : gums)
			System.out.println(snack);

		//display chips to console
		System.out.println();
		System.out.println("------------------------------------------------  CHIPS  ------------------------------" +
				"-------------------");
		System.out.printf("%-15s%-15s%-15s%-12s%-12s%-12s%-12s%-12s", "Brand", "Name", "Flavor", "Type", "Price",
				"Ounces", "Calories", "Quantity Left\n");
		System.out.println("-----------------------------------------------------------------------------------" +
				"-----------------------");

		for (Comparable snack : chips)
			System.out.println(snack);

		//display candy to console
		System.out.println();
		System.out.println("------------------------------------------------------  CANDY  -------------------------" +
				"------------------------------");
		System.out.printf("%-15s%-15s%-15s%-12s%-12s%-12s%-12s%-12s%-12s", "Brand", "Name", "Type", "Flavor", "Price",
				"Ounces", "Calories", "Sugar", "Quantity Left\n");
		System.out.println("-----------------------------------------------------------------------------------" +
				"-----------------------------------");

		for (Comparable snack : candys)
			System.out.println(snack);

	}
}

