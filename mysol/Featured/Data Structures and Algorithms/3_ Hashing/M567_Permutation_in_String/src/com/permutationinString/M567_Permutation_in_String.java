package com.permutationinString;
import java.util.*;

/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.
*/

public class M567_Permutation_in_String {

	public static void main(String[] args) {
		M567_Permutation_in_String solution = new M567_Permutation_in_String();
		String input = "ab", s2 = "eidbaooo";
		boolean output = solution.checkInclusion(input, s2);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // Build frequency map for s1
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        while (right < s2.length()) {
            char currentChar = s2.charAt(right);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);
            right++;

            // If window size is larger than s1, shrink from left
            if (right - left > s1.length()) {
                char leftChar = s2.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }
                left++;
            }

            // Compare window and s1 maps
            if (s1Map.equals(windowMap)) return true;
        }

        return false;
    }

}
