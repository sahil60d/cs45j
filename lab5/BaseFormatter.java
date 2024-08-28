package labs.lab5;

/**
* Formats integers in base n, where n is any number between 2 and 36
* (inclusive) that is provided in the constructor
*
*/
public class BaseFormatter implements NumberFormatter {
	
	// ADD YOUR INSTANCE VARIABLES HERE
	private int base;
	/**
	* Constructs a new BaseFormatter with base n. If n is not between 2 and 36
	* (inclusive), sets the base to 10.
	*
	* @param n the base for this formatter
	*/
	public BaseFormatter(int n) {
		if (n >= 2 && n <= 36) {
			base = n;
		} else {
			base = 10;
		}
	}
	
	/**
	* Formats integers in base n, where n is any number between 2 and 36
	* (inclusive) that is provided in the constructor
	*
	* @param n the number to format
	*/
	public String format(int n) {
		return Integer.toString(n, base); // FIX ME
	}
}
