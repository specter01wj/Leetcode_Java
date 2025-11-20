package com.determineifTwoStringsAreClose;
import java.util.*;

/*
Two strings are considered close if you can attain one from the other using the following operations:

. Operation 1: Swap any two existing characters.
	. For example, abcde -> aecdb

. Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
	. For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)

You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
*/

public class M1657_Determine_if_Two_Strings_Are_Close {

	public static void main(String[] args) {
		M1657_Determine_if_Two_Strings_Are_Close solution = new M1657_Determine_if_Two_Strings_Are_Close();
		String input = "cabbba", word2 = "abbccc";
		boolean output = solution.closeStrings(input, word2);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param word1: a string
     * @param word2: a string
     * @return: true if word1 and word2 are close, and false otherwise
     */
	public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        for (char c : word1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }

        for (char c : word2.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }

        // Check if both have the same set of characters
        if (!freq1.keySet().equals(freq2.keySet())) return false;

        // Check if both have the same set of frequencies
        List<Integer> values1 = new ArrayList<>(freq1.values());
        List<Integer> values2 = new ArrayList<>(freq2.values());

        Collections.sort(values1);
        Collections.sort(values2);

        return values1.equals(values2);
    }

}
