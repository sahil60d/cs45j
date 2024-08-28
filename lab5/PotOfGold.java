package labs.lab5;

public class PotOfGold implements GameElement {
	
	private int numPieces;
	
	public PotOfGold(int numPieces) {
		this.numPieces = numPieces;
	}
	
	public int getNumPieces() {
		return numPieces;
	}
	
	public void tick() {
		numPieces++;
	}
}