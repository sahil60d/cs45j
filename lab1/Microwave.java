package labs.lab1;

/**
 * A class for representing a microwave oven.
 */
public class Microwave {

	private int timer;
	private int power_level;

	/**
	 * Creates a microwave with 0 seconds on the timer and at power level 1
	 */
	public Microwave() {
		timer = 0;
		power_level = 1;
	}

	/**
	 * Increases the time on the timer by 30 seconds
	 */
	public void increaseTime() {
		timer += 30;
	}

	/**
	 * Switches the power level from 1 to 2, or vice versa
	 */
	public void switchPower() {
		if (power_level == 1) {
			power_level = 2;
		} else {
			power_level = 1;
		}
	}

	/**
	 * Resets the microwave to its initial state.
	 */
	public void reset() {
		timer = 0;
		power_level = 1;
	}

	/**
	 * Starts the machine, and returns information about its cooking state
	 * 
	 * @return	a message containing information about its cooking state ("Cooking 
	 * for ... seconds at level ...")
	 */
	public String start() {
		return "Cooking for " + timer + "seconds at level " + power_level; // FIX ME
	}

}
