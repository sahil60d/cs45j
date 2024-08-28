package labs.lab1;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * Defines an integer range for navigating between an 
 * upper and lower bound
 *
 */
public class RangeInput {

	private int low;
	private int up;
	private int current;
	
	/**
	 * Create a range
	 *
	 * @param lower the lower bound of the range
	 * @param upper the upper bound of the range
	 */
	public RangeInput(int lower, int upper) {
		low = lower;
		up = upper;
		current = (int) Math.floor((up + low)/2);
	}
	
	
	/**
	 *
	 * @return the current value within the range
	 */
	public int getCurrent() {
		return current; // FIX ME
	}

	
	/**
	 * Move the current up if not at the upper bound of the range
	 */
	public void up() {
		if (current < up) {
			current++;
		}
	}

	
	/**
	 * Move the current down if not at the lower bound of the range
	 */
	public void down() {
		if (current > low) {
			current--;
		}
	}

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int lower;
		int upper;
		System.out.println("This program illustrates constructing and staying within a range of values\n");
		System.out.println("Enter the lower and upper bound for your range");
		System.out.println("The lower bound should be less than" + "or equal to the upper bound");
		do {
			System.out.print("Enter the minimum value for the range: ");
			lower = in.nextInt();
			System.out.print("Enter the maximum value for the range: ");
			upper = in.nextInt();
			in.nextLine(); // skip remaining characters on the line

		} while (lower > upper);
		RangeInput rangeInput = new RangeInput(lower, upper);
		String command;
		System.out.println("Current value is " + rangeInput.getCurrent());
		System.out.println("Enter command [u=up, d=down, q=quit]");
		command = in.nextLine();
		while (!command.equalsIgnoreCase("q")) {
			if (command.equalsIgnoreCase("u")) {
				rangeInput.up();
			} else if (command.equalsIgnoreCase("d")) {
				rangeInput.down();
			} else {
				System.err.println("Your input must be u or d or q");
			}
			System.out.println("Current value is " + rangeInput.getCurrent());
			command = in.nextLine();
		}
		System.out.println("Done!");
	}

}
