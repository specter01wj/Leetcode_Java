package com.E290_Word_Pattern;

import java.util.*;

/*Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a 
letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains 
lowercase letters that may be separated by a single space.*/

public class E290_Word_Pattern {

	public static void main(String[] args) {
		String input = "dog cat cat dog";
		String pattern = "abba";
        boolean output = wordPattern(pattern, input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    用HashMap联立str中的单词和pattern中的字母，如果后面出现str中的单词与pattern中的字母对不上，
    则输出false，否则输出true
    */
	
	/*
     * @param pattern: a string，denote pattern string
     * @param str: a string，denote matching string
     * @return: an boolean，denote whether the pattern string and 
     * the matching string match or not
     */
	public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
        		return false;
        }
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; ++i) {
        		/*int t1 = pattern.charAt(i);
        		Object t2 = index.put(pattern.charAt(i), i);
        		String r1 = words[i];
        		Object r2 = index.put(words[i], i);*/
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) {
                return false;
            }
        }
        
        return true;
    }

}
