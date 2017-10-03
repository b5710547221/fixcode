
/**
 * Some tests of methods in the ArrayMath class.
 * These tests are similar to the way JUnit works.
 * 
 * @author jim
 * @see http://junit.org/junit4/
 */
public class ArrayMathTest {
	/** Tolerance for comparing two values. */
	private static final double TOL = 1.0E-6;
	private int passed = 0;
	private int failed = 0;
	static ArrayMath  ArrayMath= new ArrayMath();
	public void init() {
		passed = failed = 0;
	}
		
	public void testDotProduct() {
		double[] a = { 2, 3, 4};
		double[] b = { 1, -1, 0.5};
		assertEquals("dotProduct 1", 2.0-3.0+4*0.5, ArrayMath.dotProduct(a,b));
		b = new double[]{0, 0, 0};
		assertEquals("dotProduct 2", 0.0, ArrayMath.dotProduct(a,b));
		b = new double[]{10,20};
		assertEquals("dotProduct 3", 2*10+3*20, ArrayMath.dotProduct(a, b));
		b = new double[]{100,200,300,400,500};
		assertEquals("dotProduct 4", 2*100+3*200+4*300, ArrayMath.dotProduct(a, b));
		// trivial case
		a = new double[]{2.0};
		b = new double[]{5.0};
		assertEquals("dotProduct 5", a[0]*b[0], ArrayMath.dotProduct(a, b));
	}
	
	public void testSaxpy() {
		double[] x = {2.0, 3.0, 4.0};
		double[] y = {-1.0, 5.0, 10.0};
		double a = 1.0;
		double b = 10.0;
		double[] expected = {2-10,3+50,4+100};
		assertEquals("saxpy 1", expected, ArrayMath.saxpy(a, x, b, y));
		
		a = -5.0;
		b = 1.0;
		expected = new double[]{-10-1,-15+5,-20+10};
		assertEquals("saxpy 2", expected, ArrayMath.saxpy(a, x, b, y));
		x = new double[]{20, 40, 60, 80, 100};
		
		y = x;
		a = 0.5;
		b = -0.25;
		expected = new double[]{ 10-5,20-10, 30-15, 40-20, 50-25};
		assertEquals("saxpy 3", expected, ArrayMath.saxpy(a, x, b, y));
	}
	
	/** Test the norm method. */
	public void testNorm() {
		double[] x = { 55 };
		assertEquals("norm 1", 55.0, ArrayMath.norm(x));
		x = new double[] {1.0, 2.0, 3.0, -4.0};
		assertEquals("norm 2", Math.sqrt(1*1+2*2+3*3+4*4), ArrayMath.norm(x));
		x = new double[] {0, 0, 0, 0, 1000};
		assertEquals("norm 3", 1000, ArrayMath.norm(x));
	}
	
	public void testMin() {
		double[] x = { Double.MAX_VALUE };
		double result = ArrayMath.min(x);
		int index = ArrayMath.argmin(x);
		assertEquals("min test 1", x[0], result);
		assertEquals("argmin test 1", 0, index);
		x = new double[] { -1, 1.1*TOL };
		result = ArrayMath.min(x);
		index = ArrayMath.argmin(x);
		assertEquals("min tests 2", -1, result);
		assertEquals("argmin test 2", 0, index);
		int n = 20;
		x = new double[n];
		x[0] = 1.0E4;
		for(int k=1; k<x.length; k++) x[k] = 0.5*x[k-1];
		double expected = x[n-1];
		result = ArrayMath.min(x);
		index = ArrayMath.argmin(x);
		assertEquals("min tests 3", 0, result);
		assertEquals("argmin test 3", n-1, index);
		// change location of minimum
		int m = n/2 + 1;
		x[m] = x[n-1];
		x[n-1] = Double.MAX_VALUE;
		result = ArrayMath.min(x);
		index = ArrayMath.argmin(x);
		assertEquals("min tests 4", 0, result);
		assertEquals("argmin test 3", m, index);
	}
	
	
	/** Test if two double are equal. */
	public boolean assertEquals(String msg, double expected, double actual) {
		if (Math.abs(expected-actual) > TOL*Math.abs(expected)) {
			System.out.printf("%s: expected %f, actual value %f%n", msg, expected, actual);
			return fail();
		}
		System.out.printf("Test %s passed.%n", msg);
		return pass();
	}
	
	/** Test if two arrays are equal. */
	public boolean assertEquals(String msg, double[] expected, double[] actual) {
		if (actual == null && expected != null) {
			System.out.printf("%s: Array should not be null%n", msg);
			return fail();
		}
		if (actual != null && expected == null) {
			System.out.printf("%s: Array should be null but is not.%n", msg);
			return fail();
		}
		if (actual.length != expected.length) {
			System.out.printf("%s: Array length %d incorrect%n", msg, actual.length);
			return fail();
		}
		for(int k=0; k<expected.length; k++) {
			if (Math.abs(expected[k]-actual[k]) > TOL*Math.abs(expected[k])) {
				System.out.printf("%s: element %d expected %f, actual value %f%d", 
						msg, k, expected[k], actual[k]);
				return fail();
			}
		}
		System.out.printf("Test %s passed.%n", msg);
		return pass();
	}
	
	/** Test if two arrays of object references are equal. */
	public boolean assertEquals(String msg, Object[] expected, Object[] actual) {
		if (actual == null && expected != null) {
			System.out.printf("%s: Array should not be null%n", msg);
			return fail();
		}
		if (actual != null && expected == null) {
			System.out.printf("%s: Array should be null but is not.%n", msg);
			return fail();
		}
		if (actual.length != expected.length) {
			System.out.printf("%s: Array length %d incorrect%n", msg, actual.length);
			return fail();
		}
		for(int k=0; k<expected.length; k++) {
			if (expected[k]==null && actual[k]!=null) {
				System.out.printf("%s: element %d expected %f, actual value %f%d", 
						msg, k, expected[k], actual[k]);
				return fail();
			}
			if (expected[k]!=null && actual[k]==null) {
				System.out.printf("%s: element %d expected %f, actual value %f%d", 
						msg, k, expected[k], actual[k]);
				return fail();
			}
			if ( ! expected[k].equals(actual[k]) ) {
				System.out.printf("%s: element %d expected %f, actual value %f%d", 
						msg, k, expected[k], actual[k]);
				return fail();
			}
		}
		System.out.printf("Test %s passed.%n", msg);
		return pass();
	}
	
	/** Count failures. */
	private boolean fail() {
		failed++;
		return false;
	}
	
	/** Count passed tests. */
	private boolean pass() {
		passed++;
		return true;
	}
	
	public void run() {
		init();
		testDotProduct();
		testSaxpy();
		testNorm();
		testMin();
		
		System.out.println("Tests passed: "+passed);
		System.out.println("Tests failed: "+failed);
	}
	
	public static void main(String[] args) {
		ArrayMathTest tester = new ArrayMathTest();
		tester.run();
	}
}
