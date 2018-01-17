/**
 * Program: Vending Machine
 * File: Drink.java
 * Summary: Drink class for vending machine program
 * Authors: Evan Wilson, Jake Babcock, Robert Nichols
 * Date: December 3, 2017
 **/

//Subclass of Product
public class Drink extends Product implements Comparable<Drink> {

    //declare variables
    private String brand;
    private double size;
    private int calories;
    private Boolean healthy;
    private Boolean caffeine;
    private double sugar;

    //default method with no constructors
    public Drink() {
    }

    //sets all variables using constructors
    Drink(String name, String brand, double price, double size, int calories,
          double sugar, Boolean caffeine, Boolean healthy, String image, int quantity, String productID) {

        super.setName(name);
        super.setPrice(price);
        this.setBrand(brand);
        this.setSize(size);
        this.setCalories(calories);
        this.setHealthy(healthy);
        this.setCaffeine(caffeine);
        this.setSugar(sugar);
        super.setImage(image);
        super.setQuantity(quantity);
        super.setProductID(productID);
    }

    //getters and setters
    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSize() {
        return size;
    }

    private void setSize(double size) {
        this.size = size;
    }

    public int getCalories() {
        return calories;
    }

    private void setCalories(int calories) {
        this.calories = calories;
    }

    public Boolean getHealthy() {
        return healthy;
    }

    private void setHealthy(Boolean healthy) {
        this.healthy = healthy;
    }

    public double getSugar() {
        return sugar;
    }

    private void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public Boolean getCaffeine() {
        return caffeine;
    }

    private void setCaffeine(Boolean caffeine) {
        this.caffeine = caffeine;
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

    public String getProductID() {
        return super.getProductID();
    }

    @Override
    public int compareTo(Drink other) {
        if (getBrand().toUpperCase().compareTo(other.getBrand().toUpperCase()) > 0) {
            return 1;
        } else if (getBrand().toUpperCase().compareTo(other.getBrand().toUpperCase()) < 0) {
            return -1;
        } else if (getPrice() > other.getPrice()) {
            return 1;
        } else if (getPrice() < other.getPrice()) {
            return -1;
        } else return 0;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-12.2f%-12.2f%-12d%-12.2f%-12b%-12b%-12d%-12s", brand, name, price, size,
                calories, sugar, caffeine, healthy, quantity, productID);
    }

}
