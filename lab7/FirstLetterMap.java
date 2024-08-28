package labs.lab7;
import java.io.FileNotFoundException;
/**
* Reads all words from a file and adds them to a map
* whose keys are the first letters of the words and
* whose values are sets of words that start with
* that same letter.
*/
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class FirstLetterMap {
	private Map<Character, Set<String>> words;
	
	/**
	* Constructs a new FirstLetterMap based on the given file. Reads all words
	from
	* the file with the given name and adds them to a map whose keys are the
	first
	* letters of the words and whose values are sets of words that start with
	that
	* same letter.
	*
	* All non-letter characters are ignored. All letters are converted to lower
	* case for processing.
	*
	* @param fileName name of the file on which to construct the map
	*/
	public FirstLetterMap(String fileName) {
		words = new TreeMap<>();
		
		try (Scanner in = new Scanner(new File(fileName))) {
			
			while(in.hasNext()) {
				String word = in.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
				if (word.equals("")) continue;
				
				Character first = word.charAt(0);
				if (!Character.isLetter(first)) continue;
				
				//letter in map
				if (words.containsKey(first)) {
					Set<String> vals = words.get(first);
					vals.add(word);
					words.put(first, vals);
				} else {		//add letter key
					Set<String> vals = new TreeSet<String>();
					vals.add(word);
					words.put(first, vals);
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.print("File: " + fileName + " not found");
		}
	}
	
	/**
	* Returns a sorted set of all words in the map that start with the given
	* character
	*
	* @param c the character beginning the words
	* @return a sorted set of all words in the map that start with the given
	* character
	*/
	public Set<String> getWordsThatStartWith(char c) {
		return words.get(c); 
	}
	
	/**
	* Returns a string representation of the map with the keys and each set of
	* words sorted in lexicographic order (HINT: call the toString method of the
	* words map
	*/
	@Override
	public String toString() {
		String r = "";
		
		for (Character key : words.keySet()) {		
			r += key + "=" + words.get(key).toString() + ", ";
		}
		
		return "{" + r.substring(0, r.length()-2) + "}";
		
	}
}
