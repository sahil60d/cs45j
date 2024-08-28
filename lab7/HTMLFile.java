package labs.lab7;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
* Write a program that checks whether a sequence of HTML tags is properly
* nested. For each opening tag, such as <p>, there must be a closing tag
* </p>. A tag such as <p> may have other tags inside, for example
* <p> <ul> <li> </li> </ul> <a> </a> </p>
*
* The inner tags must be closed before the outer ones. Your program should
* process a file containing tags. For simplicity, assume that the tags are
* separated by spaces, and that there is no text inside the tags.
*/
public class HTMLFile {
	// ADD INSTANCE VARIABLES HERE
	private String fileName;
	/**
	* Constructs an HTMLFile with the data from a file
	*
	* @param fileName file containing HTML
	*/
	public HTMLFile(String fileName) {
		try (Scanner in = new Scanner(new File(fileName))) {
			this.fileName = fileName;
		} catch (FileNotFoundException e) {
			System.out.print("File: " + fileName + " not found");
		}
		
	}
	
	/**
	* @return whether this file contains valid HTML or not
	*/
	public boolean isValid() {
		try (Scanner in = new Scanner(new File(fileName))) {
			
			Stack<String> tagStack = new Stack<String>();
			
			while (in.hasNext()) {
				String checkTag = in.next();
				
				if (checkTag.startsWith("<") && checkTag.endsWith(">")) {			//its a tag
					String tagName = checkTag.substring(1, checkTag.length()-1);
					
					if (tagName.startsWith("/")) {									//closing tag
						if (tagStack.isEmpty()) return false;
						
						String openTag = tagStack.pop();
						if (!tagName.substring(1).equals(openTag)) return false;	//tags don't match
						
					} else {														//opening tag
						tagStack.push(tagName);
					}
				}		
			}
			
			return tagStack.isEmpty();
			
		} catch (FileNotFoundException e) {
			System.out.print("File: " + fileName + " not found");
			return false;
		}
	}
}
