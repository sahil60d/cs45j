package labs.lab3;

/**
* This class generates prime numbers
*/
public class PrimeGenerator {
	
	// ADD INSTANCE VARIABLES HERE
	private int p;
	
	/**
	* Constructs a PrimeGenerator object whose next prime is 2
	*/
	public PrimeGenerator() {
		p = 2;
	}
	
	/**
	* Calculates the next prime number
	*
	* @return the next prime number
	*/
	public int nextPrime() {
		int next = p;
		
		while (true) {
			if (isPrime(next)) {
				p = next+1;;
				return next;
			}
			next++;
		}
	}
	
	public boolean isPrime(int n) {

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
