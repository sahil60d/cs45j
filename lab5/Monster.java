package labs.lab5;

public class Monster extends Enemy implements Stompable, GameElement {
	
	private String monsterCol;
	
	/*
	 * Constructor:
	 * initializes monster color to green
	 */
	public Monster() {
		monsterCol = "green";
	}
	
	/*
	 * return monster color
	 */
	public String getColor() {
		return monsterCol;
	}
	
	/*
	 * From Stompable
	 * changes monster color to red
	 * Decrements health by 100
	 * return: 100
	 */
	public int stompOn() {
		monsterCol = "red";
		
		setHealth(getHealth()-100);
		
		return 100;
	}
	
	/*
	 * From GameElement
	 * decrements monsters health by 10;
	 * changes Monster's color to the next one in the
	 * cycle green, yellow, blue, green, yellow, blue, ...,
	 * OR if the Monster is red (from a stomp), starts the 
	 * cycle over again with green
	 */
	public void tick() {
		setHealth(getHealth()-10);
		
		switch(monsterCol) {
		case "red":
			monsterCol = "green";
			break;
		case "green":
			monsterCol = "yellow";
			break;
		case "yellow":
			monsterCol = "blue";
			break;
		case "blue":
			monsterCol = "green";
			break;
		}
	}
}