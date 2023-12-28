package com.determineifTwoStringsAreClose;
import java.util.*;

/*
Two strings are considered close if you can attain one from the other 
using the following operations:

  .Operation 1: Swap any two existing characters.
	.For example, abcde -> aecdb
  .Operation 2: Transform every occurrence of one existing character 
   into another existing character, and do the same with the other character.
	.For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)

You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, 
and false otherwise.
*/

public class M1657_Determine_if_Two_Strings_Are_Close {

	public static void main(String[] args) {
		String word1 = "abc", word2 = "bca";
		boolean output = closeStrings(word1, word2);
        System.out.println("input1: " + (word1) + "; input2: " + (word2) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Using Bitwise Operation and Frequency Array Map
    */
	
	/*
     * @param word1: a string
     * @param word2: a string
     * @return: true if word1 and word2 are close, and false otherwise
     */
	public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        boolean[] present1 = new boolean[26];
        boolean[] present2 = new boolean[26];

        for (int i = 0; i < word1.length(); i++) {
            freq1[word1.charAt(i) - 'a']++;
            present1[word1.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < word2.length(); i++) {
            freq2[word2.charAt(i) - 'a']++;
            present2[word2.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (present1[i] != present2[i]) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }

}
