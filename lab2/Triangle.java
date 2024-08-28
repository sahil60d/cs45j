package labs.lab2;
/**
* A class to represent a triangle defined by the x- and y-coordinates of its
* three corner points
*/
public class Triangle {
	// ADD INSTANCE VARIABLES HERE
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	private double x3;
	private double y3;
	/**
	* Constructs a triangle with the given corner points
	*
	* @param x1 x-value of corner point 1
	* @param y1 y-value of corner point 1
	* @param x2 x-value of corner point 2
	* @param y2 y-value of corner point 2
	* @param x3 x-value of corner point 3
	* @param y3 y-value of corner point 3
	*/
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}
	/**
	* Returns the length of side 1: (x1, y1) to (x2, y2)
	*
	* @return the length of side 1
	*/
	public double getSide1Length() {
		double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		
		return distance;
	}
	/**
	* Returns the length of side 2: (x1, y1) to (x3, y3)
	*
	* @return the length of side 2
	*/
	public double getSide2Length() {
		double distance = Math.sqrt(Math.pow(x3-x1, 2) + Math.pow(y3-y1, 2));
		
		return distance; // FIX ME
	}
	/**
	* Returns the length of side 3: (x2, y2) to (x3, y3)
	*
	* @return the length of side 3
	*/
	public double getSide3Length() {
		double distance = Math.sqrt(Math.pow(x3-x2, 2) + Math.pow(y3-y2, 2));
		
		return distance; // FIX ME
	}
	/**
	* Returns the angle at corner 1 (x1, y1)
	*
	* @return the angle at corner 1
	* 
	* a = side opposite of x1 => side 3
	* b = side opposite of x2 => side 2
	* c = side opposite of x3 => side 1
	* 
	*/
	public double getAngle1() {
		double a = getSide3Length();
		double b = getSide2Length();
		double c = getSide1Length();
		
		double angle = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2*b*c));
		
		return angle; // FIX ME
	}
	/**
	* Returns the angle at corner 2 (x2, y2)
	*
	* @return the angle at corner 2
	*/
	public double getAngle2() {
		double a = getSide3Length();
		double b = getSide2Length();
		double c = getSide1Length();
		
		double angle = Math.acos((Math.pow(c, 2) + Math.pow(a, 2) - Math.pow(b, 2)) / (2*a*c));
		
		return angle; // FIX ME
	}
	/**
	* Returns the angle at corner 3 (x3, y3)
	*
	* @return the angle at corner 3
	*/
	public double getAngle3() {
		double a = getSide3Length();
		double b = getSide2Length();
		double c = getSide1Length();
		
		double angle = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2*a*b));
		
		return angle; // FIX ME
	}
	/**
	* Returns the perimeter of the triangle
	*
	* @return the perimeter of the triangle
	*/
	public double getPerimeter() {
		double a = getSide3Length();
		double b = getSide2Length();
		double c = getSide1Length();
		
		double per = a + b + c;
		
		return per; // FIX ME
	}
	/**
	* Returns the area of the triangle	
	*
	* @return the area of the triangle
	*/
	public double getArea() {
		double a = getSide3Length();
		double b = getSide2Length();
		double c = getSide1Length();
		double s = getPerimeter()/2; // semi perimeter
		
		double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
	
		return area; // FIX ME
	}
}