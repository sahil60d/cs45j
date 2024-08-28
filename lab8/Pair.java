package labs.lab8;
/**
* This class collects a pair of elements of different types.
*/
public class Pair<T> {
	private T first;
	private T second;
	
	/**
	* Constructs a pair containing two given elements.
	*
	* @param firstElement the first element
	* @param secondElement the second element
	*/
	public Pair(T firstElement, T secondElement) {
		first = firstElement;
		second = secondElement;
	}
	
	/**
	* Gets the first element of this pair.
	*
	* @return the first element
	*/
	public T getFirst() {
		return first;
	}
	
	/**
	* Gets the second element of this pair.
	*
	* @return the second element
	*/
	public T getSecond() {
		return second;
	}
	
	public String toString() {
	return "(" + first + ", " + second + ")";
	}
	
	public void swap() {
		T temp = first;
		first = second;
		second = temp;
	}
}
