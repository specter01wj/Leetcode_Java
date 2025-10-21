package com.ransomNote;
import java.util.*;

/*
Given two strings ransomNote and magazine, return true if ransomNote 
can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.
*/

public class E383_Ransom_Note {

	public static void main(String[] args) {
		E383_Ransom_Note solution = new E383_Ransom_Note();
		String input = "aa", magazine = "aab";
		boolean output = solution.canConstruct(input, magazine);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param ransomNote: a string
     * @param magazine: a string
     * @return: true if ransomNote can be constructed
     */
	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> freq = new HashMap<>();
		
		for (char c : magazine.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		
		for (char c : ransomNote.toCharArray()) {
			if (!freq.containsKey(c) || freq.get(c) == 0) {
				return false;
			}
			freq.put(c, freq.get(c) - 1);
		}
		
		return true;
	}

}
