package com.findWordsThatCanBeFormedbyCharacters;
import java.util.*;

/*
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars 
(each character can only be used once).

Return the sum of lengths of all good strings in words.


Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" 
so the answer is 3 + 3 = 6.

Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" 
so the answer is 5 + 5 = 10.
*/

public class E1160_Find_Words_That_Can_Be_Formed_by_Characters {

	public static void main(String[] args) {
		String[] input = {"cat","bt","hat","tree"};
		String chars = "atach";
        int output = countCharacters(input, chars);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Count the characters in chars in array charsArr, 
    then for each word in words check if charsArr has enough to cover it.
    */
	
	/**
     * @param words: a string array
     * @param chars: a string
     * @return: the sum of lengths of all good strings in words
     */
	public static int countCharacters(String[] words, String chars) {
        int resCount = 0;
        int[] charsArr = new int[26];
        for (char c : chars.toCharArray()) {
            charsArr[c - 'a']++;
        }
        for (String word : words) {
            int[] wordArr = Arrays.copyOf(charsArr, charsArr.length); 
            int count = 0;
            for (char c : word.toCharArray()) {
                if (wordArr[c - 'a'] > 0) {
                    wordArr[c - 'a']--;
                    count++;
                }
            }
            if (count == word.length()) {
                resCount += count;
            }
        }
        return resCount;
    }

}
