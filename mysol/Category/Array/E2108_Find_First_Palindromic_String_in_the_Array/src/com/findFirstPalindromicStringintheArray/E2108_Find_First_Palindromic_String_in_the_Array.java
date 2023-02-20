package com.findFirstPalindromicStringintheArray;
import java.util.*;

/*
Given an array of strings words, return the first palindromic string in the array. 
If there is no such string, return an empty string "".

A string is palindromic if it reads the same forward and backward.


Example 1:

Input: words = ["abc","car","ada","racecar","cool"]
Output: "ada"
Explanation: The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.

Example 2:

Input: words = ["notapalindrome","racecar"]
Output: "racecar"
Explanation: The first and only string that is palindromic is "racecar".

Example 3:

Input: words = ["def","ghi"]
Output: ""
Explanation: There are no palindromic strings, so the empty string is returned.
*/

public class E2108_Find_First_Palindromic_String_in_the_Array {

	public static void main(String[] args) {
		String[] input = {"abc","car","ada","racecar","cool"};
		String output = firstPalindrome(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    reverse and compare
    */
	
	/*
     * @param words: a list of strings
     * @return: the first palindromic string in the array
     */
	public static String firstPalindrome(String[] words) {
        StringBuffer sb = null;
        for (String s : words) {
            sb = new StringBuffer(s);
            if (sb.reverse().toString().equals(s)) {
                return s;
            }
        }
        return "";
    }

}
