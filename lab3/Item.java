package labs.lab3;

/**
* Represents an item purchased
*/
public class Item {
	
	// ADD INSTANCE VARIABLES HERE
	private double price;
	private boolean edible;
	private int quantity;
	
	/**
	* Constructor that creates an Item
	*
	* @param price price of the item
	* @param edible whether it's edible or not
	* @param quantity quantity of the item
	*/
	public Item(double price, boolean edible, int quantity) {
		// FILL IN
		this.price = price;
		this.edible = edible;
		this.quantity = quantity;
	}
	
	/**
	* @return price of the item
	*/
	public double getPrice() {
		return price; // FIX ME
	}
	
	/**
	* @return whether the item is edible or not
	*/
	public boolean isEdible() {
		return edible; // FIX ME
	}
	
	/**
	* @return quantity of the item
	*/
	public int getQuantity() {
		return quantity; // FIX ME
	}
}
