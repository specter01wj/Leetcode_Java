package com.maximumNumberofVowelsinaSubstringofGivenLength;
import java.util.*;

/*
Given a string s and an integer k, return the maximum number of 
vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
*/

public class M1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {

	public static void main(String[] args) {
		M1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length solution = new M1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length();
		String input = "abciiidef";
		int k = 3;
		int output = solution.maxVowels(input, k);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Sliding window
    */
	
	/*
     * @param s: a string
     * @param k: an integer
     * @return: the maximum number of vowel letters
     */
	public int maxVowels(String s, int k) {
        int max = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) count++;
            if (i >= k && isVowel(s.charAt(i - k))) count--;
            max = Math.max(max, count);
        }
        return max;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

}
