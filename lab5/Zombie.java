package labs.lab5;

public class Zombie extends Enemy implements Stompable, GameElement {
	
	private double height;
	
	/*
	 * Constuctor:
	 * sets zombie height
	 * param: height to set to
	 */
	public Zombie(double height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
	}
	
	public int stompOn() {
		height = height/2;
		
		setHealth(getHealth()-25);
		
		return 0;
	}
	
	public void tick() {
		height = height + 1.10;
		
		setHealth(getHealth()+5);
	}
}