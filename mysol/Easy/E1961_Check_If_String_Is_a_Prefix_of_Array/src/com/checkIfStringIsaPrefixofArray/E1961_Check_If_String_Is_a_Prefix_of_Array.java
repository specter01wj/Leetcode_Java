package com.checkIfStringIsaPrefixofArray;
import java.util.*;

/*
Given a string s and an array of strings words, determine whether s is a prefix string of words.

A string s is a prefix string of words if s can be made by concatenating the first k strings 
in words for some positive k no larger than words.length.

Return true if s is a prefix string of words, or false otherwise.


Example 1:

Input: s = "iloveleetcode", words = ["i","love","leetcode","apples"]
Output: true
Explanation:
s can be made by concatenating "i", "love", and "leetcode" together.

Example 2:

Input: s = "iloveleetcode", words = ["apples","i","love","leetcode"]
Output: false
Explanation:
It is impossible to make s using a prefix of arr.
*/

public class E1961_Check_If_String_Is_a_Prefix_of_Array {

	public static void main(String[] args) {
		String input = "iloveleetcode";
		String[] words = {"i","love","leetcode","apples"};
		boolean output = isPrefixString(input, words);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Keep appending the strings in the array 1-by-1.
	2. If the appended string matches the given string, return true.
	3. If the given string does not contain the appended string, return false.
	4. If the loop terminates, return false.
    */
	
	/*
     * @param s: a string
     * @param words: a list of strings
     * @return: true if s is a prefix string of words, or false otherwise
     */
	public static boolean isPrefixString(String s, String[] words) {
        StringBuilder res = new StringBuilder ("");
        for (String word : words) {
            res.append(word);
            if (s.equals(res.toString())) {
                return true;
            }
            if (s.indexOf(res.toString()) == -1) {
                return false;
            }
        }
        return false;
    }

}
