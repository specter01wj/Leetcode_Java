package com.findLongestSubstring;
import java.util.*;

/*
Example 1: You are given a string s and an integer k. 
Find the length of the longest substring that contains 
at most k distinct characters.

For example, given s = "eceba" and k = 2, return 3. 
The longest substring with at most 2 distinct characters is "ece".
*/

public class Ch3_findLongestSubstring {

	public static void main(String[] args) {
		Ch3_findLongestSubstring solution = new Ch3_findLongestSubstring();
		String input = "eceba";
		int k = 2;
		int output = solution.findLongestSubstring(input, k);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param s: a string
     * @param k: an integer
     * @return: the length of the longest substring
     */
	public int findLongestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // Shrink window if more than k distinct characters
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}
