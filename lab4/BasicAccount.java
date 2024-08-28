package labs.lab4;
/**
* A bank account that has a limited number of free deposits and withdrawals.
*/
public class BasicAccount extends BankAccount {
	// ADD INSTANCE VARIABLES HERE
	private int freeTransactions;
	/**
	* Constructs a checking account with a zero balance.
	*/
	public BasicAccount() {
		super(0.0);
		freeTransactions = 3;
	}
	
	/**
	* Withdraws money from the bank account (as long as it's a positive value)
	and
	* possibly incurs fees.
	*
	* Negative balances are allowed at this bank
	*
	* @param amount the amount to withdraw
	*
	* @return true if the withdrawal was made, false otherwise
	*/
	public boolean withdraw(double amount) {
		if (freeTransactions <= 0) {
			super.withdraw(amount+1.0);
			return true;
		} else if (freeTransactions > 0 && freeTransactions <= 3) {
			super.withdraw(amount);
			freeTransactions--;
			return true;
		}
		return false; // FIX ME
	}
	/**
	* Deposits money into the bank account (as long as it's a positive value)
	and
	* possibly incurs fees.
	*
	* @param amount the amount to deposit
	*
	* @return true if the deposit was made, false otherwise
	*/
	public boolean deposit(double amount) {
		if (freeTransactions <= 0) {
			super.deposit(amount-1.0);
			return true;
		} else if (freeTransactions > 0 && freeTransactions <= 3) {
			super.deposit(amount);
			freeTransactions--;
			return true;
		}
		return false; // FIX ME
	}
	/**
	* Resets the transactions at the month's end
	*/
	public void monthEnd() {
		freeTransactions = 3;
	}
}
