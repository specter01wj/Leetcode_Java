import java.util.*;

/*Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21*/

public class E7_Reverse_Integer {

	public static void main(String[] args) {
		int input = 321;
        int output = reverseInteger(input);
        System.out.println("input: " + (input) + "\noutput: " + (output) );
	}
	
	
	/**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
	public static int reverseInteger(int n) {
		int reversed_n = 0;
		
		while(n != 0) {
			int temp = reversed_n * 10 + n % 10;
			n /= 10;
			if(temp / 10 != reversed_n) {
				reversed_n = 0;
				break;
			}
			reversed_n = temp;
		}
		
		return reversed_n;
	}

}
