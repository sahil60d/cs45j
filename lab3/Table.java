package labs.lab3;
import java.util.ArrayList;
/**
* Represents a table of values.
*/
public class Table {
	
	private int[][] values;
	
	/**
	* Constructs a table with given rows and columns.
	*
	* @param rows the rows in the table (assume always > 0)
	* @param columns the columns in the table (assume always > 0)
	*/
	public Table(int rows, int columns) {
		values = new int[rows][columns];
	}
	
	/**
	* Sets a value in the table.
	*
	* @param i the row of the item to modify (assume always within the bounds of
	the table)
	* @param j the column of the item to modify (assume always within the bounds
	of the table)
	* @param n the number to use for the new value.
	*/
	public void set(int i, int j, int n) {
		values[i][j] = n;
	}
	
	/**
	* Computes and returns the average of the adjacent neighbors of the given
	* table element in all eight surrounding directions.
	*
	* If the element is located at the boundary of the table, include only
	* the neighbors that are in the table. For example if row and column are
	* both 0, there are only three neighbors.
	*
	* If the given element has no neighbors, return 0.
	*
	* If no element with the given row & column exists in this table, return 0.
	*
	* @param row the row of the element
	* @param column the column of the element
	* @return the average of the adjacent elements
	*/
	public double neighborAverage(int row, int column) {
		int rlength = values.length;
		int clength = values[0].length;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		//error check
		if (row < 0 || row >= rlength || column < 0 || column >= clength) {
			return 0;
		}
		
		
		
		if (rlength == 1 && clength == 1) {						//1x1 array
			return 0;
			
		} else if (rlength == 1) {								//one row							
			if (column == 0) {
				return values[row][column+1];
				
			} else if (column == clength-1) {
				return values[row][column-1];
				
			} else {
				nums.add(values[row][column-1]);
				nums.add(values[row][column+1]);
				return getAvg(nums);
			}
			
		} else if (clength == 1) {								//one column
			if (row == 0) {
				return values[row+1][column];
				
			} else if (row == rlength-1) {
				return values[row-1][column];
				
			} else {
				nums.add(values[row-1][column]);
				nums.add(values[row+1][column]);
				return getAvg(nums);
				
			}
		} else if (row == 0 && column == 0) {					//top left 
			nums.add(values[row+1][column]);
			nums.add(values[row+1][column+1]);
			nums.add(values[row][column+1]);
			return getAvg(nums);
			
		} else if (row == 0 && column == clength-1) {			//top right 
			nums.add(values[row][column-1]);
			nums.add(values[row+1][column-1]);
			nums.add(values[row+1][column]);
			return getAvg(nums);
			
		} else if (row == rlength-1 && column == 0) {			//bottom left 
			nums.add(values[row-1][column]);
			nums.add(values[row-1][column+1]);
			nums.add(values[row][column+1]);
			return getAvg(nums);
			
		} else if (row == rlength-1 && column == clength-1) {	//bottom right
			nums.add(values[row-1][column]);
			nums.add(values[row-1][column-1]);
			nums.add(values[row][column-1]);
			return getAvg(nums);
			
		} else if (row == 0) {									//top row
			nums.add(values[row][column-1]);
			nums.add(values[row][column+1]);
			nums.add(values[row+1][column-1]);
			nums.add(values[row+1][column]);
			nums.add(values[row+1][column+1]);
			return getAvg(nums);
			
		} else if (row == rlength-1) {							//bottom row
			nums.add(values[row][column-1]);
			nums.add(values[row][column+1]);
			nums.add(values[row-1][column-1]);
			nums.add(values[row-1][column]);
			nums.add(values[row-1][column+1]);
			return getAvg(nums);
			
		} else if (column == 0) {								//left column
			nums.add(values[row-1][column]);
			nums.add(values[row-1][column+1]);
			nums.add(values[row][column+1]);
			nums.add(values[row+1][column+1]);
			nums.add(values[row+1][column]);
			return getAvg(nums);
			
		} else if (column == clength-1) {						//right column
			nums.add(values[row-1][column]);
			nums.add(values[row-1][column-1]);
			nums.add(values[row][column-1]);
			nums.add(values[row+1][column-1]);
			nums.add(values[row+1][column]);
			return getAvg(nums);
			
		} else {												//middle 
			nums.add(values[row-1][column-1]);
			nums.add(values[row-1][column]);
			nums.add(values[row-1][column+1]);
			nums.add(values[row][column-1]);
			nums.add(values[row][column+1]);
			nums.add(values[row+1][column-1]);
			nums.add(values[row+1][column]);
			nums.add(values[row+1][column+1]);
			return getAvg(nums);
		}
	}
	
	public double getAvg(ArrayList<Integer> nums) {
		int sum = 0;
		
		if (!nums.isEmpty()) {
			for (int n : nums) {
				sum += n;
			}
			return ((double)sum) / nums.size();
		}
		return sum;
	}
	
	/**
	* Returns the sum of a row or column in elements in the table
	*
	* @param i the row or column to sum. Assume it will always
	* be within the bounds of the table
	* @param horizontal if true, then i represents a row, else a column.
	* @return the sum of the given row or column.
	*/
	public double sum(int i, boolean horizontal) {
		int rlength = values.length;
		int clength = values[0].length;
		double sum = 0;
		
		if (horizontal) {		//row
			for (int j = 0; j < clength; j++) {
				sum += values[i][j];
			}
			
		} else {				//column
			for (int j = 0; j < rlength; j++) {
				sum += values[j][i];
			}
		}
		return sum; // FIX ME
	}
}