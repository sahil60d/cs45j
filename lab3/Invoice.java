package labs.lab3;

import java.util.ArrayList;

/**
* Holds a collection of Items
*/
public class Invoice {
	
	// ADD INSTANCE VARIABLES HERE
	ArrayList<Item> values;
	
	/**
	* Constructor that creates an empty Invoice
	*/
	public Invoice() {
		// FILL IN
		values = new ArrayList<Item>();
	}
	
	/**
	* Adds an Item to this Invoice
	*
	* @param item item to add
	*/
	public void addItem(Item item) {
		// FILL IN
		values.add(item);
	}
	
	/**
	* @return the total charge for this Invoice
	*/
	public double getTotal() {
		double sum = 0.0;
		
		for (Item i : values) {
			sum += i.getPrice() * i.getQuantity();
		}
		
		return sum; // FIX ME
	}
}
