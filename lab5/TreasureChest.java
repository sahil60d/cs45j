package labs.lab5;

public class TreasureChest implements GameElement {
	
	private double weight;
	
	public TreasureChest(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void tick() {
		weight = weight * .95;
	}
}