package labs.lab9;

public class Customer {
	
	private String name;
	private String email;
	private double amount;
	private String location;
	private String notes;
	private Boolean dog;
	private Boolean cat;
	private Boolean bird;
	private Boolean fish;
	private Boolean other;
	
	public Customer(String name, String email, double amount, String location, String notes, Boolean dog, Boolean cat, Boolean bird, Boolean fish, Boolean other) {
		this.name = name;
		this.email = email;
		//this.pets = pets;
		this.amount = amount;
		this.location = location;
		this.notes = notes;
		this.dog = dog;
		this.cat = cat;
		this.bird = bird;
		this.fish = fish;
		this.other = other;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAmount() {
		return Double.toString(amount);
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public Boolean getDog() {
		return dog;
	}
	
	public void setDog(Boolean dog) {
		this.dog = dog;
	}
	
	public Boolean getCat() {
		return cat;
	}
	
	public void setCat(Boolean cat) {
		this.cat = cat;
	}
	
	public Boolean getBird() {
		return bird;
	}
	
	public void setBird(Boolean bird) {
		this.bird = bird;
	}
	
	public Boolean getFish() {
		return fish;
	}
	
	public void setFish(Boolean fish) {
		this.fish = fish;
	}
	
	public Boolean getOther() {
		return other;
	}
	
	public void setOther(Boolean other) {
		this.other = other;
	}
}