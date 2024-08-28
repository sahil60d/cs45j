package labs.lab3;

public class StringAnalyzer {
	
	// ADD INSTANCE VARIABLES EHRE
	private String str;
	
	public StringAnalyzer(String str) {
		this.str = str;
	}
	
	/**
	*
	* @return a string consisting of only the uppercase letters
	* in the string
	*/
	public String getAllUppercase() {
		char[] s = str.toCharArray();
		String r = "";
		
		for (int i = 0; i < s.length; i++) {
			if (Character.isUpperCase(s[i])) {
				r += s[i];
			}
		}
		
		return r; // FIX ME
	}
	
	/**
	*
	* @return a string consisting of every other char
	* in the string, starting with the first char
	*/
	public String getEveryOtherChar() {
		char[] s = str.toCharArray();
		String r = "";
		
		for (int i = 0; i < s.length; i += 2) {
			r += s[i];
		}
		
		return r; // FIX ME
	}
	
	/**
	*
	* @return a string in which all the vowels in the
	* string are replaced with an asterisk
	*/
	public String replaceVowelsWithAsterisk() {
		char[] s = str.toCharArray();
		
		for (int i = 0; i < s.length; i++) {
			if (isVowel(Character.toUpperCase(s[i]))) {
				s[i] = '*';
			}
		}
		
		return new String(s); // FIX ME
	}
	
	public Boolean isVowel(char c) {
		boolean r = (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') ? true : false;
		return r;
	}
	
	/**
	*
	* @return the number of vowels in the string
	*/
	public int getNumVowels() {
		char[] s = str.toCharArray();
		int count = 0;
		
		for (int i = 0; i < s.length; i++) {		
			if (isVowel(Character.toUpperCase(s[i]))) {
				count++;
			}
		}
		
		return count; // FIX ME
	}
	
	/**
	*
	* @return a string containing the indices of all vowels
	* in the string, each one separated by a single space
	*/
	public String getVowelPositions() {
		char[] s = str.toCharArray();
		String r = "";
		
		for (int i = 0; i < s.length; i++) {
			if (isVowel(Character.toUpperCase(s[i]))) {
				r += i + " ";
			}
		}
		
		if (r == "") {
			return r;
		} else {
			return r.substring(0, r.length()-1);
		}
	
		
	}
}