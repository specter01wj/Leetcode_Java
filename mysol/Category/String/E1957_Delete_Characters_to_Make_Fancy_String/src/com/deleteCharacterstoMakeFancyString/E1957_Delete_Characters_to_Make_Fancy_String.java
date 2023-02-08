package com.deleteCharacterstoMakeFancyString;
import java.util.*;

/*
A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.


Example 1:

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".

Example 2:

Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".

Example 3:

Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".
*/

public class E1957_Delete_Characters_to_Make_Fancy_String {

	public static void main(String[] args) {
		String input = "aaabaaaa";
        String output = makeFancyString(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Count consecutive same characters, if less than 3, put into StringBuilder/List; 
    Otherwise, ignore it.
    */
	
	/**
     * @param s: a string
     * @return: the final string after the deletion. It can be shown that the answer 
     * will always be unique
     */
	public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, cnt = 0; i < s.length(); ++i) {
            if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
                ++cnt;
            } else {
                cnt = 1;
            }
            if (cnt < 3) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
