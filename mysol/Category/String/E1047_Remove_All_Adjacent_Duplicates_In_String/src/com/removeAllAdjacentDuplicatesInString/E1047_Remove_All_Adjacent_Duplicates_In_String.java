package com.removeAllAdjacentDuplicatesInString;
import java.util.*;

/*
You are given a string s consisting of lowercase English letters. 
A duplicate removal consists of choosing two adjacent and equal 
letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. 
It can be proven that the answer is unique.


Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are 
adjacent and equal, and this is the only possible move.  
The result of this move is that the string is "aaca", 
of which only "aa" is possible, so the final string is "ca".

Example 2:

Input: s = "azxxzy"
Output: "ay"
*/

public class E1047_Remove_All_Adjacent_Duplicates_In_String {

	public static void main(String[] args) {
		String input = "abbaca";
        String output = removeDuplicates(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static String removeDuplicates(String s) {
		int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) {
                i -= 2;
            }
        }
        return new String(res, 0, i);
	}

}
