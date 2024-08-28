package labs.lab5;

public class MadClown extends Enemy implements GameElement {
	
	private boolean weapon;
	
	public MadClown(boolean weapon) {
		this.weapon = weapon;
	}
	
	public boolean hasWeapon() {
		return weapon;
	}
	
	public void tick() {
		setHealth(getHealth()-1);
	}
}