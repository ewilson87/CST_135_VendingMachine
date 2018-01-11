/**
 * Program: Vending Machine
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

    ObservableList<Drink> drinksList = FXCollections.observableArrayList();
    ObservableList<Candy> candyList = FXCollections.observableArrayList();
    ObservableList<Chips> chipsList = FXCollections.observableArrayList();
    ObservableList<Gum> gumList = FXCollections.observableArrayList();
    ObservableList<Product> inventory = FXCollections.observableArrayList();

    //default method with no constructors
    public Dispenser() {
    }

    public ObservableList<Drink> createDrinks() {

        //create products of each type
        Drink drink1 = new Drink("Root Beer", "Mug", 2.0, 20, 320, 18, false, false,
                "root beer bottle.jpg", 20);

        Drink drink2 = new Drink("Root Beer", "Mug", 1.50, 12, 210, 10, false, false,
                "root beer can.png", 20);

        Drink drink3 = new Drink("Cola", "Coke", 1.50, 12, 210, 10, true, false,
                "coke can.jpg", 20);

        drinksList.addAll(drink1, drink2, drink3);
        Collections.sort(drinksList);

        inventory.addAll(drinksList);

        return drinksList;
    }

    public ObservableList<Candy> createCandy() {

        Candy candy1 = new Candy("Chocolate", "Hershey", 1.0, "Candy Bar", "Special Dark", 1, 100, 320,
                "hersheys special dark.png", 20);

        Candy candy2 = new Candy("Starburst", "Wrigley's", 1.5, "Chewy", "FaveReds", 4.34, 66, 480,
                "starburst.png", 20);

        Candy candy3 = new Candy("Skittles", "Wrigley's", 1.0, "Chewy", "Tropical", 2.17, 33, 240,
                "skittles.png", 20);

        candyList.addAll(candy1, candy2, candy3);
        Collections.sort(candyList);

        inventory.addAll(candyList);

        return candyList;
    }

    public ObservableList<Chips> createChips() {

        Chips chip1 = new Chips("Cheetos", "Frito-Lay", .75, "Hot", "Regular", 1, 140,
                "cheetos flamin hot.jpg", 20);

        Chips chip2 = new Chips("Fritos", "Frito-Lay", .75, "Chili", "Corn Chips", 1, 160,
                "fritos chili cheese.png", 20);

        Chips chip3 = new Chips("Doritos", "Frito-Lay", .75, "Cool Ranch", "Baked", 1, 90,
                "doritos cool ranch.png", 20);

        chipsList.addAll(chip1, chip2, chip3);
        Collections.sort(chipsList);

        inventory.addAll(chipsList);

        return chipsList;
    }

    public ObservableList<Gum> createGum() {

        Gum gum1 = new Gum("Juicey Fruit", "Wrigley's", 1.00, "Fruit", .1, 15, false, 15, false,
                "juicy fruit.png", 20);

        Gum gum2 = new Gum("Orbit", "Wrigley's", 1.00, "Bubblemint", .1, 14, true, 5, true,
                "orbit bubblemint.png", 20);

        Gum gum3 = new Gum("5 Gum", "Wrigley's", 1.00, "Peppermint", .1, 15, true, 5, false,
                "5 gum peppermint.png", 20);

        gumList.addAll(gum1, gum2, gum3);
        Collections.sort(gumList);

        inventory.addAll(gumList);

        return gumList;
    }

    public Double total(Double price) {

        total = total + price;

        return total;
    }

    public static void displayProducts() {

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

