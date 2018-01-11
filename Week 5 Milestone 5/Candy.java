/**
 * Program: Vending Machine
 * File: Candy.java
 * Summary: Candy class for vending machine program
 * Authors: Evan Wilson, Jake Babcock, Robert Nichols
 * Date: December 3, 2017
 **/

//Subclass of Snack
public class Candy extends Snack {

    //declare variables
    private String type;
    private String flavor;
    private double sugar;

    //default method with no constructors
    public Candy() {
    }

    //sets all variables using constructors
    Candy(String name, String brand, double price, String type, String flavor,
          double weight, double sugar, int calories, String image, int quantity) {

        super.setName(name);
        super.setWeight(weight);
        super.setCalories(calories);
        super.setPrice(price);
        this.setFlavor(flavor);
        super.setBrand(brand);
        this.setType(type);
        this.setSugar(sugar);
        super.setImage(image);
        super.setQuantity(quantity);
    }

    //getters and setters
    public String getFlavor() {
        return flavor;
    }

    protected void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public double getSugar() {
        return sugar;
    }

    protected void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getWeight() {
        return super.getWeight();
    }

    public int getCalories() {
        return super.getCalories();
    }

    public String getBrand() {
        return super.getBrand();
    }

    public String getName() {
        return super.getName();
    }

    public double getPrice() {
        return super.getPrice();
    }

    public String getImage() {
        return super.getImage();
    }

    public int getQuantity() {
        return super.getQuantity();
    }

    //toString method
    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15.2f%-12s%-12s%-12.2f%-12d%-12.2f", name, brand, price, type, flavor,
                weight, calories, sugar);
    }

}
