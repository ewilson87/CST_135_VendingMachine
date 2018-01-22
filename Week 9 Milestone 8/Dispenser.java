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

    public void createDrinks() {

        //create products of each type
        Drink drink1 = new Drink("Orange", "Fanta", 1.5, 12, 200, 38, false, false,
                "fanta can.png", 20, "drink1");

        Drink drink2 = new Drink("Root Beer", "Mug", 1.50, 12, 210, 42, false, false,
                "root beer can.png", 20, "drink2");

        Drink drink3 = new Drink("Cola", "Coke", 1.50, 12, 210, 42, true, false,
                "coke can.jpg", 20, "drink3");

        //drinksList.addAll(drink1, drink2, drink3);
        //Collections.sort(drinksList);

        //inventory.addAll(drinksList);
        inventory.addAll(drink1, drink2, drink3);

        //return drinksList;
    }

    public void createCandy() {

        Candy candy1 = new Candy("Chocolate", "Hershey", 1.0, "Candy Bar", "Special Dark", 1, 100, 320,
                "hersheys special dark.png", 20, "candy1");

        Candy candy2 = new Candy("Starburst", "Wrigley's", 1.5, "Chewy", "FaveReds", 4.34, 66, 480,
                "starburst.png", 20, "candy2");

        Candy candy3 = new Candy("Skittles", "Wrigley's", 1.0, "Chewy", "Tropical", 2.17, 33, 240,
                "skittles.png", 20, "candy3");

        //candyList.addAll(candy1, candy2, candy3);
        //Collections.sort(candyList);

        //inventory.addAll(candyList);
        inventory.addAll(candy1, candy2, candy3);

        //return candyList;
    }

    public void createChips() {

        Chips chip1 = new Chips("Cheetos", "Frito-Lay", .75, "Hot", "Regular", 1, 140,
                "cheetos flamin hot.jpg", 20, "chips1");

        Chips chip2 = new Chips("Fritos", "Frito-Lay", .75, "Chili", "Corn Chips", 1, 160,
                "fritos chili cheese.png", 20, "chips2");

        Chips chip3 = new Chips("Doritos", "Frito-Lay", .75, "Cool Ranch", "Baked", 1, 90,
                "doritos cool ranch.png", 20, "chips3");

        //chipsList.addAll(chip1, chip2, chip3);
        //Collections.sort(chipsList);

        //inventory.addAll(chipsList);
        inventory.addAll(chip1, chip2, chip3);

        //return chipsList;
    }

    public void createGum() {

        Gum gum1 = new Gum("Juicey Fruit", "Wrigley's", 1.00, "Fruit", .1, 15, false, 15, false,
                "juicy fruit.png", 20,"gum1");

        Gum gum2 = new Gum("Orbit", "Wrigley's", 1.00, "Bubblemint", .1, 14, true, 5, true,
                "orbit bubblemint.png", 20, "gum2");

        Gum gum3 = new Gum("5 Gum", "Wrigley's", 1.00, "Peppermint", .1, 15, true, 5, false,
                "5 gum peppermint.png", 20, "gum3");

        //gumList.addAll(gum1, gum2, gum3);
        //Collections.sort(gumList);

        //inventory.addAll(gumList);
        inventory.addAll(gum1, gum2, gum3);

        //return gumList;
    }

    public Double total(Double price) {

        total = total + price;

        return total;
    }

    public ObservableList<Drink> drinksTableView(ObservableList<Product> inventory){
        for (Product product : inventory){
            if (product.getProductID().contains("drink")){
                drinksList.add((Drink)product);
            }
        }

        Collections.sort(drinksList);
        return drinksList;
    }

    public ObservableList<Chips> chipsTableView(ObservableList<Product> inventory){
        for (Product product : inventory){
            if (product.getProductID().contains("chips")){
                chipsList.add((Chips)product);
            }
        }

        Collections.sort(chipsList);
        return chipsList;
    }

    public ObservableList<Candy> candyTableView(ObservableList<Product> inventory){
        for (Product product : inventory){
            if (product.getProductID().contains("candy")){
                candyList.add((Candy)product);
            }
        }

        Collections.sort(candyList);
        return candyList;
    }

    public ObservableList<Gum> gumTableView(ObservableList<Product> inventory){
        for (Product product : inventory){
            if (product.getProductID().contains("gum")){
                gumList.add((Gum)product);
            }
        }

        Collections.sort(gumList);
        return gumList;
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

