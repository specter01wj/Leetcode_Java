package com.secondLargestDigitinaString;
import java.util.*;

/*
Given an alphanumeric string s, return the second largest numerical 
digit that appears in s, or -1 if it does not exist.

An alphanumeric string is a string consisting of lowercase English letters and digits.


Example 1:

Input: s = "dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.

Example 2:

Input: s = "abc1111"
Output: -1
Explanation: The digits that appear in s are [1]. There is no second largest digit.
*/

public class E1796_Second_Largest_Digit_in_a_String {

	public static void main(String[] args) {
		String input = "(()())(())(()(()))";
        String output = removeOuterParentheses(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public int secondHighest(String s) {
        int first = -1, sec = -1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i); 
            if (Character.isDigit(c)) {
                int d = c - '0';
                if (first < d) {
                    sec = first;
                    first = d;
                } else if (sec < d && d < first) {
                    sec = d;
                }
            }
        }
        return sec;
    }

}
