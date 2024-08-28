package labs.lab2;
/**
* A class to represent an inflatable spherical balloon.
*/
public class Balloon {
	private double volume;
	/**
	* Constructs an unfilled balloon.
	*/
	public Balloon() {
		volume = 0.0;
	}
	/**
	* Inflates the balloon with a specified amount of air.
	*
	* @param amount the increase to the volume of the balloon (in cubic cm).
	Assume
	* always >= 0.
	*/
	public void addAir(double amount) {
		volume += amount;
	}
	/**
	* Returns the volume of air currently inside the balloon.
	*
	* @return the volume of air in the balloon (in cubic cm)
	*/
	public double getVolume() {
		return volume; // FIX ME
	}
	/**
	* Finds and returns the radius of the balloon.
	*
	* @return the radius of balloon (in centimeters)
	*/
	public double getRadius() {
		double radius = Math.cbrt((3*volume)/(4*Math.PI));
		
		return radius; // FIX ME
	}
	/**
	* Finds and returns the surface area of the balloon.
	*
	* @return the surface area of balloon (in square centimeters)
	*/
	public double getSurfaceArea() {
		double radius = getRadius();
		
		double area = 4 * Math.PI * Math.pow(radius, 2);
		
		return area; // FIX ME
	}
}
