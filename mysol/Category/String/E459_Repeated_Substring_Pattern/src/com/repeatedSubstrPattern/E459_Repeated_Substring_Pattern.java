package com.repeatedSubstrPattern;

import java.util.*;

/*Given a non-empty string check if it can be constructed by taking a substring 
 of it and appending multiple copies of the substring together. 
 You may assume the given string consists of lowercase English letters only 
 and its length will not exceed 10000.



Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/
public class E459_Repeated_Substring_Pattern {

	public static void main(String[] args) {
		String input = "abab";//"abcabcabcabc"
        boolean output = repeatedSubstringPattern(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    KMP算法对于next数组的应用。 next[i]是指对于字符串s[0,i-1]中，前缀与后缀的最大匹配长度。 
    例如对于"abcabcabc"来说，其next[8] = 5，也即对于s[0,7]="abcabcab"，
    前缀与后缀最大匹配的串为"abcab"，长度为5。 
    用字符串长度减1减去最后一位的next数组值之后得到的应为重复串的长度。
    */
	
	/*
     * @param s: a string，denote matching string
     * @return: an boolean，denote whether it is repeated pattern string
     */
	public static boolean repeatedSubstringPattern(String s) {
		int l = s.length();
		int[] next = new int[l];
		next[0] = -1;
		int j = -1;
		
		for(int i = 1; i < l; i++) {
			while(j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
				j = next[j];
			}
			if(s.charAt(i) == s.charAt(j + 1)) {
				j++;
			}
			next[i] = j;
		}
		int lenSub = l - 1 - next[l - 1];
		
		return lenSub != l && l % lenSub == 0;
	}

}
