package labs.lab2;
/**
* Represents a quadrilateral, given coordinates of its four corners.
* Determines the shape of the quadrilateral ("Square", "Rectangle",
* "Parallelogram", "Trapezoid", "Rhombus" or "None")
*/
public class Quadrilateral {
	// ADD INSTANCE VARIABLES EHRE
	private double ax;
	private double ay;
	private double bx;
	private double by;
	private double cx;
	private double cy;
	private double dx;
	private double dy;
	
	/**
	* Constructs a new Quadrilateral given the coordinates of its four corners
	* in the order they appear in a clockwise direction
	*
	* @param ax x-coordinate of the first vertex (A)
	* @param ay y-coordinate of the first vertex (A)
	* @param bx x-coordinate of the second vertex (B)
	* @param by y-coordinate of the second vertex (B)
	* @param cx x-coordinate of the third vertex (C)
	* @param cy y-coordinate of the third vertex (C)
	* @param dx x-coordinate of the fourth vertex (D)
	* @param dy y-coordinate of the fourth vertex (D)
	*/
	public Quadrilateral(double ax, double ay, double bx, double by, double cx,
	double cy, double dx, double dy) {
		this.ax = ax;
		this.ay = ay;
		this.bx = bx;
		this.by = by;
		this.cx = cx;
		this.cy = cy;
		this.dx = dx;
		this.dy = dy;
	}
	
	//Helpers
	/**
	 * Returns array containing length of all 4 sides
	 * sides[0] = a->b
	 * sides[1] = b->c
	 * sides[2] = c->d
	 * sides[3] = d->a
	 */
	public double[] getSides() {
		double[] sides = new double[4];
		
		sides[0] = Math.sqrt(Math.pow(bx-ax, 2) + Math.pow(by-ay, 2));
		sides[1] = Math.sqrt(Math.pow(cx-bx, 2) + Math.pow(cy-by, 2));
		sides[2] = Math.sqrt(Math.pow(dx-cx, 2) + Math.pow(dy-cy, 2));
		sides[3] = Math.sqrt(Math.pow(ax-dx, 2) + Math.pow(ay-dy, 2));
		
		return sides;
	}
	
	/**
	 * Returns true is all elements equal, else false
	 */
	public boolean allEqual(double[] sides) {
		double x = sides[0];
		
		for (int i = 1; i < sides.length; i++) {
			if (sides[i] != x) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	* Gets the type of shape this quadrilateral is ("Square", "Rhombus,
	"Rectangle",
	* "Parallelogram", "Trapezoid", or "None"). When a shape falls in multiple
	* categories, use the order of precedence just listed.
	*
	* @return "Square", "Rhombus, "Rectangle", "Parallelogram", "Trapezoid", or
	"None"
	*/
	public String getShapeType() {
		double[] sides = getSides();
		
		//all sides equal
		if (allEqual(sides) == true) {
			// check if square or rhombus
			double cross = Math.sqrt(Math.pow(dx-bx, 2) + Math.pow(dy-by, 2));
			int angle = (int) Math.toDegrees(Math.acos((Math.pow(sides[3], 2) + Math.pow(sides[0], 2) - Math.pow(cross, 2)) / (2*sides[3]*sides[0])));
			
			if (angle == 90) {
				return "Square";
			} else {
				return "Rhombus";
			}
			
		} else if (sides[0] == sides[2] && sides[1] == sides[3]) { // 2 pairs of equal sides
			// check if rectangle or parallelogram
			double cross = Math.sqrt(Math.pow(dx-bx, 2) + Math.pow(dy-by, 2));
			int angle = (int) Math.toDegrees(Math.acos((Math.pow(sides[3], 2) + Math.pow(sides[0], 2) - Math.pow(cross, 2)) / (2*sides[3]*sides[0])));
			
			if (angle == 90) {
				return "Rectangle";
			} else {
				return "Parallelogram";
			}
			
		} else if ((sides[0] == sides[2] && sides[1] != sides[3]) || (sides[0] != sides[2] && sides[1] == sides[3])) { // trapezoid
			return "Trapezoid";
		} else {
			return "None";
		}
	}
}
