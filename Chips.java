/**Program: Vending Machine
 * File: Chips.java
 * Summary: Chips class for vending machine program
 * Authors: Evan Wilson, Jake Babcock, Robert Nichols
 * Date: December 3, 2017
 **/

//Subclass of Snack
public class Chips extends Snack{

	//declare variables
	private String brand;
	private String flavor; 
	private String type;

	//default method with no constructors
	public Chips() {
	}

	//sets all variables using constructors
	Chips(String name, String brand, double price, String flavor, String type,
		  double weight, int calories) {

		super.setName(name);
		super.setWeight(weight);
		super.setCalories(calories);
		super.setPrice(price);
		this.setBrand(brand);
		this.setFlavor(flavor); 
		this.setType(type);
	}

	//getters and setters
	private String getType() {
		return type;
	}

	private void setType(String type) {
		this.type = type;
	}

	private String getFlavor() {
		return flavor;
	}

	private void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	private String getBrand() {
		return brand;
	}

	private void setBrand(String brand) {
		this.brand = brand;
	}

	//toString method
	@Override
	public String toString() {
		return String.format("%-15s%-15s%-15s%-12s%-12.2f%-12.2f%-12d", brand, name, flavor, type, price,
				weight, calories);
	}
			}
