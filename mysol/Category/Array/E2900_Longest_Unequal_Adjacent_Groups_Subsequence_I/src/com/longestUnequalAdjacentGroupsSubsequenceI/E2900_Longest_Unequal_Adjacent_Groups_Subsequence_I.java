package com.longestUnequalAdjacentGroupsSubsequenceI;
import java.util.*;

/*
You are given a string array words and a binary array groups 
both of length n, where words[i] is associated with groups[i].

Your task is to select the longest alternating subsequence 
from words. A subsequence of words is alternating if for any 
two consecutive strings in the sequence, their corresponding 
elements in the binary array groups differ. Essentially, 
you are to choose strings such that adjacent elements have 
non-matching corresponding bits in the groups array.

Formally, you need to find the longest subsequence of an array 
of indices [0, 1, ..., n - 1] denoted as [i0, i1, ..., ik-1], 
such that groups[ij] != groups[ij+1] for each 0 <= j < k - 1 
and then find the words corresponding to these indices.

Return the selected subsequence. If there are multiple answers, 
return any of them.
*/

public class E2900_Longest_Unequal_Adjacent_Groups_Subsequence_I {

	public static void main(String[] args) {
		E2900_Longest_Unequal_Adjacent_Groups_Subsequence_I solution = new E2900_Longest_Unequal_Adjacent_Groups_Subsequence_I();
		String[] input = {"e","a","b"};
		int[] groups = {0,0,1};
		List<String> output = solution.getLongestSubsequence(input, groups);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Start With the First Word:
		. Add the first word to the result list since it starts the subsequence.
	2. Ensure Alternating Groups:
		. Iterate through the groups array starting from index 1.
		. If the current group value (groups[i]) differs from the previous group 
			value (groups[i - 1]), add the corresponding word (words[i]) to the 
			result list.
	3. Return the Result:
		. At the end of the loop, result contains the longest alternating 
			subsequence of words.
    */
	
	/*
     * @param words: a list of strings
     * @param groups: a list of integers
     * @return: the selected subsequence. If there are multiple answers, return any of them
     */
	public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        // Add the first word to the result
        result.add(words[0]);

        // Iterate through the array and ensure alternating groups
        for (int i = 1; i < n; i++) {
            if (groups[i] != groups[i - 1]) {
                result.add(words[i]);
            }
        }

        return result;
    }

}
