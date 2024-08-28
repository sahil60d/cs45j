package labs.lab5;

public class Nature implements Encourager {
	
	@Override
	public String encourage() {
		return String.format("%s | %s", shineSun(), blowGentleBreeze()); // FIX ME (you should call the below private methods)
	}
	
	private String shineSun() {
		return "Shine sun";
	}
	
	private String blowGentleBreeze() {
		return "Blow gentle breeze";
	}
}
