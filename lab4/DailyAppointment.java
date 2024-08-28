package labs.lab4;
/**
* Daily appointment.
*/
public class DailyAppointment extends Appointment {
	/**
	* Constructs a Daily Appointment
	*
	* @param description the text description of the appointment
	*/
	public DailyAppointment(String description) {
		super.setDescription(description);
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
		return true; // FIX ME
	}
	/**
	* Returns true if the given object has the same instance variable
	* value(s) as this DailyAppointment
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
		
		return super.equals(otherObject);
	}
}
