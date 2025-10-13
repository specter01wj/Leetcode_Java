package com.groupAnagrams;
import java.util.*;

/*
Given an array of strings strs, group the anagrams together. 
You can return the answer in any order.
*/

public class Ch3_groupAnagrams {

	public static void main(String[] args) {
		Ch3_groupAnagrams solution = new Ch3_groupAnagrams();
		String[] input = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> output = solution.groupAnagrams(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param strs: a list of strings
     * @return: the answer in any order
     */
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars); // Sorting is the key to identifying anagram groups
            String key = new String(chars);

            anagramGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(anagramGroups.values());
    }

}
