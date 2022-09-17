package com.rotateString;
import java.util.*;

/*
Given two strings s and goal, return true if and only if s can become 
goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the 
rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.


Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true

Example 2:

Input: s = "abcde", goal = "abced"
Output: false
*/

public class E796_Rotate_String {

	public static void main(String[] args) {
		String input1 = "abcde";
		String input2 = "cdeab";
        boolean output = rotateString(input1, input2);
        System.out.println("input1: " + (input1) + "; input2: " + input2 + "\noutput: " + (output));
	}
	
	/*
    solution:
    it is rotated if B can be found in (A + A).
    */
	
	/**
     * @param s: an array of char
     * @param goal: an array of char
     * @return: boolean if and only if s can become goal after some number of shifts on s
     */
	public static boolean rotateString(String s, String goal) {
		return (s.length() == goal.length()) && (s + s).contains(goal);
	}

}
