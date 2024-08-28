package labs.lab4;
import java.time.DayOfWeek;
import java.time.LocalDate;
/**
* Weekly appointment.
*/
public class WeeklyAppointment extends Appointment {
	// ADD YOUR INSTANCE VARIABLES HERE
	private DayOfWeek dayOfWeek;
	
	/**
	* Initializes appointment for a given day of the week.
	*
	* @param dayOfWeek the day of the wee
	* @param description the text description of the appointment
	*/
	public WeeklyAppointment(DayOfWeek dayOfWeek, String description) {
		this.dayOfWeek = dayOfWeek;
		super.setDescription(description);
	}
	
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek; // FIX ME
	}
	/**
	* Determines if this appointment occurs on the given date.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	* @return true if the appointment occurs on the given date.
	*/
	public boolean occursOn(int year, int month, int day) {
		LocalDate date = LocalDate.of(year, month, day);
		if (dayOfWeek == date.getDayOfWeek()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	* Returns true if the given object has the same instance variable
	* value(s) as this WeeklyAppointment
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
		
		WeeklyAppointment o = (WeeklyAppointment) otherObject;
		
		if (super.equals(o) && dayOfWeek == o.dayOfWeek) {
			return true;
		}
		
		return false;
	}
}