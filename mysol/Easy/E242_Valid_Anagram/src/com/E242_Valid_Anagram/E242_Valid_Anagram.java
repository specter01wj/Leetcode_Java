package com.E242_Valid_Anagram;

import java.util.*;

/*Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.*/

public class E242_Valid_Anagram {

	public static void main(String[] args) {
		String input1 = "anagram", input2 = "nagaram";
        boolean output = isAnagram(input1, input2);
        System.out.println("input1: " + (input1) + " / input2: " + (input2) + "\noutput: " + (output));
	}
	
	/*
    solution:
    统计每个字母的数量，比较是否一致即可。
    */
	
	/**
     * @param s: The first string
     * @param t: The second string
     * @return true or false
     */
	public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for(int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}
