package labs.lab6;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
* Represents a time for an appointment
*/
public class AppointmentTime {
	private LocalTime lt;
	private DateTimeFormatter format1 = DateTimeFormatter.ofPattern("HH:mm").withResolverStyle(ResolverStyle.STRICT);
	private DateTimeFormatter format2 = DateTimeFormatter.ofPattern("H:mm").withResolverStyle(ResolverStyle.STRICT);
	
	/**
	*
	* @param t the string from which to construct the AppointmentTime object
	*
	* Expected format: HH:MM or H:MM
	*
	* @throws RuntimeException with the message "Invalid time" if invalid input
	format
	* or time doesn't exist
	*/
	public AppointmentTime(String t) throws RuntimeException {
		
		boolean v1 = isValid(t, format1);
		boolean v2 = isValid(t, format2);
		
		if (v1 && !v2) {
			lt = LocalTime.parse(t, format1);
		} else if (v2 && !v1) {
			lt = LocalTime.parse(t, format2);
		} else if (v1 && v2) {
			lt = LocalTime.parse(t, format1);
		} else {
			throw new RuntimeException("Invalid time");
		}
	}
	
	private static boolean isValid(String in, DateTimeFormatter f) {
		try {
			LocalTime.parse(in, f);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
	
	/**
	* Determines if the appointment times are equal.
	*
	* @param other the other time
	* @return true if the appointment times are equal, false otherwise
	*/
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		
		if (other == null || getClass() != other.getClass()) {
	        return false;
		}
		
		AppointmentTime obj = (AppointmentTime) other;
	    return lt.equals(obj.lt);
	}
	
	/**
	* Prints a string representation of the time in the format HH:MM
	*
	* @return the time
	*/
	public String toString() {
		//return String.format("%d:%d", hour, min);
		return lt.toString();
	}
}
