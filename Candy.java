/**Program: Vending Machine
 * File: Candy.java
 * Summary: Candy class for vending machine program
 * Authors: Evan Wilson, Jake Babcock, Robert Nichols
 * Date: December 3, 2017
 **/

//Subclass of Snack
public class Candy extends Snack {

	//declare variables
	private String brand;
	private String type;
	private String flavor;
	private double sugar;

	//default method with no constructors
	public Candy() {
	}
	
	//sets all variables using constructors
	Candy(String name, String brand, double price, String type, String flavor,
		  double weight, double sugar, int calories) {

		super.setName(name);
		super.setWeight(weight);
		super.setCalories(calories);
		super.setPrice(price);
		this.setFlavor(flavor);
		this.setBrand(brand);
		this.setType(type);
		this.setSugar(sugar);
	}

	//getters and setters
	private String getBrand() {
		return brand;
	}

	private void setBrand(String brand) {
		this.brand = brand;
	}

	private String getFlavor() {
		return type;
	}

	private void setFlavor(String flavor) { this.flavor = flavor; }

	private String getType() {
		return type;
	}

	private void setType(String type) { this.type = type; }

	private double getSugar() {
		return sugar;
	}

	private void setSugar(double sugar) {
		this.sugar = sugar;
	}

	//toString method
	@Override
	public String toString() {
		return String.format("%-15s%-15s%-15s%-12s%-12.2f%-12.2f%-12d%-12.2f", brand, name, type, flavor, price,
				weight, calories, sugar);
	}

}
