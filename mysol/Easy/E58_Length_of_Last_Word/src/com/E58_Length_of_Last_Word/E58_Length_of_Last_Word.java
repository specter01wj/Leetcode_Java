package com.E58_Length_of_Last_Word;

import java.util.*;

/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
*/

public class E58_Length_of_Last_Word {

	public static void main(String[] args) {
		String input = "Hello World";
        int output = lengthOfLastWord(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    
    */
	
	/*
     * @param s: a string
     * @return length: find a length integer
     */
	public static int lengthOfLastWord(String s) {
		int length = 0;
		char[] chars = s.toCharArray();
		
		for(int i = s.length() - 1; i >= 0; i--) {
			if(length == 0) {
				if(chars[i] == ' ') {
					continue;
				} else {
					length++;
				}
			} else {
				if(chars[i] == ' ') {
					break;
				} else {
					length++;
				}
			}
		}
		
		return length;
	}

}
