package com.counttheNumberofConsistentStrings;
import java.util.*;

/*
You are given a string allowed consisting of distinct characters 
and an array of strings words. A string is consistent if all 
characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.


Example 1:

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.

Example 2:

Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.

Example 3:

Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
*/

public class E1684_Count_the_Number_of_Consistent_Strings {

	public static void main(String[] args) {
		String allowed = "ab";
		String[] input = {"ad","bd","aaab","baa","badab"};
		int output = countConsistentStrings(allowed, input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    map and count
    */
	
	/*
     * @param allowed: a string
     * @param words: a list of strings
     * @return: the number of consistent strings in the array words
     */
	public static int countConsistentStrings(String allowed, String[] words) {
        int count = words.length;
        int[] store = new int[26];

        for (char c : allowed.toCharArray()){
            store[c - 'a']++;
        }

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (store[c - 'a'] <= 0){
                    count--;
                    break;
                }
            }
        }
        return count;
    }

}
