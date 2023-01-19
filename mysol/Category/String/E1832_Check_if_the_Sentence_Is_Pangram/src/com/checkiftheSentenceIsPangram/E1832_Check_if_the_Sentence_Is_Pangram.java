package com.checkiftheSentenceIsPangram;
import java.util.*;

/*
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence 
is a pangram, or false otherwise.


Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.

Example 2:

Input: sentence = "leetcode"
Output: false
*/

public class E1832_Check_if_the_Sentence_Is_Pangram {

	public static void main(String[] args) {
		String input = "thequickbrownfoxjumpsoverthelazydog";
        boolean output = checkIfPangram(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Put all characters in a set,
	return if the size of set equals to 26.
    */
	
	/**
     * @param sentence: a string
     * @return: true if sentence is a pangram, or false otherwise
     */
	public static boolean checkIfPangram(String sentence) {
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < sentence.length(); ++i) {
            s.add(sentence.charAt(i));
        }
        return s.size() == 26;
    }

}
