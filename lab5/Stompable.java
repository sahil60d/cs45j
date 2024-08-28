package labs.lab5;
/**
* Behavior for a "stompable" game element
*/
public interface Stompable {
	/**
	* "Stomps on" this stompable element; returns the resulting net change
	* in health to the player doing the stomping
	*
	* @return resulting net change in health to the player doing the stomping
	*/
	public int stompOn();
}
