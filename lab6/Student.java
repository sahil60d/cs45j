package labs.lab6;
/**
* Represents a single student.
*/
public class Student {
	// ADD INSTANCE VARIABLES HERE
	private String name;
	private int id;
	private String course;
	private double tuition;
	private String date;
	
	/**
	* Constructs a Student
	*
	* @param name student name
	* @param id id
	* @param course name of course
	* @param tuition tuition paid
	* @param date date signed up for course
	*/
	public Student(String name, int id, String course, double tuition, String
	date) {
		this.name = name;
		this.id = id;
		this.course = course;
		this.tuition = tuition;
		this.date = date;
	}
	
	/**
	* @return name
	*/
	public String getName() {
		return name; // FIX ME
	}
	
	/**
	* @return id
	*/
	public int getId() {
		return id; // FIX ME
	}
	
	/**
	* @return course
	*/
	public String getCourse() {
		return course; // FIX ME
	}
	
	/**
	* @return amount of tuition paid
	*/
	public double getTuition() {
		return tuition; // FIX ME
	}
	
	/**
	* @return date they signed up
	*/
	public String getDate() {
		return date; // FIX ME
	}
}