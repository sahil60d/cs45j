package labs.lab8;

import java.util.Collections;
import java.util.List;

public class Main {
	/**
	* Takes a generic list, reverses it and returns it. Note: the method must
	* modify the original list.
	*
	* @param <T> the type of element in the list
	* @param a the list to reverse
	*
	* @return the reversed list
	*/
	// WRITE PROBLEM 3 METHOD HERE
	public static <T> List<T> problem3_reverse(List<T> list) {
		Collections.reverse(list);
		return list;
	}
	
	/**
	* Takes as a parameter an array of type T and returns a Pair containing the
	minimum
	* and maximum value in the array.
	*
	* @param a the input array
	*
	* @return a Pair containing the minimum and maximum value in the array
	*/
	// WRITE PROBLEM 4 METHOD HERE
	public static <T extends Comparable> Pair<T> problem4_minmax(T[] arr) {
		T min = arr[0];
		T max = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			T curr = arr[i];
			
			if (curr.compareTo(min) < 0) {
				min = curr;
			}
			if (curr.compareTo(max) > 0) {
				max = curr;
			}
		}
		
		return new Pair<>(min, max);
	}
}
