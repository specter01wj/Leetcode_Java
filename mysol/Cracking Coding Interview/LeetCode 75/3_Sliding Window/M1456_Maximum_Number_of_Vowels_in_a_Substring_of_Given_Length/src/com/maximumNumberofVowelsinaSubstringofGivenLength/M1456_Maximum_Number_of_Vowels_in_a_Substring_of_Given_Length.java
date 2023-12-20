package com.maximumNumberofVowelsinaSubstringofGivenLength;
import java.util.*;

/*
Given a string s and an integer k, return the maximum number of vowel 
letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
*/

public class M1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {

	public static void main(String[] args) {
		String input = "abciiidef";
		int k = 3;
		int output = maxVowels(input, k);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static int maxVowels(String s, int k) {
        int maxVowels = 0;
        int currentVowels = 0;

        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
        }

        maxVowels = currentVowels;

        // Slide the window and update the count
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
            if (isVowel(s.charAt(i - k))) {
                currentVowels--;
            }

            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }

    // Helper method to check if a character is a vowel
    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

}
