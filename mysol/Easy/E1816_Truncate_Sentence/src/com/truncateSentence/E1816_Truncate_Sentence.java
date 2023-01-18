package com.truncateSentence;
import java.util.*;

/*
A sentence is a list of words that are separated by a single space with no leading 
or trailing spaces. Each of the words consists of only uppercase and lowercase 
English letters (no punctuation).

	.For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.

You are given a sentence s​​​​​​ and an integer k​​​​​​. You want to truncate s​​​​​​ such that it contains only the first k​​​​​​ words. Return s​​​​​​ after truncating it.


Example 1:

Input: s = "Hello how are you Contestant", k = 4
Output: "Hello how are you"
Explanation:
The words in s are ["Hello", "how" "are", "you", "Contestant"].
The first 4 words are ["Hello", "how", "are", "you"].
Hence, you should return "Hello how are you".

Example 2:

Input: s = "What is the solution to this problem", k = 4
Output: "What is the solution"
Explanation:
The words in s are ["What", "is" "the", "solution", "to", "this", "problem"].
The first 4 words are ["What", "is", "the", "solution"].
Hence, you should return "What is the solution".

Example 3:

Input: s = "chopper is not a tanuki", k = 5
Output: "chopper is not a tanuki"
*/

public class E1816_Truncate_Sentence {

	public static void main(String[] args) {
		String input = "What is the solution to this problem";
		int k = 4;
        String output = truncateSentence(input, 4);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Split and join
    */
	
	/**
     * @param s: a string
     * @param k: an integer
     * @return: s​​​​​​ after truncating it
     */
	public static String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder(words[0]);
        for (int i = 1; i < k; ++i) {
            sb.append(" " + words[i]);
        }
        return sb.toString();
    }

}
