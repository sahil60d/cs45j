package labs.lab7;
/**
* Represents a country in a travel record
*/
public class Country implements Comparable<Country> {
	// ADD INSTANCE VARIABLES HERE
	private String name;
	private int pop;
	
	/**
	* Constructs a Country with the given name and population
	*
	* @param name country name
	* @param population population of country
	*/
	public Country(String name, int population) {
		this.name = name;
		pop = population;
	}
	
	/**
	* @return name
	*/
	public String getName() {
		return name; // FIX ME
	}
	
	/**
	* @return population
	*/
	public int getPopulation() {
		return pop; // FIX ME
	}
	
	@Override
	public int compareTo(Country otherObject) {
		Country obj = (Country) otherObject;
		
		if (pop > obj.pop) return 1;
		if (pop < obj.pop) return -1;
		return 0;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
