package labs.lab3;
import java.util.ArrayList;

/**
* Represents a sequence of numbers
*/
public class Sequence {
	
	private ArrayList<Integer> values;
	
	public Sequence() {
		values = new ArrayList<Integer>();
	}
	
	/**
	*
	* @return the values in this sequence
	*/
	public ArrayList<Integer> getValues() {
		return values;
	}
	
	/**
	* Adds a value to the sequence
	*
	* @param n the value to add
	*/
	public void add(int n) {
		values.add(n);
	}
	
	/**
	* Returns a string representation of the values
	*/
	public String toString() {
		return values.toString();
	}
	
	/**
	* Creates and returns a new sequence, appending this and the other sequence,
	* without modifying either sequence.
	*
	* @param other sequence to append to this one
	*
	* @return new sequence (other appended to this one)
	*/
	public Sequence append(Sequence other) {
		Sequence s = new Sequence();
		ArrayList<Integer> o = other.getValues();
		
		for (int i = 0; i < values.size(); i++) {
			s.add(values.get(i));
		}
		
		for (int i = 0; i < o.size(); i++) {
			s.add(o.get(i));
		}
		
		return s; // FIX ME
	}
	
	/**
	* Merges two sequences, alternating elements from both sequences. If one
	sequence
	* is shorter than the other, then alternate as long as you can and then
	append
	* the remaining elements from the longer sequence.
	*
	* @param other sequence to merge with this one
	*
	* @return new sequence (other merged with this one)
	*/
	public Sequence merge(Sequence other) {
		Sequence s = new Sequence();
		ArrayList<Integer> o = other.getValues();
		
		int length = Math.min(values.size(), o.size());
		
		for (int i = 0; i < length; i++) {
			s.add(values.get(i));
			s.add(o.get(i));
		}
		
		if (values.size() > o.size()) {
			for (int i = length; i < values.size(); i++) {
				s.add(values.get(i));
			}
		} else {
			for (int i = length; i < o.size(); i++) {
				s.add(o.get(i));
			}
		}
		
		return s; // FIX ME
	}
}