package labs.lab5;

/**
* Formats an integer in the usual way
*
*/
public class DefaultFormatter implements NumberFormatter {
	/**
	* Formats an integer in the usual way
	*
	* @param n the number to format
	*/
	public String format(int n) {
		return String.format("%d", n); // FIX ME
	}
}
