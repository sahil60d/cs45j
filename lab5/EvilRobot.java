package labs.lab5;

public class EvilRobot extends Enemy implements Stompable, GameElement {
	
	private double strength;
	
	public EvilRobot(double strength) {
		this.strength = strength;
	}
	
	public double getStrength() {
		return strength;
	}
	
	public int stompOn() {
		strength = strength * 0.9;
		
		return 0;
	}
	
	public void tick() {
		strength = strength * 1.10;
	}
}