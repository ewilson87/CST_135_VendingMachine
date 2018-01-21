/**
 * Program: Vending Machine
 * File: Gum.java
 * Summary: Gum class for vending machine program
 * Authors: Evan Wilson, Jake Babcock, Robert Nichols
 * Date: December 3, 2017
 **/

//Subclass of Snack
public class Gum extends Snack {

    //declare variables
    private String flavor;
    private int pieces;
    private Boolean sugarFree;
    private Boolean whitening;

    //default method with no constructors
    public Gum() {
    }

    //sets all variables using constructors
    Gum(String name, String brand, double price, String flavor, double weight,
        int pieces, Boolean sugarFree, int calories, Boolean whitening, String image, int quantity, String productID) {
        super.setName(name);
        super.setWeight(weight);
        super.setCalories(calories);
        super.setPrice(price);
        super.setBrand(brand);
        this.setFlavor(flavor);
        this.setPieces(pieces);
        this.setSugarFree(sugarFree);
        this.setWhitening(whitening);
        super.setImage(image);
        super.setQuantity(quantity);
        super.setProductID(productID);
    }

    //getters and setters
    public String getFlavor() {
        return this.flavor;
    }

    protected void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getPieces() {
        return this.pieces;
    }

    protected void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public Boolean getSugarFree() {
        return this.sugarFree;
    }

    protected void setSugarFree(Boolean sugarFree) {
        this.sugarFree = sugarFree;
    }

    public Boolean getWhitening() {
        return this.whitening;
    }

    protected void setWhitening(Boolean whitening) {
        this.whitening = whitening;
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

    public String getProductID() {
        return super.getProductID();
    }

    //toString method
    @Override
    public String toString() {
        return String.format("%-15s%-15s%-12.2f%-12d%-12s%-12.2f%-12b%-12d%-12b%-12d%-12s", brand, name, price, pieces, flavor,
                weight, sugarFree, calories, whitening, quantity, productID);
    }
}
