package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* A roster of students
*/
public class StudentRoster {
	// ADD INSTANCE VARIABLES HERE
	ArrayList<Student> roster;
	
	/**
	* creates a StudentRoster object based on the given file
	*
	* @param rosterFileName filename of roster
	*/
	public StudentRoster(String rosterFileName) {
		roster = new ArrayList<Student>();
		
		try {
			Scanner in = new Scanner(new File(rosterFileName));
			
			while(in.hasNext()) {
				String[] s = in.nextLine().split(";");
				roster.add(new Student(s[0], Integer.valueOf(s[1]), s[2], Double.valueOf(s[3]), s[4]));
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File: " + rosterFileName + "not found");
		}
	}
	
	/**
	* Returns the total amount of tuition paid for the given course
	*
	* @param course name of course
	*
	* @return total tuition paid for the given course
	*/
	public double getCourseTotalTuition(String course) {
		double totalTuition = 0;
		
		for (Student s : roster) {
			if (s.getCourse().equals(course)) {
				totalTuition += s.getTuition();
			}
		}
		return totalTuition; // FIX ME
	}
	
	/**
	* Returns the total number of students in the given course
	*
	* @param course name of course
	*
	* @return total number of students in the given course
	*/
	public int getNumStudentsInCourse(String course) {
		int studentCount = 0;
		
		for (Student s : roster) {
			if (s.getCourse().equals(course)) {
				studentCount++;
			}
		}
		return studentCount; // FIX ME
	}
}