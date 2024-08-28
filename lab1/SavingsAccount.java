package labs.lab1;

/**
 * A savings account has a balance that can be changed by deposits,
 * withdrawals, and interest, and also keeps track of the number of
 * transactions
 */
public class SavingsAccount {

	private double balance;
	private double intrate;
	private int numtrans;
	
	/**
	 * Constructs a savings account with a zero balance and zero percent interest rate
	 */
	public SavingsAccount() {
		balance = 0;
		intrate = 0.0;
		numtrans = 0;
	}

	
	/**
	 * Constructs a savings account with a given balance
	 * 
	 * @param initialBalance the initial balance (assume it will be >= 0)
	 * @param rate           the interest rate in percent (assume it will be >= 0)
	 */
	public SavingsAccount(double initialBalance, double rate) {
		balance = initialBalance;
		intrate = rate;
		numtrans = 0;
	}


	/**
	 * Deposits money into the savings account.
	 * 
	 * @param amount the amount to deposit (assume it will be > 0)
	 */
	public void deposit(double amount) {
		balance += amount;
		numtrans++;
	}


	/**
	 * Withdraws money from the savings account.
	 * 
	 * @param amount the amount to withdraw (assume it will be > 0)
	 */
	public void withdraw(double amount) {
		balance -= amount;
		numtrans++;
	}


	/**
	 * Gets the current balance of the savings account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance; // FIX ME
	}
	
	
	/**
	 * Gets the total number of transactions (deposits and withdrawals)
	 * that have occurred
	 * 
	 * @return	the number of transactions
	 */
	public int getNumTransactions() {
		return numtrans; // FIX ME
	}


	/**
	 * Adds interest to the savings account.
	 */
	public void addInterest() {
		balance += (balance*intrate)/100;
	}
}