package labs.lab5;

/**
* Formats an integer with comma separators; for example, one million as
* 1,000,000
*
*/
public class DecimalSeparatorFormatter implements NumberFormatter {
	/**
	* Formats an integer with comma separators; for example, one million as
	* 1,000,000
	*
	* @param n the number to format
	*/
	public String format(int n) {
		return String.format("%,d", n); // FIX ME
	}
}
