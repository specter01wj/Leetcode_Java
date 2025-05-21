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
		String input = "aa";
		String magazine = "aab";
		boolean output = solution.canConstruct(input, magazine);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Use an array count of size 26 to keep track of the frequency of each lowercase letter in magazine.
	2. For each character in ransomNote, we decrement the corresponding count.
	3. If any count goes below 0, it means there aren’t enough letters in magazine to form ransomNote.
    */
	
	/*
     * @param ransomNote: a string
     * @param magazine: a string
     * @return: true if ransomNote can be constructed by using the letters from magazine
     */
	public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26]; // For each letter 'a' to 'z'

        // Count letters in magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if ransomNote can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

}
