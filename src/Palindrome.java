/**
 * Test if a word or phrase is a palindrome.
 * Should work with any strings.
 * 
 * @author your name
 */
public class Palindrome {

	/**
	 * Test if the parameter is a palindrome, 
	 * ignoring spaces in the string.
	 * @param phrase is the phrase to test
	 * @return true if it is a palindrom
	 */
	public static boolean isPalindrome(String phrase) {
		return false; //TODO write this method
	}
	
	/**
	 * some simple tests to get you started.
	 */
	public static void testPalindrome() {
		String[] tests = {"dad","Mad","12344321","I","Do geese see god","กา ฝาก","beab"};
		for(String phrase: tests) {
			System.out.printf("Phrase: '%s' ", phrase);
			boolean palindrome = isPalindrome(phrase);
			System.out.printf("%s a palindrome%n", (palindrome?"is":"is not"));
		}
	}
	public static void main(String[] args) {
		testPalindrome(); // you can commit this out after it works
		// write code to ask user for a word or phrase
		// read the WHOLE LINE and test for palindrome
	}
}
