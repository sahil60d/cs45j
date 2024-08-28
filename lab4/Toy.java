package labs.lab4;
/**
* Represents a toy
*/
public class Toy {
	// ADD INSTANCE VARIABLES HERE
	
	private String name;
	private String desc;
	private boolean dest;
	/**
	* Constructor that constructs the Toy object
	*
	* @param name name of the toy
	* @param description description of the toy
	* @param destroyed whether or not this toy is destroyed
	*/
	public Toy(String name, String description, boolean destroyed) {
	// FILL IN
		this.name = name;
		desc = description;
		dest = destroyed;
	}
	/**
	*
	* @return name of the toy
	*/
	public String getName() {
		return name; // FIX ME
	}
	/**
	* Sets the name to the given name
	*
	* @param name new name
	*/
	public void setName(String name) {
		this.name = name;
	}
	/**
	*
	* @return description of the toy
	*/
	public String getDescription() {
		return desc; // FIX ME
	}
	/**
	* Sets the description to the given description
	*
	* @param description new description
	*/
	public void setDescription(String description) {
		desc = description;
	}
	/**
	*
	* @return true if the toy is destroyed, false otherwise
	*/
	public boolean isDestroyed() {
		return dest; // FIX ME
	}
	/**
	* Sets the destroyed property to the given value
	*
	* @param destroyed new destroyed property
	*/
	public void setDestroyed(boolean destroyed) {
		dest = destroyed;
	}
}