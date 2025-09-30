package com.areOccurrencesEqual;
import java.util.*;

/*
Given a string s, return true if s is a good string, or false otherwise.

A string s is good if all the characters that appear in s have the same 
number of occurrences (i.e., the same frequency).
*/

public class Ch3_areOccurrencesEqual {

	public static void main(String[] args) {
		Ch3_areOccurrencesEqual solution = new Ch3_areOccurrencesEqual();
		String input = "abacbc";
		boolean output = solution.areOccurrencesEqual(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param s: a string
     * @return: true if s is a good string
     */
	public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count frequencies
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        Set<Integer> frequencies = new HashSet<>(freqMap.values());
        return frequencies.size() == 1;
    }

}
