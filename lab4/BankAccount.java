package labs.lab4;
/**
* A bank account has a balance that can be changed by deposits and withdrawals.
*/
public class BankAccount {
	double balance;
	
	/**
	* Constructs a bank account with a zero balance.
	*/
	public BankAccount() {
		balance = 0;
	}
	
	/**
	* Constructs a bank account with a given balance.
	*
	* @param initialBalance the initial balance
	*/
	public BankAccount(double initialBalance) {
		balance = initialBalance;
	}
	
	/**
	* Deposits money into the bank account, as long as it's a positive value
	*
	* @param amount the amount to deposit
	*
	* @return true if the deposit was made, false otherwise
	*/
	public boolean deposit(double amount) {
		if (amount > 0) {
		double newBalance = balance + amount;
		balance = newBalance;
		return true;
		}
		return false;
	}
	
	/**
	* Withdraws money from the bank account, as long as it's a positive value
	* Negative balances are allowed at this bank
	*
	* @param amount the amount to withdraw
	*
	* @return true if the withdrawal was made, false otherwise
	*/
	public boolean withdraw(double amount) {
		if (amount > 0) {
		double newBalance = balance - amount;
		balance = newBalance;
		return true;
		}
		return false;
	}
	
	/**
	* Gets the current balance of the bank account.
	*
	* @return the current balance
	*/
	public double getBalance() {
		return balance;
	}
}