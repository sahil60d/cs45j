package labs.lab1;

import java.awt.Rectangle;
import java.util.Random;

public class Main {
	/**
	* Given an "out" string (with a length that is an even number),
	* and a word, return a new string where the word is in the middle of the out
	string.
	* If the "out" string is empty, simply return the word.
	*
	* @param out the "out" string
	* @param word the word to put in the middle of the "out" string
	*
	* @return a new string where the word is in the middle of the out string
	*/
	public static String problem1_makeOutWord(String out, String word) {
		int index = out.length()/2;

		String newWord = out.substring(0, index) + word + out.substring(index);

		return newWord; // FIX ME
	}
	/**
	* Given a string and an integer n, return a string made of the first and
	last
	* n chars from the string. The string length will be at least n, and n will
	* always be at least 1.
	*
	* @param str the input string
	* @param n the number of chars to take from the beginning and end of
	the string
	*
	* @return a string made of the first and last n chars from the input string
	*/
	public static String problem2_firstLastN(String str, int n) {
		String newStr = str.substring(0, n) + str.substring(str.length() - n);
		return newStr; // FIX ME
	}
	/**
	* Simulate rolling a die exactly 5 times, and return the results of the
	rolls
	* as a string, with each result separated by a space. Construct an object of
	* the Random class (see the Java API docs) and invoke an appropriate method
	* to generate each roll.
	*
	*
	* @return the results of 5 die rolls as a string, with each result separated
	by a space
	*/
	public static String problem3_rollDie() {
		Random rand = new Random();
		String result = "";
		
		for (int i = 0; i < 4; i++) {
			int n = rand.nextInt(6) + 1;
			result += String.valueOf(n) + " ";
		}
		
		result += String.valueOf(rand.nextInt(6) + 1);
		
		return result; // FIX ME
	}
	/**
	* Write a method that creates two Rectangle objects and returns a Rectangle
	object
	* that is the intersection of the two rectangles.
	*
	* Assume all inputs for height and width will always be >= 0.
	*
	* @param x1 x position of the first rectangle
	* @param y1 y position of the first rectangle
	* @param width1 width of the first rectangle
	* @param height1 height of the first rectangle
	* @param x2 x position of the second rectangle
	* @param y2 y position of the second rectangle
	* @param width2 width of the second rectangle
	* @param height2 height of the second rectangle
	*
	* @return a Rectangle object that is the intersection of the two rectangles
	*/
	public static Rectangle problem4_rectIntersect(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2) {
		Rectangle r1 = new Rectangle(x1, y1, width1, height1);
		Rectangle r2 = new Rectangle(x2,y2, width2, height2);
		
		Rectangle inter = r1.intersection(r2);
		
		return inter; // FIX ME
	}
	/**
	* Given a string and an integer index, return a new string with the
	following transformations
	* applied:
	*
	* 1. Delete the character at the index (assume it will be within bounds)
	* 2. Reverse the resulting string
	*
	* Hint: See the StringBuilder class in the Java API docs.
	*
	* @param str the string to be transformed
	* @param index the index at which to delete a character
	* @return the string with transformations applied
	*/
	public static String problem5_deleteAndReverse(String str, int index) {
		StringBuilder newStr = new StringBuilder();
		
		newStr.append(str);
		newStr.deleteCharAt(index);
		newStr.reverse();
		
		return newStr.toString(); // FIX ME
	}
}