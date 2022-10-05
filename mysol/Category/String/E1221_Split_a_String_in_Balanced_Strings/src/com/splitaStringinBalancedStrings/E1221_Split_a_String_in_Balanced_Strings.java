package com.splitaStringinBalancedStrings;
import java.util.*;

/*
Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

Given a balanced string s, split it into some number of substrings such that:

Each substring is balanced.
Return the maximum number of balanced strings you can obtain.


Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", 
	each substring contains same number of 'L' and 'R'.

Example 2:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", 
	each substring contains same number of 'L' and 'R'.
	Note that s cannot be split into "RL", "RR", "RL", "LR", "LL", 
	because the 2nd and 5th substrings are not balanced.

Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
*/

public class E1221_Split_a_String_in_Balanced_Strings {

	public static void main(String[] args) {
		String input = "RLRRLLRLRL";
        int output = balancedStringSplit(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Greedily split the string, and with the counting
	L: +1
	R: -1
	when the counter is reset to 0, we get one balanced string.
    */
	
	/**
     * @param s: a string
     * @return: the maximum number of balanced strings you can obtain
     */
	public static int balancedStringSplit(String s) {
		int res = 0, cnt = 0;
		for (int i = 0; i < s.length(); ++i) {
			cnt += s.charAt(i) == 'L' ? 1 : -1;
			if (cnt == 0) {
				++res;
			}
		}
		
		return res;
	}

}
