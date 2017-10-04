
/**
 * Test if a word or phrase is a palindrome.
 * Should work with any strings.
 * 
 * @author your name
 */
import java.util.*;

public class Palindrome {
	static Scanner a = new Scanner(System.in);

	/**
	 * Test if the parameter is a palindrome, ignoring spaces in the string.
	 * 
	 * @param phrase
	 *            is the phrase to test
	 * @return true if it is a palindrom
	 */
	public static boolean isPalindrome(String phrase) {
		
		boolean isPalin = true;
		for (int i = 0; i < phrase.length() && phrase.length() % 2 == 0; i++) {

			if (phrase.charAt(i) == (phrase.charAt(phrase.length() - i - 1))) {
				isPalin = true;
			} else {
				isPalin = false;
			}
		}
		for (int i = 0; i < phrase.length() / 2 && phrase.length() % 2 != 0; i++) {

			if (phrase.charAt(i) == (phrase.charAt(phrase.length() - i - 1))) {
				isPalin = true;
			} else {
				isPalin = false;
			}
		}
		return isPalin;
	}

	/**
	 * some simple tests to get you started.
	 */
	public static void testPalindrome() {
		String[] tests = { "dad", "Mad", "12344321", "I", "Do geese see god", "กา ฝาก", "beab" };
		for (String phrase : tests) {
			System.out.printf("Phrase: '%s' ", phrase);
			boolean palindrome = isPalindrome(phrase);
			System.out.printf("%s a palindrome%n", (palindrome ? "is" : "is not"));
		}
	}

	public static void main(String[] args) {
		testPalindrome(); // you can commit this out after it works
		// write code to ask user for a word or phrase
		// read the WHOLE LINE and test for palindrome
		System.out.println("Enter a blank line to quit.");
		String test = " ";
		String testfinal =" ";
		String testlast =" ";
		while (true) {
			System.out.print("Enter a phrase: ");
			test = a.nextLine();
			if(test.equals("")){
				break;
			}
			testfinal = test.toLowerCase();
			testlast = testfinal.replaceAll(" ", "");
			
			System.out.printf(test + " is %s\n", (isPalindrome(testlast)) ? "a palindrome" : "not a palindrome");
		}

	}
}
