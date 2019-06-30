package com.E344_Reverse_String;

import java.util.*;

/*Write a function that reverses a string. The input string is given as 
 * an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying 
the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/

public class E344_Reverse_String {

	public static void main(String[] args) {
		char[] input = {'h','e','l','l','o'};
        char[] output = reverseString(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    
    */
	
	/*
     * @param s: an array char
     * @return str: reversed array char
     */
	public static char[] reverseString(char[] s) {
        char[] str = new char[s.length];
        
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        str = s;
        
        return str;
    }

}
