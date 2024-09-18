package com.countPairsOfSimilarStrings;
import java.util.*;

/*
You are given a 0-indexed string array words.

Two strings are similar if they consist of the same characters.

	. For example, "abca" and "cba" are similar since both consist of characters 'a', 'b', and 'c'.
	. However, "abacba" and "bcfd" are not similar since they do not consist of the same characters.

Return the number of pairs (i, j) such that 0 <= i < j <= word.length - 1 and 
the two strings words[i] and words[j] are similar.
*/

public class E2506_Count_Pairs_Of_Similar_Strings {

	public static void main(String[] args) {
		E2506_Count_Pairs_Of_Similar_Strings solution = new E2506_Count_Pairs_Of_Similar_Strings();
		String[] input = {"aba","aabb","abcd","bac","aabc"};
		int output = solution.similarPairs(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Represent Each Word as a Set of Characters:
		. For each word, create a representation that captures the set of 
			unique characters it contains.
		. Since the words consist of lowercase English letters ('a' to 'z'), 
			we can use a 26-bit integer where each bit represents a character.
	2. Use a HashMap to Count Similar Words:
		. Use a HashMap to map each unique character set representation to 
			the number of times it appears.
		. For example, if two words have the same character set, they will 
			have the same key in the map.
	3. Calculate the Number of Pairs:
		. For each unique character set with a frequency greater than 1, 
			calculate the number of pairs using the combination formula: 
			count * (count - 1) / 2.
		. Sum up the pairs for all character sets.
    */
	
	/*
     * @param arr: a list of strings
     * @return: the number of pairs
     */
	public int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int signature = 0;
            for (char c : word.toCharArray()) {
                signature |= 1 << (c - 'a');
            }
            map.put(signature, map.getOrDefault(signature, 0) + 1);
        }
        int count = 0;
        for (int freq : map.values()) {
            if (freq >= 2) {
                count += freq * (freq - 1) / 2;
            }
        }
        return count;
    }

}
