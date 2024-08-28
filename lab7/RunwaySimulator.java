package labs.lab7;
import java.util.LinkedList;
import java.util.Queue;
/**
* Class for simulating a runway
*/
public class RunwaySimulator {
	private Queue<String> takingOff; // holds the planes waiting to take off
	private Queue<String> landing; // holds the planes waiting to land
	
	/**
	* Constructor
	*/
	public RunwaySimulator() {
		takingOff = new LinkedList<String>();
		landing = new LinkedList<String>();
	}
	
	/**
	* Add a flight symbol to the taking off queue
	*
	* @param flightSymbol the flight symbol
	*/
	public void addTakeOff(String flightSymbol) {
		takingOff.add(flightSymbol);
	}
	
	/**
	* Add a flight symbol to the landing queue
	*
	* @param flightSymbol the flight symbol
	*/
	public void addLanding(String flightSymbol) {
		landing.add(flightSymbol);
	}
	
	/**
	* Handles the next action and returns a String describing the next action.
	* If there is no next action, just returns an empty String.
	*
	* @return a String describing the next action.
	* If there is no next action, just returns an empty String
	*/
	public String handleNextAction() {
		if (!landing.isEmpty()) {
			return String.format("%s landing", landing.remove());
		}
		
		if (!takingOff.isEmpty()) {
			return String.format("%s taking off", takingOff.remove());
		}
		
		return ""; // FIX ME
	}
}
