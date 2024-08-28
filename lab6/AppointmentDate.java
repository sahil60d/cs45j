package labs.lab6;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
* Represents a date for an appointment
*/
public class AppointmentDate {
	// ADD INSTANCE VARIABLES HERE
	private Date date;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	/**
	*
	* @param s the string from which to construct the AppointmentDate object
	* 
	*
	* Expected format: YYYY/MM/DD
	*
	* @throws RuntimeException with the message "Invalid date" if invalid input
	* format or date doesn't exist
	*/
	public AppointmentDate(String d) throws RuntimeException {
		sdf.setLenient(false);
		try {	
			date = sdf.parse(d.trim());
		} catch (ParseException e) {
			throw new RuntimeException("Invalid date");
		}
	}
	
	/**
	* Determines if dates are equal.
	*
	* @param the other date
	* @return true if the dates are equal, false otherwise
	*/
	public boolean equals(Object other) {
		if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        AppointmentDate obj = (AppointmentDate) other;
        return date.equals(obj.date);
	}
	
	/**
	* Prints a string representation of the date in the format YYYY/MM/DD
	*
	* @return the date
	*/
	public String toString() {
		//return formatter.format(date); 
		return sdf.format(date);
	}
}
