package com.E205_Isomorphic_Strings;

import java.util.*;

/*Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character 
while preserving the order of characters. No two characters may map to 
the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true*/

public class E205_Isomorphic_Strings {

	public static void main(String[] args) {
		String input1 = "paper", input2 = "title";
        boolean output = isIsomorphic(input1, input2);
        System.out.println("input1: " + (input1) + " / input2: " + (input2) + "\noutput: " + (output));
	}
	
	/*
    solution:
    开一个map尽量将s的字符替换为t对应的字符，再开一个map尽量将t的字符替换为s,
    如果两个都能成功，那么就能满足题目条件。
    */
	
	/*
     * @param s: a string
     * @param t: a string
     * @return: true if the characters in s can be replaced to get t or false
     */
	public static boolean isIsomorphic(String s, String t) {
		int[] map = new int[256]; // ASCII 的范围是0-255
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		
		for(int i = 0; i < s.length(); i++) {
			if(map[sc[i]] == 0) {
				map[sc[i]] = tc[i];
			} else {
				if(map[sc[i]] != tc[i]) {
					return false;
				}
			}
		}
		
		int[] map2 = new int[256];
        for (int i = 0; i < t.length(); i++) {
            if (map2[tc[i]] == 0) {
                map2[tc[i]] = sc[i];
            } else {
                if (map2[tc[i]] != sc[i]) {
                    return false;
                }
            }
        }
        
        return true;
	}

}
