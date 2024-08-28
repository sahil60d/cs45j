package labs.lab1;

/**
 * This class models a bug that crawls along a horizontal line.
 */
public class Bug {
	
	private int position;
	private int dir; // 1 == positive, 0 == negative

	
	/**
	 * Constructs a bug with a given position, facing right.
	 * 
	 * @param initialPosition the initial position
	 */
	public Bug(int initialPosition) {
		position = initialPosition;
		dir = 1;
	}

	
	/**
	 * Moves the bug by one unit in the current direction.
	 */
	public void move() {
		if (dir == 1) {
			position += 1;
		} else {
			position -= 1;
		}
	}

	
	/**
	 * Flips the direction of this bug.
	 */
	public void turn() {
		dir ^= 1;
	}

	
	/**
	 * Gets the current position of this bug.
	 * 
	 * @return the position
	 */
	public int getPosition() {
		return position; // FIX ME
	}
}
