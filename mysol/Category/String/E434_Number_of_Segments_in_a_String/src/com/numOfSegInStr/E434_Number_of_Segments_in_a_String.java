package com.numOfSegInStr;

import java.util.*;

/*Count the number of segments in a string, where a segment is defined to be 
 a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5*/

public class E434_Number_of_Segments_in_a_String {

	public static void main(String[] args) {
		String input = "Hello, my name is John";
        int output = countSegments(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    遍历整个字符串 一个字符串段落的特征是： 
    当前位置的字符不为' '并且(前一个字符为' '或者当前位置是第0位）
    */
	
	/**
     * @param s: The first string
     * @param t: The second string
     * @return true or false
     */
	public static int countSegments(String s) {
		int res = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
		}
	}

}
