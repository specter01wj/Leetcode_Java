package com.getEqualSubstringsWithinBudget;
import java.util.*;

/*
You are given two strings s and t of the same length and an integer maxCost.

You want to change s to t. Changing the ith character of s to ith character 
of t costs |s[i] - t[i]| (i.e., the absolute difference between the ASCII 
values of the characters).

Return the maximum length of a substring of s that can be changed to be 
the same as the corresponding substring of t with a cost less than or 
equal to maxCost. 
If there is no substring from s that can be changed to its corresponding 
substring from t, return 0.
*/

public class M1208_Get_Equal_Substrings_Within_Budget {

	public static void main(String[] args) {
		M1208_Get_Equal_Substrings_Within_Budget solution = new M1208_Get_Equal_Substrings_Within_Budget();
		String s = "abcd", t = "bcdf";
		int maxCost = 3;
		int output = solution.equalSubstring(s, t, maxCost);
        System.out.println("input s: " + (s) + "; input t: " + (t) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Sliding window
    */
	
	/*
     * @param s: a string
     * @param t: a string
     * @param maxCost: an integer
     * @return: the maximum length of a substring of s
     */
	public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, cost = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            cost += Math.abs(s.charAt(right) - t.charAt(right));

            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}
