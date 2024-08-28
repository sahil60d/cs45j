package labs.lab2;
/**
* A Distance represents a distance between two points, in meters
*/
public class Distance {
	// ADD INSTANCE VARIABLES HERE
	private double meters;
	
	/**
	* Constructs a Distance with the given meters
	*
	* @param meters meters in this distance
	*/
	public Distance(double meters) {
		this.meters = meters;
	}
	/**
	* @return this Distance in meters
	*/
	public double getMeters() {
		return meters; // FIX ME
	}
	/**
	* @return this Distance in kilometers
	*/
	public double getKilometers() {
		return meters/1000; // FIX ME
	}
	/**
	* @return this Distance in centimeters
	*/
	public double getCentimeters() {
		return meters*100; // FIX ME
	}
	/**
	* @return this Distance in feet
	*/
	public double getFeet() {
		return meters*3.28084; // FIX ME
	}
	/**
	* @return this Distance in miles
	*/
	public double getMiles() {
		return meters/1609; // FIX ME
	}
	/**
	* @return this Distance in inches
	*/
	public double getInches() {
		return meters*39.3701; // FIX ME
	}
}