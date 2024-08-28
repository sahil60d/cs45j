package labs.lab5;

import java.lang.Double;

/**
* A coin with a monetary value.
*/
public class Coin implements Comparable {
	
	private double value;
	private String name;
	
	/**
	* Constructs a coin.
	*
	* @param aValue the monetary value of the coin.
	* @param aName the name of the coin
	*/
	public Coin(double aValue, String aName) {
		value = aValue;
		name = aName;
	}
	
	/**
	* Gets the coin value.
	*
	* @return the value
	*/
	public double getValue() {
		return value;
	}
	
	/**
	* Gets the coin name.
	*
	* @return the name
	*/
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format("Value: %s, Name: %s", ((Double)value).toString(), name); // FIX ME
	}
	
	@Override
	public boolean equals(Object otherObject) {
		return (value == ((Coin)otherObject).getValue() && name.equals(((Coin)otherObject).getName())) ? true : false; // FIX ME
	}
	
	/**
	* Compares two Coin objects.
	*
	* @param otherObject the object to be compared
	* @return a negative integer, zero, or a positive integer as this coin is
	less
	* than, equal to, or greater than the specified coin
	*/
	public int compareTo(Object otherObject) {
		int comp = ((Double)value).compareTo(((Coin)otherObject).getValue()); 
		
		if (comp == 0) {
			return name.compareTo(((Coin)otherObject).getName());
		}
		
		return comp;
	}
}