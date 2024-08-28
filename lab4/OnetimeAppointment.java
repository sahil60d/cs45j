package labs.lab4;
/**
* A onetime appointment.
*/
public class OnetimeAppointment extends Appointment {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int year;
	private int month;
	private int day;
	
	/**
	* Initializes appointment for a given date.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	* @param description the text description of the appointment
	*/
	public OnetimeAppointment(int year, int month, int day, String description) {
		this.year = year;
		this.month =  month;
		this.day = day;
		super.setDescription(description);
	}
	
	public int getYear() {
		return year; // FIX ME
	}
	public int getMonth() {
		return month; // FIX ME
	}
	public int getDay() {
		return day; // FIX ME
	}
	
	/**
	* Determines if this appointment occurs on the given date.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	*
	* @return true if the appointment occurs on the given date.
	*/
	public boolean occursOn(int year, int month, int day) {
		if (this.year == year && this.month == month && this.day == day) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	* Returns true if the given object has the same instance variable
	* value(s) as this OnetimeAppointment
	*/
	@Override
	public boolean equals(Object otherObject) {
	// HINT: CALL THE SUPERCLASS'S EQUALS METHOD AS PART OF YOUR IMPLEMENTATION
		if (this == otherObject) {
			return true;
		}
		
		//object is null of wrong class
		if (otherObject == null || this.getClass() != otherObject.getClass()) {
			return false;
		}
		
		OnetimeAppointment o = (OnetimeAppointment) otherObject;
		
		if (super.equals(o) && year == o.year && month == o.month && day == o.day) {
			return true;
		}
		
		return false;
	}
}