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
    The points of interest are the peaks and valleys in the given graph. 
    We need to find the largest peak following the smallest valley. 
    We can maintain two variables - minprice and maxprofit corresponding 
    to the smallest valley and maximum profit (maximum difference between 
    selling price and minprice) obtained so far respectively.
    */
	
	/*
     * @param prices: a list of integers
     * @return: find a maximum profit
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
