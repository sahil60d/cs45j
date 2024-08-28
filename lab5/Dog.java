package labs.lab5;

public class Dog implements Encourager {
	
	@Override
	public String encourage() {
		return String.format("%s | %s", giveWetSloppyKisses(), layOnYourFeet()); // FIX ME (you should call the below private methods)
	}
	
	private String giveWetSloppyKisses() {
		return "Give wet sloppy kisses";
	}
	
	private String layOnYourFeet() {
		return "Lay on your feet";
	}
}
