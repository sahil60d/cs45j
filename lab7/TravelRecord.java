package labs.lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
* Represents a record of countries traveled to
*/
public class TravelRecord {
	// ADD INSTANCE VARIABLES HERE
	private ArrayList<Country> countries;
	
	/**
	* Constructs a TravelRecord
	*/
	public TravelRecord() {
		countries = new ArrayList<Country>();
	}
	
	/**
	* Adds a Country with the given name and population to the travel record
	*
	* @param name country name
	* @param population country population
	*/
	public void addCountry(String name, int population) {
		countries.add(new Country(name, population));
	}
	
	/**
	* If a Country with the given name is found, removes the first Country with
	* this name from the record and returns true; if not found, returns false
	*
	* @param name name of the country to remove
	*
	* @return true if the country was found, false otherwise
	*/
	public boolean removeCountry(String name) {
		for (Country c : countries) {
			if (c.getName() == name) {
				return countries.remove(c);
			}
		}
		return false;
	}
	
	/**
	* If a Country with the given population is found, removes the first Country
	* with this population from the record and returns true; if not found,
	* returns false
	*
	* @param population population of the country to remove
	*
	* @return true if the country was found, false otherwise
	*/
	public boolean removeCountry(int population) {
		for (Country c : countries) {
			if (c.getPopulation() == population) {
				return countries.remove(c);
			}
		}
		return false;
	}
	
	/**
	* If a Country with the given name is found, returns the first Country with
	* this name; if not found, returns null
	*
	* @param name name of country to find
	*
	* @return country if found, otherwise null
	*/
	public Country findCountryByName(String name) {
		for (Country c : countries) {
			if (c.getName() == name) {
				return c;
			}
		}
		return null;
	}
	
	/**
	* If a Country with the given population is found, returns the first Country
	* with this population; if not found, returns null
	*
	* @param population population of country to find
	*
	* @return country if found, otherwise null
	*/
	public Country findCountryByPopulation(int population) {
		for (Country c : countries) {
			if (c.getPopulation() == population) {
				return c;
			}
		}
		return null;
	}
	
	/**
	* Returns a String containing the names of all Country objects in the
	record,
	* in ascending order by population (smallest to largest), with a space in
	* between each name
	*
	* @return a String containing the names of all Country objects in the
	record,
	* in ascending order by population (smallest to largest), with a space in
	* between each name
	*/
	public String getNamesOrderedByPopulation() {
		ArrayList<Country> sorted = new ArrayList<Country>(countries);
		Collections.sort(sorted);
		return sorted.stream().map(Object::toString).collect(Collectors.joining(" "));
	}
}
