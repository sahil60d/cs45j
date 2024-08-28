package labs.lab4;

import java.util.Objects;

/**
* A class to keep track of an appointment.
*/
public abstract class Appointment {
	
	private String description;
	
	/**
	* Constructs an appointment without a description.
	*/
	public Appointment() {
		description = "";
	}
	
	/**
	* Sets the description of this appointment.
	*
	* @param description the text description of the appointment
	*/
	public void setDescription(String description) {
		this.description = description;
	}
		
	public String getDescription() {
		return description;
	}
		
	/**
	* Determines if this appointment occurs on the given date.
	*
	* @param year the year
	* @param month the month
	* @param day the day
	* @return true if the appointment occurs on the given date.
	*/
	public abstract boolean occursOn(int year, int month, int day);
	
	/**
	* Converts appointment to string description.
	*/
	@Override
	public String toString() {
		return description;
	}
		
	/**
	* Returns true if the given object has the same instance variable
	* value(s) as this Appointment
	*/
	@Override
	public boolean equals(Object otherAppointment) {
		Appointment a = (Appointment) otherAppointment;

		if (this.getClass() == otherAppointment.getClass() && description == a.description) {
			return true;
		}
		return false;
	}
}