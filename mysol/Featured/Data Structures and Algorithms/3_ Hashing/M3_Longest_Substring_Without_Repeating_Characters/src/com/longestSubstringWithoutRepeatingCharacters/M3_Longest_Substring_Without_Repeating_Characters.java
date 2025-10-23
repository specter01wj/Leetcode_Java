package com.longestSubstringWithoutRepeatingCharacters;
import java.util.*;

/*
Given a string s, find the length of the longest substring without duplicate characters.
*/

public class M3_Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		M3_Longest_Substring_Without_Repeating_Characters solution = new M3_Longest_Substring_Without_Repeating_Characters();
		String input = "abcabcbb";
		int output = solution.lengthOfLongestSubstring(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

}
