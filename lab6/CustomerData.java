package labs.lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
* Contains data and does some analysis about all customers in a store
*/
public class CustomerData {
	// ADD INSTANCE VARIABLES HERE
	ArrayList<Customer> customers;
	/**
	* Constructs a new CustomerData object from the data in the file
	*
	* If a file contains more than one customer with the same name, the data
	from
	* the last one read overwrites the previously read data.
	*/
	public CustomerData(String fileName) {
		customers = new ArrayList<Customer>();
		
		try {
			Scanner in = new Scanner(new File(fileName));
			
			while (in.hasNext()) {
				String name = in.next();
				for (int i = 0; i < customers.size(); i++) {
					if (customers.get(i).getName() == name) {
						customers.remove(i);
						break;
					}
				}
				
				customers.add(new Customer(name, in.nextDouble(), Customer.CustomerType.valueOf(in.next())));
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.print("File: " + fileName + " not found");
		}
	}
	
	/**
	* Gets the customer(s) with the highest amount spent.
	*
	* @return a list containing the customer(s) with the highest amount spent.
	If
	* there is only 1 customer with the highest amount, the list
	contains
	* only that one customer. If there are > 1 customer with the highest
	* amount, the list contains them all, in an undetermined order.
	*/
	public List<Customer> getBestCustomer() {
		List<Customer> best = new ArrayList<Customer>();
		double min = -1;
		
		for (Customer c : customers) {
			double amount = c.getAmountSpent();
			
			if (amount > min) {
				min = amount;
				best.clear();
				best.add(c);
			} else if (amount == min) {
				best.add(c);
			}
		}
		
		return best; // FIX ME
	}
	
	/**
	* Gets the customer(s) of the given customer type with the highest amount
	* spent.
	*
	* @return a list containing the customer(s) of the given type with the
	highest
	* amount spent. If there is only 1 customer with the highest amount,
	* the list contains only that one customer. If there are > 1
	customer
	* with the highest amount, the list contains them all, in an
	* undetermined order.
	*/
	public List<Customer> getBestCustomer(Customer.CustomerType custType) {
		List<Customer> best = new ArrayList<Customer>();
		double min = -1;
		
		for (Customer c : customers) {
			double amount = c.getAmountSpent();
			
			if (amount > min && c.getCustomerType() == custType) {
				min = amount;
				best.clear();
				best.add(c);
			} else if (amount == min && c.getCustomerType() == custType) {
				best.add(c);
			}
		}
		
		return best; // FIX ME
	}
}
