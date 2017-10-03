import java.util.*;

/**
 * Some utility methods for arrays.
 * @author your name
 */

public class ArrayUtil {
	static Scanner  a = new Scanner(System.in);
	/**
	 * Prompt the user to input strings at the console
	 * and return them as an array of String.
	 * @return array of strings input by the user
	 */
	public static String[] readArray() {
		System.out.print("How many strings to input? ");
		int n = a.nextInt();
		System.out.println("Input 5 strings separated by space or newline: ");
		String[] arr = new String[n];
		for(int i=0;i<n;i++){
			 arr[i] = a.next();
		}
		
		return arr;
	}
	
	/**
	 * Print an array of any kind of objects on the console,
	 * one element per line.
	 * @param array is the array to print
	 */
	public static void printArray(Object[] array) {
		for(int i= 0;i< array.length;i++){
			System.out.println(array[i]);
		}
	}
	
	/**
	 * Write your own Javadoc comment.
	 * What does this method do? What are the parameters?
	 */
	public static void printUnique(Object[] array) {
		boolean check = true;
		if(array.length==0){
			return;
		}else{
			
			for(int i=0;i<array.length;i++){
				for(int j=0;j < i;j++){
					if(array[i].equals(array[j])){
						check = false;
						break;
						
					}else{
						check = true;
						continue;
					}
				}
				if(check == true){
				System.out.println(array[i]);	
				}
			}
		}
		
	}
	
	/**
	 * Reverse the order of elements in an array.
	 * @param array the array to reverse
	 */
	public static void reverse(Object[] array) {
		for(int i = array.length-1;i>=0;i--){
			System.out.println(array[i]);
		}
	}

	
	public static void main(String[] args) {
		String[] words = readArray();
		System.out.println("\nYou input:");
		printArray(words);
		System.out.println("\nUnique words in array:");
		printUnique(words);
		System.out.println("\nThe reversed array:");
		reverse(words);
		printArray(words);
	}
}
