package com.consecutiveCharacters;
import java.util.*;

/*
The power of the string is the maximum length of a non-empty 
substring that contains only one unique character.

Given a string s, return the power of s.


Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.

Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
*/

public class E1446_Consecutive_Characters {

	public static void main(String[] args) {
		String input = "abbcccddddeeeeedcba";
        int output = maxPower(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static int maxPower(String s) {
        int ans = 1;
        for (int i = 1, cnt = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                if (++cnt > ans) {
                    ans = cnt;
                }
            }else {
                cnt = 1;
            }
        }
        return ans;
    }

}
