package labs.lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
* A class to check the spelling of words.
*/
public class SpellChecker {
	// ADD INSTANCE VARIABLES HERE
	private ArrayList<String> wordList;
	
	/**
	* Creates a SpellChecker object using the specified word list file
	*
	* @param in the scanner containing a list of properly spelled words
	*/
	public SpellChecker(String wordListFileName) {
		File inFile = new File(wordListFileName);
		wordList = new ArrayList<String>();
		
		try {
			Scanner in = new Scanner(inFile);
			
			while (in.hasNext()) {
				wordList.add(in.next().toLowerCase());
			}
			
			in.close();
		} catch (FileNotFoundException exception) {
			System.out.println(String.format("File: %s not found", wordListFileName));
		}
	}
	/**
	* Returns true if the given word is in the word list (ignoring letter
	* case and any character that is not a letter), false otherwise
	*
	* @param word the word to check for
	*
	* @return true if word was found, false otherwise
	*/
	public boolean checkWord(String word) {
		return wordList.contains(word.toLowerCase());
	}
	/**
	* Checks all the words in the given file to see if they are in the word
	* list. Returns a list of all words that were not found in the
	* word list, with all non-letter characters removed. This list
	* should not contain duplicates.
	*
	* @param fileName the filename of the file to check
	*
	* @return a list of all words that were not found in the word list,
	* with all non-letter characters removed. This list should not
	* contain duplicates
	*/
	public List<String> checkFile(String fileName) {
		List<String> notFound = new ArrayList<String>();
		
		try {
			Scanner scan = new Scanner(new File(fileName));
			
			while (scan.hasNext()) {
				String word = scan.next().replaceAll("\\p{Punct}", "");
				
				if (!checkWord(word) && !notFound.contains(word)) {
					notFound.add(word);
				}
			}
			
			scan.close();
		} catch (FileNotFoundException e){
			
		}
		return notFound;
	}
}
