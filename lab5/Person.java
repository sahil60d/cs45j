package labs.lab5;

import java.lang.Integer;

public abstract class Person implements Comparable {
	// ADD INSTANCE VARIABLES HERE
	
	private String name;
	private int age;
	
	/**
	*
	* @param name no validity checks necessary -- assume all valid input
	* @param age no validity checks necessary -- assume all valid input
	*/
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name; // FIX ME
	}
	
	public int getAge() {
		return age; // FIX ME
	}
	
	/**
	* compares first by name (use String.compareTo), then by age
	*/
	@Override
	public int compareTo(Object otherPerson) {
		int comp = name.compareTo(((Person)otherPerson).getName());
		if (comp == 0) {
			return ((Integer)age).compareTo(((Person)otherPerson).getAge());
		}
		
		return comp;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Age: %d", name, age); // FIX ME
	}
}
