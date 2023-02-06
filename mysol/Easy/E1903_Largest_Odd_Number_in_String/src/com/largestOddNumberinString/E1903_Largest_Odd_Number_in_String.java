package com.largestOddNumberinString;
import java.util.*;

/*
You are given a string num, representing a large integer. Return the largest-valued 
odd integer (as a string) that is a non-empty substring of num, or an empty 
string "" if no odd integer exists.

A substring is a contiguous sequence of characters within a string.


Example 1:

Input: num = "52"
Output: "5"
Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.

Example 2:

Input: num = "4206"
Output: ""
Explanation: There are no odd numbers in "4206".

Example 3:

Input: num = "35427"
Output: "35427"
Explanation: "35427" is already an odd number.
*/

public class E1903_Largest_Odd_Number_in_String {

	public static void main(String[] args) {
		String input = "35436";
		String output = largestOddNumber(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    if remainder not 0 then get substring
    */
	
	/**
     * @param num: a string
     * @return: the largest-valued odd integer that is a non-empty substring of num, 
     * or an empty string "" if no odd integer exists
     */
	public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

}
