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
