package com.checkIfPalindrome;
import java.util.*;

/*
Example 1: Given a string s, return true if it is a palindrome, false otherwise.

A string is a palindrome if it reads the same forward as backward. 
That means, after reversing it, it is still the same string. 
For example: "abcdcba", or "racecar".
*/

public class Ch2_checkIfPalindrome {

	public static void main(String[] args) {
		Ch2_checkIfPalindrome solution = new Ch2_checkIfPalindrome();
		String input = "racecar";
		boolean output = solution.checkIfPalindrome(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    two pointers
    */
	
	/*
     * @param s: a string
     * @return: boolean
     */
	public boolean checkIfPalindrome(String s) {
	    int left = 0;
	    int right = s.length() - 1;

	    while (left < right) {
	        if (s.charAt(left) != s.charAt(right)) {
	            return false;
	        }

	        left++;
	        right--;
	    }

	    return true;
	}

}
