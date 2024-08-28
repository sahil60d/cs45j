package labs.lab5;

public class Dragon extends Enemy implements Stompable, GameElement {
	
	private boolean fireBreathing;
	
	/*
	 * Constructor:
	 * sets whether or not Dragon breathes fire
	 */
	public Dragon(boolean fireBreathing) {
		this.fireBreathing = fireBreathing;
	}
	
	/*
	 * returns f dragon is fire breathing
	 */
	public boolean isFireBreathing() {
		return fireBreathing;
	}
	
	/*
	 * From Stompable
	 * toggles fire breathing
	 * increments dragons health by 50
	 * returns -50
	 */
	public int stompOn() {
		fireBreathing = !fireBreathing;
		
		setHealth(getHealth()+50);
		
		return -50;
	}
	
	/*
	 * From GaneElement
	 * decrements dragon health by 20
	 */
	public void tick() {
		setHealth(getHealth()-20);
	}
}