package labs.lab4;

import java.util.ArrayList;

/**
* A class to manage employees and their paychecks
*
*/
public class Payroll {
	// ADD INSTANCE VARIABLES EHRE
	
	ArrayList<Employee> employees;
	
	/**
	* Constructor
	*/
	public Payroll() {
		employees = new ArrayList<Employee>();
	}
	
	/**
	* Adds the employee to the payroll if an employee with that
	// id doesn't already exist in the payroll
	*
	* @param emp employee to add
	*/
	public void addEmployee(Employee emp) {
		boolean found = false;
		
		for (Employee e : employees) {
			if (e.getId() == emp.getId()) {
				found = true;
				break;
			}
		}
		
		if (!found) {
			employees.add(emp);
		}
	}
	/**
	* Removes employee with the given id if it exists
	*
	* @param id id of employee to remove
	*/
	public void removeEmployee(int id) {		
		for (Employee e : employees) {
			if (e.getId() == id) {
				employees.remove(e);
				break;
			}
		}
	}
	
	/**
	* Generates the paycheck for the employee with the given id, or an error
	message.
	*
	* Employees are paid their hourly rate for each hour worked. However, if
	they worked
	* more than 40 hours per week, they are paid at 150% of the regular rate for
	those
	* overtime hours.
	* Non-provisional employees are deducted 10% of their total pay for
	benefits.
	* Pay is rounded to at most 2 decimal places (hint: use Math.round(pay *
	100.0) / 100.0)
	*
	* if employee not found ("Error: No employee found with id [insert id number
	here]").
	* Paycheck format is: "Id: [id], Name: [name], Amount: [amount]"
	*
	* @param id id of employee for which to generate the paycheck
	*
	* @return paycheck or error message
	*/
	public String getPaycheck(int id) {
		boolean found = false;
		Employee emp = null;
		
		// no emp
		for (Employee e : employees) {
			if (e.getId() == id) {
				emp = e;
				found = true;
				break;
			}
		}
		
		if(!found) {
			return "Error: No employee found with id " + id;
		}
		
		double amount;
		
		if (emp.getHoursWorked() > 40.0) {
			double overtime = emp.getHoursWorked() - 40.0;
			
			amount = (emp.getPayRate() * 40) + ((emp.getPayRate()*1.50) * overtime);
			
		} else {
			amount = emp.getPayRate() * emp.getHoursWorked();
		}
		
		if (!emp.isProvisional()) {
			amount = amount * 0.9;
		}
		
		amount = Math.round(amount * 100.0) / 100.0;
		
		return "Id: " + emp.getId() + ", Name: " + emp.getName() + ", Amount: $" + amount; // FIX ME
	}
}
