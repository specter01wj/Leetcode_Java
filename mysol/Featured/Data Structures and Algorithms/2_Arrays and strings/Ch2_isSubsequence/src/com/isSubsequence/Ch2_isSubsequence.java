package com.isSubsequence;
import java.util.*;

/*
Example 4: 392. Is Subsequence.

Given two strings s and t, return true if s is a subsequence of t, 
or false otherwise.

A subsequence of a string is a sequence of characters that can be 
obtained by deleting some (or none) of the characters from the 
original string, while maintaining the relative order of the 
remaining characters. For example, "ace" is a subsequence 
of "abcde" while "aec" is not.
*/

public class Ch2_isSubsequence {

	public static void main(String[] args) {
		Ch2_isSubsequence solution = new Ch2_isSubsequence();
		String input = "ace", t = "abcde";
		boolean output = solution.isSubsequence(input, t);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    two pointers
    */
	
	/*
     * @param s: a string
     * @param t: a string
     * @return: boolean
     */
	public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == s.length();
    }

}
