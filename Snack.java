/**Program: Vending Machine
 * File: Snack.java
 * Summary: Snack class for vending machine program
 * Authors: Evan Wilson, Jake Babcock, Robert Nichols
 * Date: December 3, 2017
 **/

//subclass of Product
public abstract class Snack extends Product {

	//sets variables
	double weight;
	int calories;

	//default method with no constructors
	Snack() {
	}

	//sets all variables using constructors
	public Snack(String name, double price, double weight, int calories) {
	    super.setName(name);
	    super.setPrice(price);
		this.setWeight(weight);
		this.setCalories(calories);
	}


	//getters and setters
	private double getWeight() {
		return weight;
	}

	void setWeight(double weight) {
		this.weight = weight;
	}

	private int getCalories() {
		return calories;
	}

	void setCalories(int calories) {
		this.calories = calories;
	}

	//toString method
	public String toString() {
		return name + " " + weight + " " + calories;
	}
}
