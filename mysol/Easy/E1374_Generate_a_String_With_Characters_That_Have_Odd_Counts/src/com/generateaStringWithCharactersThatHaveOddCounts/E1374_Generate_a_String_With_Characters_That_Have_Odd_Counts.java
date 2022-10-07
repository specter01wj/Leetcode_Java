package com.generateaStringWithCharactersThatHaveOddCounts;
import java.util.*;

/*
Given an integer n, return a string with n characters such that 
each character in such string occurs an odd number of times.

The returned string must contain only lowercase English letters. 
If there are multiples valid strings, return any of them.  


Example 1:

Input: n = 4
Output: "pppz"
Explanation: "pppz" is a valid string since the character 'p' occurs 
three times and the character 'z' occurs once. 
Note that there are many other valid strings such as "ohhh" and "love".

Example 2:

Input: n = 2
Output: "xy"
Explanation: "xy" is a valid string since the characters 'x' and 'y' 
occur once. 
Note that there are many other valid strings such as "ag" and "ur".

Example 3:

Input: n = 7
Output: "holasss"
*/

public class E1374_Generate_a_String_With_Characters_That_Have_Odd_Counts {

	public static void main(String[] args) {
		int input = 4;
        String output = generateTheString(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    If n is odd, we return "bbbb....b".
	If n is even, we return "baaa...a".
    */
	
	/**
     * @param n: an integer
     * @return: a string with n characters
     */
	public static String generateTheString(int n) {
		// need Java11
        //return "b" + "ab".substring(n % 2, 1 + n % 2).repeat(n - 1);
		char[] str = new char[n];
	    Arrays.fill(str, 'a');
	    if(n % 2 == 0) {
	        str[0] = 'b';
	    }
	    return new String(str);
    }

}
