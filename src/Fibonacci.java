/**
 * Generate Fibonacci numbers.
 * 
 * @author your name
 */
public class Fibonacci {
	/**
	 * Generate and return the first n Fibonacci numbers, where f[0] = f[1] = 1.
	 * 
	 * @param n
	 *            the number of Fibonacci numbers to generate
	 * @return array of n Fibonacci numbers
	 */
	public static long[] makeFibonacci(int n) {

		long[] f = new long[n];
		f[0] = 1;
		if (n == 2) {
			f[1] = 1;
		}
		if (n > 2) {
			for (int i = 2; i < n; i++) {
				f[i] = f[i - 1] + f[i - 2];
				System.out.println(f[i]);
			}
		}
		return f;
	}

	/**
	 * Simple visual test of makeFibonacci. It doesn't actually test if the
	 * values are correct.
	 */
	public static void testFibonacci(int size) {
		final String FORMAT = "makeFibonacci(%d) returned array of size %d. ";

		long[] f = makeFibonacci(size);
		if (f == null)
			return; // you didn't write the method yet
		System.out.printf(FORMAT, size, f.length);
		if (f.length != size) {
			System.out.println("INCORRECT");
			return; // don't bother to test further
		}
		System.out.println("Correct.");

		System.out.println("Last few values are:");
		int start = Math.max(0, f.length - 5);
		for (int k = start; k < f.length; k++)
			System.out.printf("Fib[%d] = %,d%n", k, f[k]);
	}

	public static void main(String[] args) {
		// Fibonacci sizes to test:
		int[] sizes = { 1, 2, 50 };
		// This is a for-each loop: "foreach size in sizes".
		for (int size : sizes) {
			testFibonacci(size);
		}
		makeFibonacci(1);
		makeFibonacci(5);
		makeFibonacci(50);
	}
}
