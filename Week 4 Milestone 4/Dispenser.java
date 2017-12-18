/**Program: Vending Machine
 * File: Dispenser.java
 * Summary: Dispenser class for vending machine program
 * Authors: Evan Wilson, Jake Babcock, Robert Nichols
 * Date: December 3, 2017
 **/

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Dispenser extends Product {

	Double total = 0.0;


	//default method with no constructors
	public Dispenser() {
	}

	//begin main method
	public static void main(String[] args){

	}

	public ObservableList<Drink> createDrinks(){

		ObservableList<Drink> drinksList = FXCollections.observableArrayList();

		//create products of each type
		Stack<Drink> drinks1 = new Stack<>();
		for (int i = 0; i < 15; i++) {
			Drink drink1 = new Drink("Root Beer", "Mug", 2.0, 20, 320, 18, false, false,
					"root beer bottle.jpg");
			drinks1.push(drink1);
		}
		Stack<Drink> drinks2 = new Stack<>();
		for (int i = 0; i < 10; i++) {
			Drink drink2 = new Drink("Root Beer", "Mug", 1.50, 12, 210, 10, false, false,
					"root beer can.png");
			drinks2.push(drink2);
		}

		Stack<Drink> drinks3 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Drink drink3 = new Drink("Cola", "Coke", 1.50, 12, 210, 10, true, false,
					"coke can.jpg");
			drinks3.push(drink3);
		}

		//create ArrayList to store drink stacks and sort
		//ArrayList<Comparable> drinks = new ArrayList<>();
		drinksList.add((drinks1.peek()));
		drinksList.add(drinks2.peek());
		drinksList.add(drinks3.peek());
		Collections.sort(drinksList);

		return drinksList;
	}

	public  ObservableList<Candy> createCandy(){

        ObservableList<Candy> candyList = FXCollections.observableArrayList();

		Stack<Candy> candys1 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Candy candy1 = new Candy("Chocolate", "Hershey", 1.0, "Candy Bar", "Special Dark", 1, 100, 320,
					"hersheys special dark.png");
			candys1.push(candy1);
		}

		Stack<Candy> candys2 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Candy candy2 = new Candy("Starburst", "Wrigley's", 1.5,"Chewy", "FaveReds", 4.34, 66, 480,
					"starburst.png");
			candys2.push(candy2);
		}

		Stack<Candy> candys3 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Candy candy3 = new Candy("Skittles", "Wrigley's", 1.0,"Chewy", "Tropical", 2.17, 33, 240,
					"skittles.png");
			candys3.push(candy3);
		}

		//create ArrayList to store candy stacks and sort
		//ArrayList<Comparable> candys = new ArrayList<>();
		candyList.add(candys1.peek());
		candyList.add(candys2.peek());
		candyList.add(candys3.peek());
		Collections.sort(candyList);

		return candyList;
	}

	public ObservableList<Chips> createChips(){

        ObservableList<Chips> chipsList = FXCollections.observableArrayList();

		Stack<Chips> chips1 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Chips chip1 = new Chips("Cheetos", "Frito-Lay", .75, "Hot", "Regular", 1, 140,
					"cheetos flamin hot.jpg");
			chips1.push(chip1);
		}

		Stack<Chips> chips2 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Chips chip2 = new Chips("Fritos", "Frito-Lay", .75, "Chili", "Corn Chips", 1, 160,
					"fritos chili cheese.png");
			chips2.push(chip2);
		}

		Stack<Chips> chips3 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Chips chip3 = new Chips("Doritos", "Frito-Lay", .75, "Cool Ranch", "Baked", 1, 90,
					"doritos cool ranch.png");
			chips3.push(chip3);
		}

		//create ArrayList to store chips stacks and sort
		//ArrayList<Comparable> chips = new ArrayList<>();
		chipsList.add(chips1.peek());
		chipsList.add(chips2.peek());
		chipsList.add(chips3.peek());
		Collections.sort(chipsList);

		return chipsList;
	}

	public ObservableList<Gum> createGum(){

        ObservableList<Gum> gumList = FXCollections.observableArrayList();

		Stack<Gum> gums1 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Gum gum1 = new Gum("Juicey Fruit", "Wrigley's", 1.00, "Fruit", .1, 15, false, 15, false,
					"juicy fruit.png");
			gums1.push(gum1);
		}

		Stack<Gum> gums2 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Gum gum2 = new Gum("Orbit", "Wrigley's", 1.00, "Bubblemint", .1, 14, true, 5, true,
					"orbit bubblemint.png");
			gums2.push(gum2);
		}

		Stack<Gum> gums3 = new Stack<>();
		for (int i = 0; i < 20; i++) {
			Gum gum3 = new Gum("5 Gum", "Wrigley's", 1.00, "Peppermint", .1, 15, true, 5, false,
					"5 gum peppermint.png");
			gums3.push(gum3);
		}

		//create ArrayList to store chips stacks and sort
		//ArrayList<Comparable> gums = new ArrayList<>();
		gumList.add(gums1.peek());
		gumList.add(gums2.peek());
		gumList.add(gums3.peek());
		Collections.sort(gumList);

		return gumList;
	}

	public Double total(Double price){

		total = total + price;

		return total;
	}

	public static void displayProducts(){

		//display drinks to console
		System.out.println("-----------------------------------------------------  DRINKS  ----------------------------" +
				"------------------------");
		System.out.printf("%-15s%-20s%-12s%-12s%-12s%-12s%-12s%-12s%-12s", "Brand", "Name", "Price", "Ounces",
				"Calories", "Sugar", "Caffeine", "Healthy", "Quantity Left\n");
		System.out.println("----------------------------------------------------------------------------------------" +
				"---------------------------");

		//for (Object product : createDrinks())
		//	System.out.println(product);

		//display gums to console
		System.out.println();
		System.out.println("------------------------------------------------------------  GUM  ------------------------------" +
				"------------------------------");
		System.out.printf("%-15s%-15s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s", "Brand", "Name", "Price", "Ounces", "Flavor",
				"Pieces", "Sugar Free", "Calories", "Whitening", "Quantity Left\n");
		System.out.println("----------------------------------------------------------------------------------------------" +
				"---------------------------------");

		//for (Object snack : createGum())
		//	System.out.println(snack);

		//display chips to console
		System.out.println();
		System.out.println("------------------------------------------------  CHIPS  ------------------------------" +
				"-------------------");
		System.out.printf("%-15s%-15s%-15s%-12s%-12s%-12s%-12s%-12s", "Brand", "Name", "Flavor", "Type", "Price",
				"Ounces", "Calories", "Quantity Left\n");
		System.out.println("-----------------------------------------------------------------------------------" +
				"-----------------------");

		//for (Object snack : createChips())
		//	System.out.println(snack);

		//display candy to console
		System.out.println();
		System.out.println("------------------------------------------------------  CANDY  -------------------------" +
				"------------------------------");
		System.out.printf("%-15s%-15s%-15s%-12s%-12s%-12s%-12s%-12s%-12s", "Brand", "Name", "Type", "Flavor", "Price",
				"Ounces", "Calories", "Sugar", "Quantity Left\n");
		System.out.println("-----------------------------------------------------------------------------------" +
				"-----------------------------------");

		//for (Object snack : createCandy())
		//	System.out.println(snack);

	}
}

