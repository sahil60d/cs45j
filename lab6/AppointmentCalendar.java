package labs.lab6;
import java.util.ArrayList;
import java.util.List;
/**
* Represents a calendar that manages appointments
*/
public class AppointmentCalendar {
	// ADD INSTANCE VARIABLES EHRE
	ArrayList<Appointment> calendar;
	
	public AppointmentCalendar() {
		calendar = new ArrayList<Appointment>();
	}
	
	/**
	* Adds an appointment to the calendar.
	*
	* @param a the appointment to add
	*/
	public void add(Appointment a) {
		calendar.add(a);
	}
	
	/**
	* Cancels (removes) an appointment from the calendar.
	*
	* @param a the appointment to cancel
	*/
	public void cancel(Appointment a) {
		calendar.remove(a);
	}
	
	/**
	* Gets all appointments for a certain date.
	*
	* @param d the date
	* @return the appointments for that day
	*/
	public List<Appointment> getAppointmentsForDay(AppointmentDate d) {
		List<Appointment> today = new ArrayList<Appointment>();
		
		for (Appointment a : calendar) {
			if (a.fallsOn(d)) {
				today.add(a);
			}
		}
		return today; // FIX ME
	}
}
