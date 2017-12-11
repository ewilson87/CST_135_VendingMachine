/**Program: Vending Machine
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
		int pieces, Boolean sugarFree, int calories, Boolean whitening)
	{
		super.setName(name); 
		super.setWeight(weight);
		super.setCalories(calories);
		super.setPrice(price);
		super.setBrand(brand);
		this.setFlavor(flavor);
		this.setPieces(pieces);
		this.setSugarFree(sugarFree);
		this.setWhitening(whitening);
	}

	//getters and setters
	private String getFlavor() {
		return flavor;
	}

	private void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	private int getPieces() {
		return pieces;
	}

	private void setPieces(int pieces) {
		this.pieces = pieces;
	}

	private Boolean getSugarFree() {
		return sugarFree;
	}

	private void setSugarFree(Boolean sugarFree) {
		this.sugarFree = sugarFree;
	}

	private Boolean getWhitening() {
		return whitening;
	}

	private void setWhitening(Boolean whitening) {
		this.whitening = whitening;
	}

	//toString method
	@Override
	public String toString() {
		return String.format("%-15s%-15s%-12.2f%-12.2f%-12s%-12d%-12b%-12d%-12b", brand, name, price, weight, flavor,
				pieces, sugarFree, calories, whitening);
	}
}
