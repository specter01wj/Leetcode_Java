package com.shuffleString;
import java.util.*;

/*
You are given a string s and an integer array indices of the same length. 
The string s will be shuffled such that the character at the ith position 
moves to indices[i] in the shuffled string.

Return the shuffled string.


Example 1:


Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
Output: "leetcode"
Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.

Example 2:

Input: s = "abc", indices = [0,1,2]
Output: "abc"
Explanation: After shuffling, each character remains in its position.
*/

public class E1528_Shuffle_String {

	public static void main(String[] args) {
		String input = "codeleet";
		int[] indices = {4,5,6,7,0,2,1,3};
        String output = restoreString(input, indices);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static String restoreString(String s, int[] indices) {
        StringBuilder s1 = new StringBuilder(s); 
        StringBuilder s2 = new StringBuilder(s); 
        int n = indices.length;
        for ( int i = 0; i <n; i++ ) {
            int in = indices[i];
            s2.setCharAt(in, s1.charAt(i)); 
            
        }
        return s2.toString();
    }

}
