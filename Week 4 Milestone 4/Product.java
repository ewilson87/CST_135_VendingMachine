/**Program: Vending Machine
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

	//default method with no constructors
	Product() {
	}

	//sets all variables using constructors
	public Product (String name, double price, String image)
	{
		this.setName(name);
		this.setPrice(price);
		this.setImage(image);
	}

	//setters and getters
	double getPrice() { return price; }

	protected void setPrice(double price) { this.price = price; }

	String getName() { return name; }

	protected void setName(String name) { this.name = name; }

	public String getImage() { return image; }

	protected void setImage(String image) { this.image = image; }

	//toString method
	public String toString() {
		return name + " " + price;
	}
}
