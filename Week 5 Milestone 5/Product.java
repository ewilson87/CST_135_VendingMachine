/**
 * Program: Vending Machine
 * File: Product.java
 * Summary: Product class for vending machine program
 * Authors: Evan Wilson, Jake Babcock, Robert Nichols
 * Date: December 3, 2017
 **/

public class Product {

    //sets variables
    double price;
    String name;
    String image;
    int quantity;

    //default method with no constructors
    Product() {
    }

    //sets all variables using constructors
    public Product(String name, double price, String image, int quantity) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
    }

    //setters and getters
    double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    protected void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }

    //toString method
    public String toString() {
        return name + " " + price;
    }
}
