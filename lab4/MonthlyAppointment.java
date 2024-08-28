package labs.lab4;
/**
* Monthly appointment.
*/
public class MonthlyAppointment extends Appointment {
	// ADD YOUR INSTANCE VARIABLES HERE
	private int day;
	
	/**
	* Initializes appointment to repeat monthly on day of the month.
	*
	* @param day the day of the month
	* @param description the text description of the appointment
	*/
	public MonthlyAppointment(int day, String description) {
		this.day = day;
		super.setDescription(description);
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
		if (this.day == day ) {
			return true;
		} else {
			return false;
		}
	}
	/**
	* Returns true if the given object has the same instance variable
	* value(s) as this MonthlyAppointment
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
		
		MonthlyAppointment o = (MonthlyAppointment) otherObject;
		
		if (super.equals(o) && day == o.day) {
			return true;
		}
		
		return false;
	}
}
