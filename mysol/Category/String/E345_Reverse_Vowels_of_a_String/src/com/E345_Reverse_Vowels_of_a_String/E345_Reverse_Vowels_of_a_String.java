package com.E345_Reverse_Vowels_of_a_String;

import java.util.*;

/*Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
*/

public class E345_Reverse_Vowels_of_a_String {

	public static void main(String[] args) {
		String input = "hello";
        String output = reverseVowels(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    双指针解法，头尾两个指针相向而行，遇到元音字符则交换。
    */
	
	/*
     * @param s: a String
     * @return chars: reversed vowels of a string
     */
	public static String reverseVowels(String s) {
		if(s == null || s.length()==0) {
			return s;
		}
		String vowels = "aeiouAEIOU";
		// 将字符串转化成char类型数组
		char[] chars = s.toCharArray();
		int start = 0, end = s.length() - 1;
		
		while(start < end) {
			// 双指针相向而行找元音字符
			while(start < end && !vowels.contains(chars[start] + "")) {
				start++;
			}
			while(start < end && !vowels.contains(chars[end] + "")) {
				end--;
			}
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
		
		return new String(chars);
	}

}
