package com.counttheNumberofVowelStringsinRange;
import java.util.*;

/*
You are given a 0-indexed array of string words and two integers left and right.

A string is called a vowel string if it starts with a vowel character and ends 
with a vowel character where vowel characters are 'a', 'e', 'i', 'o', and 'u'.

Return the number of vowel strings words[i] where i belongs to the inclusive 
range [left, right].
*/

public class E2586_Count_the_Number_of_Vowel_Strings_in_Range {

	public static void main(String[] args) {
		E2586_Count_the_Number_of_Vowel_Strings_in_Range solution = new E2586_Count_the_Number_of_Vowel_Strings_in_Range();
		String[] input = {"hey","aeo","mu","ooo","artro"};
		int left = 1, right = 4;
		int output = solution.vowelStrings(input, left, right);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        String vowels = "aeiou";

        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (vowels.indexOf(word.charAt(0)) != -1 && vowels.indexOf(word.charAt(word.length() - 1)) != -1) {
                count++;
            }
        }

        return count;
    }

}
