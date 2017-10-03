
/**
 * Basic linear algebra and summary methods for arrays.
 * 
 * @author your name
 */
import java.util.*;

public class ArrayMath {
	static Scanner a = new Scanner(System.in);

	/**
	 * Compute the dot-product of two arrays. If the array lengths are not the
	 * same, the dot-product is computed for the first n elements, where n is
	 * the shorter of the two lengths.
	 * 
	 * @param a
	 *            first array
	 * @param b
	 *            second array
	 * @return dot-product, a0*b0 + a1*b1 + ...
	 */
	public static double dotProduct(double[] a, double[] b) {
		// return the dot product of a and b. don't modify a or b.]
		double result = 0;
		for (int i = 0; i < a.length && i < b.length; i++) {
			result += a[i] * b[i];
		}
		return result;
	}

	/**
	 * Compute a linear combination of two arrays x and y, using a*x + b*y =
	 * (a*x[0]+b*y[0], a*x[1]+b*y[1], ...). It does not modify any of the
	 * parameters.
	 * 
	 * @param a
	 *            constant to multiply by first array
	 * @param x
	 *            the first array
	 * @param b
	 *            constant to multiply by second array
	 * @param y
	 *            the second array
	 * @return a new array containing a*x + b*y
	 * 
	 * @precondition x and y are the same length.
	 */
	public static double[] saxpy(double a, double[] x, double b, double[] y) {
		double[] x1 = new double[x.length];
		for (int i = 0; i < x.length; i++) {
			x1[i] = a * x[i];
		}
		double[] x2 = new double[y.length];
		for (int i = 0; i < y.length; i++) {
			x2[i] = b * y[i];
		}
		double[] total = new double[x1.length];
		for (int i = 0; i < x1.length; i++) {
			total[i] += x1[i] + x2[i];
		}
		return total;

	}

	/**
	 * Compute the Euclidean norm of an array. This is the square root of sum of
	 * squared elements in the array. For example: norm([3.0,4.0]) is 5.0.
	 * 
	 * @param x
	 *            array of double values
	 * @return the square-root of sum of squared array elements
	 */
	public static double norm(double[] a) {
		double norm = 0;
		double sum = 0;
		for (int i = 0; i < a.length; i++) {

			sum += a[i] * a[i];
		}
		for (int i = 0; i < a.length; i++) {

			norm += Math.sqrt(sum);
		}
		return norm;
	}

	// min(x)
	// argmin(x)
	// makePrimes(int howMany)

	public static double min(double[] array) {
	    double min = array[0];
		for (int i = 0; i < array.length; i++) {
           if(array[i] <= min){
        	   min = array[i];
           }
		}
		return min;
	}

	public static int argmin(double[] array) {
		double min = array[0];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
           if(array[i] <= min){
        	   min = array[i];
           }
		}
		for(int i =0;i<array.length;i++){
			if(min == array[i]){
				index = i;
			}
		}
		return index;
	}

	public static long[] makePrimes(int numPrime) {
		long[] primes = new long[numPrime];
		int  count = 1;
		int data = 1;
		primes[0]=2;
		do{
			for(int i = 2;i<data;i++){
				if(data % i != 0){
					primes[count] =data;
					count++;
				}
			}
			if(count == numPrime){
				 break;
			}
			data++;
		}while(true);
		return primes;
	}
}
