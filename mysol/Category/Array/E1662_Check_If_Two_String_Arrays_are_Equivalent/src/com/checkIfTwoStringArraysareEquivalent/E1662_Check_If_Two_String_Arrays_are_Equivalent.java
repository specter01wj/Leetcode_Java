package com.checkIfTwoStringArraysareEquivalent;
import java.util.*;

/*
Given two string arrays word1 and word2, return true if the two arrays 
represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated 
in order forms the string.


Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.

Example 2:

Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false

Example 3:

Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true
*/

public class E1662_Check_If_Two_String_Arrays_are_Equivalent {

	public static void main(String[] args) {
		String[] input = {"abc", "d", "defg"}, input2 = {"abcddefg"};
		boolean output = arrayStringsAreEqual(input, input2);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    join and compare
    */
	
	/*
     * @param word1: a list of strings
     * @param word2: a list of strings
     * @return: true if the two arrays represent the same string, and false otherwise
     */
	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return(String.join("", word1).equals(String.join("", word2)));
    }

}
