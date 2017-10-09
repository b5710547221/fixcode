
//package fixcode;

import java.util.Scanner;

/**
 * Console-based code to find the min and max of a polynomial on a given
 * interval. The polynomial is a*x^2 + b*x + c where x in [xmin,xmax] Values of
 * a, b, c, xmin, xmax are read from the console.
 * 
 * Improve this code so that it uses good coding principles, namely: 1) avoid
 * duplicate code - use methods for repeated operations 2) use descriptive names
 * 3) write methods that do just one thing 4) avoid putting program logic in the
 * main() method
 * 
 * TODO: Implement the changes described in "//TODO" comments. After you do
 * them, DELETE the to-do comments. Eclipse shows to-do items with a BLUE
 * CHECKBOX in the left margin. IntelliJ shows "to-do" comments in BLUE.
 * Netbeans doesn't highlight to-do items by default.
 * 
 * There should not be any to-do comments in your submitted code! (points
 * deducted if there are)
 * 
 * @author warat narattharaksa
 */

public class PolyMath {

	public static Scanner console = new Scanner(System.in);

	/**
	 * Find the min and max values of a quadratic function a*x^2 + b*x + c using
	 * input values read from the console.
	 * 
	 * @param args
	 *            not used.
	 */
	public static boolean checker = true;

	public static void main(String[] args) {

		solveMinMax();
	}

	/**
	 * Print a prompt message and read an integer from the console. Return the
	 * value read from console.
	 * 
	 * @param prompt
	 *            a prompt message to print
	 * @return the user's reply as an "int"
	 */

	public static void solveMinMax() {
		System.out.println("Find min and max of the polynomial a*x^2 + b*x + c");

		// Ask for the values of a, b, c that define a quadratic
		// function: a*x*x + b*x + c = (a*x + b)*x + c

		final int a = getIntReply("Enter a: ");
		final int b = getIntReply("Enter b: ");
		final int c = getIntReply("Enter c: ");

		// get the start value (sv) and end value (ev) of the interval to search

		final int xMin = getIntReply("Enter left (min) value of x: ");
		final int xMax = getIntReply("Enter right (max) value of x: ");

		if (xMax < xMin) {
			System.out.println("Invalid range. Must have min value <= max value.");
			System.exit(1);
		}

		// Don't forget to check the end-points of the interval for the min.

		double minValue = findMin(a, b, c, xMin, xMax);
		// Find max value of polynomial.

		double maxValue = findMin(-a, -b, -c, xMin, xMax);

		final double xValueMin = polyval(minValue, a, b, c);
		final double xValueMax = polyval(maxValue, a, b, c);
		final double xValueMinNonCenter = polyval(xMin, a, b, c);
		final double xValueMaxNonCenter = polyval(xMax, a, b, c);

		if (checker == false) {
			if ((xMin >= minValue && xMax >= minValue) || (xMin <= maxValue && xMax <= maxValue)) {
				minValue = xMin;
				maxValue = xMax;
				System.out.printf("The min value is %f at x=%d\n", xValueMinNonCenter, xMin);
				System.out.printf("The max value is %f at x=%d\n", xValueMaxNonCenter, xMax);

			} else if ((xMin <= minValue && xMax <= minValue) || (xMin >= maxValue && xMax >= maxValue)) {
				maxValue = xMin;
				minValue = xMax;
				System.out.printf("The min value is %f at x=%d\n", xValueMinNonCenter, xMin);
				System.out.printf("The max value is %f at x=%d\n", xValueMaxNonCenter, xMax);

			}
		} else {

			// Print the results
			System.out.printf("The min value is %f at x=%.0f\n", xValueMin,  minValue);
			System.out.printf("The max value is %f at x=%.0f\n", xValueMax,  maxValue);
		}
	}

	public static int getIntReply(String prompt) {

		// Print the prompt string and read an int from the console. Return the
		// value.
		System.out.print(prompt);

		return console.nextInt();
	}

	// Use polyval in your code instead of repeating the computation.
	/**
	 * Evaluate a quadratic a*x^2 + b*x +c at a given value. For example, y =
	 * polyval(x, a, b, c).
	 */
	public static double polyval(double x, int a, int b, int c) {
		return a * Math.pow(x, 2) + b * x + c;

	}

	public static double findMin(int a, int b, int c, int xMin, int xMax) {

		double minX = (-1 * b) / 2 * a;

		// this is stupid. the minX value might not be an integer.
		if (minX >= xMin && minX <= xMax) {
			checker = true;
		} else {
			checker = false;
		}

		return minX;

	}

}