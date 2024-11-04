package com.findMaximumNumberofStringPairs;
import java.util.*;

/*
You are given a 0-indexed array words consisting of distinct strings.

The string words[i] can be paired with the string words[j] if:

	. The string words[i] is equal to the reversed string of words[j].
	. 0 <= i < j < words.length.

Return the maximum number of pairs that can be formed from the array words.

Note that each string can belong in at most one pair.
*/

public class E2744_Find_Maximum_Number_of_String_Pairs {

	public static void main(String[] args) {
		String[] input = {"cd","ac","dc","ca","zz"};
		int output = maximumNumberOfStringPairs(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int maximumNumberOfStringPairs(String[] words) {
		int pairs = 0;
		HashSet<String> unmatchedWords = new HashSet<>();
		
		// Check if the reversed word is in the set
		for (String word : words) {
			String reversedWord = new StringBuilder(word).reverse().toString();
			
			if (unmatchedWords.contains(reversedWord)) {
				pairs++;
				unmatchedWords.remove(reversedWord); // Pair found, remove the reversed word
			} else {
				unmatchedWords.add(word); // Add the word to unmatched set
			}
		}
		
		return pairs;
	}

}
