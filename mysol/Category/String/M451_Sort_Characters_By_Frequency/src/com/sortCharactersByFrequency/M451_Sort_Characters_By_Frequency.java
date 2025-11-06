package com.sortCharactersByFrequency;
import java.util.*;

/*
Given a string s, sort it in decreasing order based on the frequency 
of the characters. 
The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.
*/

public class M451_Sort_Characters_By_Frequency {

	public static void main(String[] args) {
		M451_Sort_Characters_By_Frequency solution = new M451_Sort_Characters_By_Frequency();
		String input = "tree";
		String output = solution.frequencySort(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param s: a string
     * @return: the sorted string
     */
	public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count character frequencies
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Max heap (PriorityQueue) sorted by frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(b) - freqMap.get(a)
        );

        maxHeap.addAll(freqMap.keySet());

        // Build result
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int count = freqMap.get(c);
            sb.append(String.valueOf(c).repeat(count));
        }

        return sb.toString();
    }

}
