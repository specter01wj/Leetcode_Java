package com.replaceAlltoAvoidConsecutiveRepeatingCharacters;
import java.util.*;

/*
Given a string s containing only lowercase English letters and the '?' character, 
convert all the '?' characters into lowercase letters such that the final string 
does not contain any consecutive repeating characters. 
You cannot modify the non '?' characters.

It is guaranteed that there are no consecutive repeating characters in the given 
string except for '?'.

Return the final string after all the conversions (possibly zero) have been made. 
If there is more than one solution, return any of them. It can be shown that an 
answer is always possible with the given constraints.


Example 1:

Input: s = "?zs"
Output: "azs"
Explanation: There are 25 solutions for this problem. From "azs" to "yzs", 
all are valid. Only "z" is an invalid modification as the string will 
consist of consecutive repeating characters in "zzs".

Example 2:

Input: s = "ubv?w"
Output: "ubvaw"
Explanation: There are 24 solutions for this problem. Only "v" and "w" 
are invalid modifications as the strings will consist of consecutive 
repeating characters in "ubvvw" and "ubvww".
*/

public class E1576_Replace_All_to_Avoid_Consecutive_Repeating_Characters {

	public static void main(String[] args) {
		String input = "ubv?w";
        String output = modifyString(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static String modifyString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                for (int j = 0; j < 3; j++) {
                    if (i > 0 && arr[i - 1] - 'a' == j) continue;
                    if (i + 1 < arr.length && arr[i + 1] - 'a' == j) continue;
                    arr[i] = (char) ('a' + j);
                    break;
                }
            }
        }
        return String.valueOf(arr);
    }

}
