package com.substringsofSizeThreewithDistinctCharacters;
import java.util.*;

/*
A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, 
every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.


Example 1:

Input: s = "xyzzaz"
Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".

Example 2:

Input: s = "aababcabc"
Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".
*/

public class E1876_Substrings_of_Size_Three_with_Distinct_Characters {

	public static void main(String[] args) {
		String input = "aababcabc";
        int output = countGoodSubstrings(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Sliding Window
    */
	
	/**
     * @param s: a string
     * @return: the number of good substrings of length three in s
     */
	public static int countGoodSubstrings(String s) {
        int result = 0;
        for (int i = 1;i < s.length() - 1;i++) {
            if (s.charAt(i-1) != s.charAt(i) && s.charAt(i+1) != s.charAt(i) && s.charAt(i+1) != s.charAt(i-1)) {
                result++;
            }
        }
        return result;
    }

}
