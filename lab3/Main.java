package labs.lab3;
import java.util.HashMap;

public class Main {
	/**
	* Accepts a String as a parameter and returns a String where every
	* appearance of the lowercase word "is" has been replaced with
	* "is not". The word "is" should not be immediately preceded or
	* followed by a letter -- so for example the "is" in "this" does
	* not count.
	*
	* @param str the original string
	*
	* @return a string where every appearance of the lowercase
	* word "is" has been replaced with "is not"
	*/
	public static String problem1_notReplace(String str) {
		
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				if (str.charAt(i) == 'i' && str.charAt(i+1) == 's' && checkWord(str, i)) {
					str = str.substring(0, i + 2) + " not" + str.substring(i+2);
				}
			}
		}
		
		return str;
	}
	
	public static boolean checkWord(String str, int i) {
		if (i == 0 && !Character.isAlphabetic(str.charAt(i+2))) { 							// "is" is first word
			return true;
		} else if (i == str.length()-2 && !Character.isAlphabetic(str.charAt(i-1))) {			// "is" is last word
			return true;
		} else if (!Character.isAlphabetic(str.charAt(i-1)) && !Character.isAlphabetic(str.charAt(i+2))) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	* Given two strings, original and segment, return a version of the original
	string
	* where all instances of the segment string have been removed (not
	* case-sensitive). You may assume that the segment string is length >= 1.
	*
	* Remove only non-overlapping instances, so if original is "xxx" and segment
	is
	* "xx", it leaves "x".
	*
	* @param original the string from which to remove text
	* @param segment the text to remove
	*
	* @return original with segment removed
	*/
	public static String problem2_removeSegment(String original, String segment) {
		original = original.replaceAll(segment, "");
		
		segment = segment.toLowerCase();
		original = original.replaceAll(segment, "");
		
		segment = segment.toUpperCase();
		original = original.replaceAll(segment, "");
		
		original = original.replaceAll("  ", " ");
		
		return original; // FIX ME
	}
	
	/**
	* We'll say that a "quadruplet" in a string is a char appearing four times
	in a
	* row. Return the number of quadruplets in the given string. The quadruplets
	* may overlap.
	*
	* @param str the string to check for quadruplets
	* @return the number of quadruplets in the string
	*/ 
	public static int problem3_countQuadruplets(String str) {
		int quadcount = 0;
		int track = 1;
		char prev = '\0';
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == prev && track >= 3) {
				quadcount++;
			} else if (str.charAt(i) == prev) {
				track++;
			} else {
				track = 1;
			}
			prev = str.charAt(i);
		}
		return quadcount; // FIX ME
	}
	
	/**
	* Consider the leftmost and rightmost appearances of some value in an array.
	* We'll say that the "interval" is the number of elements between the two,
	inclusive.
	* A single value has an interval of 1. Return the largest interval found in
	the
	* given array.
	*
	* @param nums the array in which to find the interval
	* @return the largest interval in the array
	*/
	public static int problem6_maxInterval(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		int max = 1;
		
		for (int i = 0; i < nums.length; i++) {
			int curr = nums[i];
			
			if(map.containsKey(curr)) {
				int last = map.get(curr);
				int interval = i-last+1;
				
				if (interval > max) {
					max = interval;
				}
			} else {
				map.put(curr, i);
			}
		}
		
		return max; // FIX ME
	}
	
	/**
	* Given a non-empty array, return true if there is a place to split the
	array
	* so that the sum of the numbers on one side is equal to the sum of the
	numbers
	* on the other side.
	*
	* @param nums the array to split
	* @return true if there is a place to split the array so that the sum of the
	* numbers on one side is equal to the sum of the numbers on the
	other
	* side
	*/
	public static boolean problem7_sumSplitBalance(int[] nums) {
		if (nums.length == 1) {
			return false;
		}
		
		int sum = 0;
		int halfsum = 0;
		
		for (int n : nums) {
			sum += n;
		}
		
		for (int i = 0; i < nums.length; i++) {
			halfsum += nums[i];
			
			if (halfsum == (sum - halfsum)) {
				return true;
			}
		}
		
		return false;
	}
}