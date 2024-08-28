package labs.lab9;

import java.util.ArrayList;

public class CustomerTracker {
	
	private ArrayList<Customer> customers;
	
	public CustomerTracker() {
		customers = new ArrayList<>();
	}
	
	public void addCustomer(Customer c) {
		//Check is customer is already in list, update existing dont add new
		customers.add(c);
	}
	
	public void removeCustomer(String n) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getName().equals(n)) {
				customers.remove(i);
			}
		}
	}
	
	public Customer get(String n) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getName().equals(n)) {
				return customers.get(i);
			}
		}
		return null;
	}
}