package com.checkifBinaryStringHasatMostOneSegmentofOnes;
import java.util.*;

/*
Given a binary string s ​​​​​without leading zeros, return true​​​ if s contains 
at most one contiguous segment of ones. Otherwise, return false.


Example 1:

Input: s = "1001"
Output: false
Explanation: The ones do not form a contiguous segment.

Example 2:

Input: s = "110"
Output: true
*/

public class E1784_Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones {

	public static void main(String[] args) {
		String input = "110";
        boolean output = checkOnesSegment(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    According to the description: "Given a binary string s without leading zeros,", 
    if we find a 0, there must be at least a 1 somewhere before it. 
    Therefore, if and only if we find a "01", there are at least 2 segments of 1's.
    */
	
	/**
     * @param s: a string
     * @return: true​​​ if s contains at most one contiguous segment of ones
     */
	public static boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

}
