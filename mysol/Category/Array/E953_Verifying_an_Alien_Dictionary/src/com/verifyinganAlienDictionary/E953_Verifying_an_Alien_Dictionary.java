package com.verifyinganAlienDictionary;
import java.util.*;

/*
In an alien language, surprisingly, they also use English lowercase letters, 
but possibly in a different order. 
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of 
the alphabet, return true if and only if the given words are sorted 
lexicographically in this alien language.


Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, 
then the sequence is sorted.

Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, 
then words[0] > words[1], hence the sequence is unsorted.

Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, 
and the second string is shorter (in size.) According to lexicographical 
rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the 
blank character which is less than any other character (More info).
*/

public class E953_Verifying_an_Alien_Dictionary {

	public static void main(String[] args) {
		String[] input = {"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean output = isAlienSorted(input, order);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Build a transform mapping from order,
	Find all alien words with letters in normal order.
    */
	
	/**
     * @param words: array of string to be verified.
     * @param order: string means the order of characters.
     * @return: true of false.
     */
	static int[] mapping = new int[26];
	public static boolean isAlienSorted(String[] words,String order) {
		for (int i = 0; i < order.length(); i++) {
            mapping[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (cmp(words[i - 1], words[i]))
                return false;
        }
        
        return true;
	}
	
	static boolean cmp(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        for (int i = 0; i < n && i < m; ++i) {
            if (s1.charAt(i) != s2.charAt(i))
                return mapping[s1.charAt(i) - 'a'] > mapping[s2.charAt(i) - 'a'];
        }
        
        return n > m;
    }

}
