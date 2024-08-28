package labs.lab5;

public class Friend extends Person implements Encourager {
	
	public Friend(String name, int age) {
		super(name, age);
	}
	
	@Override
	public String encourage() {
		return String.format("%s | %s", comeOverToHangOut(), bringSnacks()); // FIX ME (you should call the below private methods)
	}
	
	private String comeOverToHangOut() {
		return "Come over to hang out";
	}
	
	private String bringSnacks() {
		return "Bring snacks";
	}
}
