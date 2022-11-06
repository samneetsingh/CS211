import java.math.BigInteger;
/* CS211 Fibonacci Class, for Chapter 12 Assignment
 * Bellevue College, W.P. Iverson, instructor
 * January 2020
 */
public class Fibonacci {
	
	// fields, ONE is in any version of Java already
	// but BigInteger.TWO requires Java 9 or higher, so I make one here
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger ONE = new BigInteger("1");
	private static final BigInteger ZERO = new BigInteger("0");
	private int n; // the boring old 32-bit limited int
	
	// only one constructor needed
	public Fibonacci(int number) {
		n = number;
	}
	
	// make this private as right now I cannot think of why we need to allow
	@SuppressWarnings("unused")
	private Fibonacci() {
		this(1);
	}
	
	// Chapter 12, Exercise 2, code from page 128-9.
	public int fibForLoop() {
		int n1 = 1;
		int n2 = 1;
		for (int i = 3; i <= n; i++) {
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n2;
	}	
	
	// Chapter 12, same exercise
	// public accessor into recursive helper
	public int fibonacci() {
		return fibonacci(n);
	}
	
	// private recursive helper given in text
	// Chapter 12, page 830 (5th ed.)
    private int fibonacci(int n) {
        if (n<=2) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    // Exactly the same concept as above, but using BigInteger
    // This allows us to go up to any size integer
	public BigInteger bigFib() {
		return bigFib(new BigInteger(Integer.toString(n)));
	}
	
	// recursive helper
    private BigInteger bigFib(BigInteger n) {
        if (n.compareTo(TWO)<=0) {
            return ONE;
        } else {
            return bigFib(n.subtract(ONE)).add(bigFib(n.subtract(TWO)));
        }
    }

	//public method for finding fibonacci terms up to term number n
	public BigInteger bigFastFib()
	{
		return bigFastFib(new BigInteger(Integer.toString(n)), ZERO, ONE);
	}


	//Recursive helper method
	//n - Backwards counter for calculating terms. Base case n == 1
	//n2 - previous term, begins as 0
	//n1 - current term, begins as 1
	private BigInteger bigFastFib(BigInteger n, BigInteger n2, BigInteger n1)
	{
		//necessary Base Case
		if(n.equals(ONE))
			return n1;
		else
			/*basic decrement method that I should have thought of last week which is really frustrating I didn't because
			it was literally like 5 lines of code and I feel really stupid for not getting in the time span we had*/
			return bigFastFib(n.subtract(ONE), n1, n1.add(n2));
	}

}
