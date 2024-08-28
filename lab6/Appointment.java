package labs.lab6;
/**
* Represents an appointment. An appointment consists of a description,
* the date, starting time, and ending time; for example:
*
* Dentist 2019/10/1 17:30 18:30
* 45J Class 2019/10/02 8:30 10:00
*/
public class Appointment {
	private String description;
	private AppointmentDate day;
	private AppointmentTime startTime;
	private AppointmentTime endTime;
	
	/**
	*
	* @param s the string from which to construct the Appointment object
	*
	* Expected format: Description Date StartTime EndTime
	*
	* Date in YYYY/MM/DD format
	* Times in military format (no AM/PM)
	* Assume description will never be empty, nor consist of only whitespace
	* Assume start time time will always come before end time
	*
	* @throws RuntimeException if invalid input format
	*/
	public Appointment(String s) throws RuntimeException {
		String[] a = s.split("\\s+");
		
		//AppointmentDate test = new AppointmentDate("2023/11/12");
		
		description = s.substring(0, (s.indexOf(a[a.length-3])) - 1);
		day = new AppointmentDate(a[a.length-3]);
		startTime = new AppointmentTime(a[a.length-2]);
		endTime = new AppointmentTime(a[a.length-1]);
	}
	
	/**
	* Determines if this appointment is the same as another appointment.
	*
	* @param other the other appointment
	* @return true if the appointments are equal, false otherwise
	*/
	public boolean equals(Object other) {
		if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Appointment otherAppointment = (Appointment) other;
        return description.equals(otherAppointment.description) && day.equals(otherAppointment.day)
                && startTime.equals(otherAppointment.startTime) && endTime.equals(otherAppointment.endTime);
	}
	
	/**
	* Determines if an appointment falls on a certain day.
	*
	* @param d the appointment date
	* @return true if the appointment date falls on the date, false otherwise
	*/
	public boolean fallsOn(AppointmentDate d) {
		return day.equals(d); // FIX ME
	}
	
	/**
	* Return a string representation in the format:
	* Description Date StartTime EndTime
	*/
	public String toString() {
		return String.format("%s %s %s %s", description, day, startTime, endTime); // FIX ME
	}
}