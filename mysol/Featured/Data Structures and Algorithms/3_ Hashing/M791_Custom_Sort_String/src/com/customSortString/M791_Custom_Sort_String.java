package com.customSortString;
import java.util.*;

/*
You are given two strings order and s. All the characters of order 
are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order 
was sorted. More specifically, if a character x occurs before a 
character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.
*/

public class M791_Custom_Sort_String {

	public static void main(String[] args) {
		M791_Custom_Sort_String solution = new M791_Custom_Sort_String();
		String input = "cba", s = "abcd";
		String output = solution.customSortString(input, s);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param order: a string
     * @param s: a string
     * @return: any permutation of s that satisfies this property
     */
	public String customSortString(String order, String s) {
        // Count frequency of each character in s
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        // Append characters in the order specified by 'order'
        for (char ch : order.toCharArray()) {
            if (freqMap.containsKey(ch)) {
                int count = freqMap.get(ch);
                while (count-- > 0) {
                    result.append(ch);
                }
                freqMap.remove(ch); // remove to avoid re-adding
            }
        }

        // Append remaining characters not in 'order'
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int count = entry.getValue();
            while (count-- > 0) {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }

}
