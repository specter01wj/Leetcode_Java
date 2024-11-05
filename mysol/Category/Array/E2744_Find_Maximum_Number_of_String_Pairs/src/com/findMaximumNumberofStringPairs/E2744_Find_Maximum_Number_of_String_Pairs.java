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
		E2744_Find_Maximum_Number_of_String_Pairs solution = new E2744_Find_Maximum_Number_of_String_Pairs();
		String[] input = {"cd","ac","dc","ca","zz"};
		int output = solution.maximumNumberOfStringPairs(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. HashSet for Unmatched Words:
		. We use a HashSet called unmatchedWords to track words that do not 
			yet have a matching reversed pair.
	2. Iterate Through words Array:
		. For each word in words, we generate its reversed version.
		. If the reversed word is already in unmatchedWords, we have found 
			a pair, so we:
			. Increment the pairs count.
			. Remove the reversed word from unmatchedWords.
		. If the reversed word is not in unmatchedWords, we add the current 
			word to unmatchedWords as a potential unmatched word.
	3. Return the Total Pairs:
		. At the end of the iteration, pairs contains the maximum number of 
			pairs that can be formed.
    */
	
	/*
     * @param words: a list of strings
     * @return: the maximum number of pairs that can be formed from the array words
     */
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
