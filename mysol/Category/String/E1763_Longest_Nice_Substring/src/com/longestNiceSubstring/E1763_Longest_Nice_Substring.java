package com.longestNiceSubstring;
import java.util.*;

/*
A string s is nice if, for every letter of the alphabet that s contains, 
it appears both in uppercase and lowercase. 
For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. 
However, "abA" is not because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice. 
If there are multiple, return the substring of the earliest occurrence. 
If there are none, return an empty string.


Example 1:

Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of 
the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.

Example 2:

Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. 
The whole string is a substring.

Example 3:

Input: s = "c"
Output: ""
Explanation: There are no nice substrings.
*/

public class E1763_Longest_Nice_Substring {

	public static void main(String[] args) {
		String input = "YazaAay";
        String output = longestNiceSubstring(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Brute-force
	We just make an assumption that if we invert case of chars in a nice string 
	then we will have at least one char in the inverted string for each char in 
	the original string. 
	For example, aA -> inverting case -> Aa - each char from original string 
	is present in inverted string but in different order. That what we do in the code.
    */
	
	/**
     * @param s: a string
     * @return: the longest substring of s that is nice
     */
	public static String longestNiceSubstring(String s) {
        if (s.length() < 2) {
        	return "";
        }
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c: arr) {
        	set.add(c);
        }
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) {
            	continue;
            }
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i+1));
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s;
    }

}
