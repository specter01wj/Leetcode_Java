package com.checkifOneStringSwapCanMakeStringsEqual;
import java.util.*;

/*
You are given two strings s1 and s2 of equal length. A string swap 
is an operation where you choose two indices in a string 
(not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing 
at most one string swap on exactly one of the strings. Otherwise, return false.


Example 1:

Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".

Example 2:

Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.

Example 3:

Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.
*/

public class E1790_Check_if_One_String_Swap_Can_Make_Strings_Equal {

	public static void main(String[] args) {
		String input = "bank", string2 = "kanb";
        boolean output = areAlmostEqual(input, string2);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. the count of diff characters between the 2 strings must be 0 or 2
	2. the diff characters must be the same
    */
	
	/**
     * @param s1: a string
     * @param s2: a string
     * @return: true if it is possible to make both strings equal by performing 
     * at most one string swap on exactly one of the strings
     */
	public static boolean areAlmostEqual(String s1, String s2) {
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
        int counter = 0;
        for(int i = 0;i < s1.length();i++){
            char s = s1.charAt(i);
            char ss = s2.charAt(i);
            if(s != ss) {
                counter++;
            }
            if(counter > 2) {
                return false;
            }
            s1Array[s -'a']++;
            s2Array[ss -'a']++;
        }
        return Arrays.equals(s1Array, s2Array);
    }

}
