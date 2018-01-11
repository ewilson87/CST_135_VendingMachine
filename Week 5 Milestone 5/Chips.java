/**
 * Program: Vending Machine
 * File: Chips.java
 * Summary: Chips class for vending machine program
 * Authors: Evan Wilson, Jake Babcock, Robert Nichols
 * Date: December 3, 2017
 **/

//Subclass of Snack
public class Chips extends Snack {

    //declare variables
    private String flavor;
    private String type;

    //default method with no constructors
    public Chips() {
    }

    //sets all variables using constructors
    Chips(String name, String brand, double price, String flavor, String type,
          double weight, int calories, String image, int quantity) {

        super.setName(name);
        super.setWeight(weight);
        super.setCalories(calories);
        super.setPrice(price);
        super.setBrand(brand);
        this.setFlavor(flavor);
        this.setType(type);
        super.setImage(image);
        super.setQuantity(quantity);
    }

    //getters and setters
    public String getType() {
        return this.type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public String getFlavor() {
        return this.flavor;
    }

    protected void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getName() {
        return super.getName();
    }

    public double getPrice() {
        return super.getPrice();
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

    public String getImage() {
        return super.getImage();
    }

    public int getQuantity() {
        return super.getQuantity();
    }

    //toString method
    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15.2f%-12s%-12s%-12.2f%-12d", brand, name, price, flavor, type,
                weight, calories);
    }
}
