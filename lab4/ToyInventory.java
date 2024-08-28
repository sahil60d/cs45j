package labs.lab4;

import java.util.ArrayList;

/**
* Represents an inventory of toys
*/
public class ToyInventory {
	// ADD INSTANCE VARIABLES HERE
	
	ArrayList<Toy> inventory;
	
	/**
	* Constructor that constructs a new ToyInventory object
	*/
	public ToyInventory() {
		inventory = new ArrayList<Toy>();
	}
	/**
	* Adds the given toy if a toy with that name doesn't already exist in
	* the inventory
	*
	* @param toy toy to add
	*/
	public void addToy(Toy toy) {
		inventory.add(toy);
	}
	/**
	* Removes the toy with the given name if it exists in the inventory
	*
	* @param name name of toy to remove
	*/
	public void removeToy(String name) {
		Toy r = null;
		
		for (Toy t : inventory) {
			if (t.getName() == name) {
				r = t;
			}
		}
		
		inventory.remove(r);
		
	}
	/**
	* @return a String that lists the name, description, and DESTROYED or NOT
	DESTROYED for each
	* toy in the format:
	* name
	* description
	* DESTROYED/NOT DESTROYED
	*/
	public String getInventoryReport() {
		String report = "";
		
		for (Toy t : inventory) {
			String destroy = t.isDestroyed() ? "DESTROYED\n" : "NOT DESTROYED\n";
			report += t.getName() + "\n" + t.getDescription() + "\n" + destroy;
		}
	return report.trim(); // FIX ME
	}
}