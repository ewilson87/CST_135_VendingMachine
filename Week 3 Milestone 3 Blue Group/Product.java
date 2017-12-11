/**Program: Vending Machine
 * File: Product.java
 * Summary: Product class for vending machine program
 * Authors: Evan Wilson, Jake Babcock, Robert Nichols
 * Date: December 3, 2017
 **/

public abstract class Product {

	//sets variables
	double price;
	String name;

	//default method with no constructors
	Product() {
	}

	//sets all variables using constructors
	public Product (String nameIn, double priceIn)
	{
		this.name = nameIn;
		this.price = priceIn;
	}

	//setters and getters
	protected double getPrice() {
		return price;
	}

	void setPrice(double price) {
		this.price = price;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	//toString method
	public String toString() {
		return name + " " + price;
	}
}
