package com.reverseStringII;
import java.util.*;

/*Given a string s and an integer k, reverse the first k characters 
for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. 
If there are less than 2k but greater than or equal to k characters, 
then reverse the first k characters and left the other as original.

 

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"

Example 2:

Input: s = "abcd", k = 2
Output: "bacd"*/

public class E541_Reverse_String_II {

	public static void main(String[] args) {
		String input = "abcdefg";
        String output = reverseStr(input, 2);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	public static String reverseStr(String s, int k) {
		String ans = new String("");
		int l = s.length(), i , j;
		
		for(i = 0; i < l; i += 2 * k) {
			for(j = Math.min(l - 1, i + k - 1); j >= i; j--) {
				ans = ans + s.charAt(j);
			}
			for(j = i + k;j < Math.min(i + 2 * k, l); j++) {
				ans = ans + s.charAt(j);
			}
		}
		
		return ans;
	}

}
