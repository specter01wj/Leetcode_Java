package com.mergeStringsAlternately;
import java.util.*;

/*
You are given two strings word1 and word2. Merge the strings by adding 
letters in alternating order, starting with word1. 
If a string is longer than the other, append the additional letters 
onto the end of the merged string.

Return the merged string.


Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s

Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d
*/

public class E1768_Merge_Strings_Alternately {

	public static void main(String[] args) {
		String word1 = "ab", word2 = "pqr";
        String output = mergeAlternately(word1, word2);
        System.out.println("word1: " + (word1) + " word2: " + (word2) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Alternatively append the character from w1 and w2 to res.
    */
	
	/**
     * @param word1: a string
     * @param word2: a string
     * @return: the merged string
     */
	public static String mergeAlternately(String word1, String word2) {
        int n = word1.length(), m = word2.length(), i = 0, j = 0;
        StringBuilder res = new StringBuilder();
        while (i < n || j < m) {
            if (i < word1.length()) {
                res.append(word1.charAt(i++));
            }
            if (j < word2.length()) {
                res.append(word2.charAt(j++));
            }
        }
        return res.toString();
    }

}
