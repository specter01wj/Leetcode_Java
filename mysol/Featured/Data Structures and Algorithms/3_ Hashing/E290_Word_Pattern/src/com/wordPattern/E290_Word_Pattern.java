package com.wordPattern;
import java.util.*;

/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between 
a letter in pattern and a non-empty word in s. Specifically:

. Each letter in pattern maps to exactly one unique word in s.
. Each unique word in s maps to exactly one letter in pattern.
. No two letters map to the same word, and no two words map to the same letter.
*/

public class E290_Word_Pattern {

	public static void main(String[] args) {
		E290_Word_Pattern solution = new E290_Word_Pattern();
		String input = "abba", s = "dog cat cat dog";
		boolean output = solution.wordPattern(input, s);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param pattern: a string
     * @param str: a string
     * @return: find if s follows the same pattern
     */
	public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) return false;
            } else {
                charToWord.put(c, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) return false;
            } else {
                wordToChar.put(word, c);
            }
        }

        return true;
    }

}
