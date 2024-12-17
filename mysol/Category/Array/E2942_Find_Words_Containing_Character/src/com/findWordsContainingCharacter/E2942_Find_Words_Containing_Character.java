package com.findWordsContainingCharacter;
import java.util.*;

/*
You are given a 0-indexed array of strings words and a character x.

Return an array of indices representing the words that contain the character x.

Note that the returned array may be in any order.
*/

public class E2942_Find_Words_Containing_Character {

	public static void main(String[] args) {
		E2942_Find_Words_Containing_Character solution = new E2942_Find_Words_Containing_Character();
		String[] input = {"abc","bcd","aaaa","cbc"};
		char x = 'a';
		List<Integer> output = solution.findWordsContaining(input, x);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Loop Through Words: Iterate over the array words using a loop.
	2. Check for Character: Use the indexOf method on each word to check 
		if the character x exists (indexOf(x) != -1).
	3. Add Index to Result: If the character exists, add the current index 
		to the result list.
	4. Return Result: Return the list of indices after iterating through all words.
    */
	
	/*
     * @param words: a list of strings
     * @param x: a char
     * @return: an array of indices representing the words
     */
	public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) { // Check if the character x exists in the current word
                result.add(i); // Add the index to the result list
            }
        }
        
        return result; // Return the list of indices
    }

}
