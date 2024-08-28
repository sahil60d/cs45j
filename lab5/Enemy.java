package labs.lab5;

public abstract class Enemy {
	
	private int health;
	
	/*
	 * Constructor:
	 * Sets health to 100
	 */
	public Enemy() {
		health = 100;
	}
	
	/*
	 * returns: health
	 */
	public int getHealth() {
		return health;
	}
	
	/*
	 * sets health
	 * param: health to set to
	 * if health > 100, set to 100
	 * if health < 0 set to 0
	 */
	public void setHealth(int health) {
		if (health > 100) {
			this.health = 100;
		} else if (health < 0) {
			this.health = 0;
		} else {
			this.health = health;
		}
	}
}