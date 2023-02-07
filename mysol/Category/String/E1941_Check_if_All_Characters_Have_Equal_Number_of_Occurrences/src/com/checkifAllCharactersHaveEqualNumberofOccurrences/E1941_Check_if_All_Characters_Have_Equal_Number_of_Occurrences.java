package com.checkifAllCharactersHaveEqualNumberofOccurrences;
import java.util.*;

/*
Given a string s, return true if s is a good string, or false otherwise.

A string s is good if all the characters that appear in s have the same number 
of occurrences (i.e., the same frequency).


Example 1:

Input: s = "abacbc"
Output: true
Explanation: The characters that appear in s are 'a', 'b', and 'c'. 
All characters occur 2 times in s.

Example 2:

Input: s = "aaabb"
Output: false
Explanation: The characters that appear in s are 'a' and 'b'.
'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.
*/

public class E1941_Check_if_All_Characters_Have_Equal_Number_of_Occurrences {

	public static void main(String[] args) {
		String input = "abacbc";
        boolean output = areOccurrencesEqual(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    count the frequency of the letters in the string and then check all the 
    frequencies if they are the same.
    */
	
	/**
     * @param s: a string
     * @return: true if s is a good string, or false otherwise
     */
	public static boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int occur = freq[s.charAt(0) - 'a'];
        for (int num : freq) {
            if (num != 0 && num != occur) {
                return false;
            }
        }
        return true;
    }

}
