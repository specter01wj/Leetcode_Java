package com.minimumChangesToMakeAlternatingBinaryString;
import java.util.*;

/*
You are given a string s consisting only of the characters '0' and '1'. 
In one operation, you can change any '0' to '1' or vice versa.

The string is called alternating if no two adjacent characters are equal. 
For example, the string "010" is alternating, while the string "0100" is not.

Return the minimum number of operations needed to make s alternating.


Example 1:

Input: s = "0100"
Output: 1
Explanation: If you change the last character to '1', s will be "0101", which is alternating.

Example 2:

Input: s = "10"
Output: 0
Explanation: s is already alternating.

Example 3:

Input: s = "1111"
Output: 2
Explanation: You need two operations to reach "0101" or "1010".
*/

public class E1758_Minimum_Changes_To_Make_Alternating_Binary_String {

	public static void main(String[] args) {
		String input = "0100";
        int output = minOperations(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static int minOperations(String s) {
        int res = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) - '0' != i % 2) {
                res++;
            }
        }
        return Math.min(res, n - res);
    }

}
