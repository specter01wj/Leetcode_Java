package com.sortingtheSentence;
import java.util.*;

/*
A sentence is a list of words that are separated by a single space with no 
leading or trailing spaces. Each word consists of lowercase and uppercase English letters.

A sentence can be shuffled by appending the 1-indexed word position to each 
word then rearranging the words in the sentence.

	.For example, the sentence "This is a sentence" can be shuffled as 
	"sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
	
Given a shuffled sentence s containing no more than 9 words, reconstruct and 
return the original sentence.


Example 1:

Input: s = "is2 sentence4 This1 a3"
Output: "This is a sentence"
Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", 
then remove the numbers.

Example 2:

Input: s = "Myself2 Me1 I4 and3"
Output: "Me Myself and I"
Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", 
then remove the numbers.
*/

public class E1859_Sorting_the_Sentence {

	public static void main(String[] args) {
		String input = "is2 sentence4 This1 a3";
        String output = sortSentence(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    String split and join
    */
	
	/**
     * @param s: a string
     * @return: the original sentence
     */
	public static String sortSentence(String s) {
        String[] words = s.split(" "), ans = new String[words.length];
        for (String word : words) {
            int i = word.length() - 1;
            ans[word.charAt(i) - '1'] = word.substring(0, i);
        }
        return String.join(" ", ans);
    }

}
