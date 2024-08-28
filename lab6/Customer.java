package labs.lab6;
/**
* A customer that is represented by a name, amount spent, and type
*/
public class Customer {
	// ADD INSTANCE VARIABLES HERE
	private String name;
	private double amountSpent;
	private CustomerType custType;
	
	public static enum CustomerType {
		CORPORATE, PERSONAL
	};
	
	/**
	* Constructs a bank account with a name, amount spent, and customer type
	*
	* If amountSpent < 0, sets it to 0
	*/
	public Customer(String name, double amountSpent, CustomerType custType) {
		this.name = name;
		this.amountSpent = (amountSpent >= 0) ? amountSpent : 0;
		this.custType = custType;
	}
	
	/**
	* Gets the name of the customer.
	*
	* @return the name of the customer
	*/
	public String getName() {
		return name; // FIX ME
	}
	
	/**
	* Gets the amount spent by the customer.
	*
	* @return the amount spent by the customer
	*/
	public double getAmountSpent() {
		return amountSpent; // FIX ME
	}
	
	/**
	* Sets amountSpent to the new amount
	*
	* If amountSpent < 0, sets it to 0
	*
	* @param amountSpent the new amount spent
	*/
	public void setAmountSpent(double amountSpent) {
		this.amountSpent = (amountSpent >= 0) ? amountSpent : 0;
	}
	
	/**
	* Gets the customer type of the customer.
	*
	* @return the customer type of the customer
	*/
	public CustomerType getCustomerType() {
		return custType; // FIX ME
	}
	
	/**
	* Sets customer type to the new type
	*
	* @param custType the new customer type
	*/
	public void setCustomerType(CustomerType custType) {
		this.custType = custType;
	}
	
	/**
	* Returns a string representation of this Customer, consisting of the name,
	* amount spent, and customer type, each separated by a comma and one space
	*/
	@Override
	public String toString() {
		return String.format("%s, %d, %s", name, amountSpent, custType.toString()); // FIX ME
	}
	
	/**
	* Returns true if the name, amount spent, and type are equal to this
	customer,
	* false otherwise
	*/
	@Override
	public boolean equals(Object otherObj) {
		Customer obj = (Customer) otherObj;
		
		if (this.name.equals(obj.getName()) && this.amountSpent == obj.getAmountSpent() && this.custType.equals(obj.getCustomerType())) {
			return true;
		} else {
			return false;
		}
	}
}