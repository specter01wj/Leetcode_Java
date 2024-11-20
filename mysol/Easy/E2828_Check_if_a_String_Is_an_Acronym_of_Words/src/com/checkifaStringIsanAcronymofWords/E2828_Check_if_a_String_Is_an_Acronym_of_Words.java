package com.checkifaStringIsanAcronymofWords;
import java.util.*;

/*
Given an array of strings words and a string s, determine if s is 
an acronym of words.

The string s is considered an acronym of words if it can be formed 
by concatenating the first character of each string in words in order. 
For example, "ab" can be formed from ["apple", "banana"], but it can't 
be formed from ["bear", "aardvark"].

Return true if s is an acronym of words, and false otherwise.
*/

public class E2828_Check_if_a_String_Is_an_Acronym_of_Words {

	public static void main(String[] args) {
		E2828_Check_if_a_String_Is_an_Acronym_of_Words solution = new E2828_Check_if_a_String_Is_an_Acronym_of_Words();
		List<String> input = List.of("never", "gonna", "give", "up", "on", "you");
		String s = "ngguoy";
		boolean output = solution.isAcronym(input, s);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Early Exit if Lengths Don't Match:
		. If the number of words in words is not equal to the length of s, 
			return false immediately. This ensures they can potentially 
			form an acronym.
	2. Build the Acronym:
		. Use a StringBuilder to construct the acronym by appending the 
			first character of each word in words.
	3. Compare with s:
		. After constructing the acronym, compare it with s using .equals(). 
			Return true if they match, otherwise false.
	4. Return the Result:
		. The result of the comparison determines if s is an acronym of words.
    */
	
	/*
     * @param words: a list of strings
     * @param s: a string
     * @return: true if s is an acronym of words, and false otherwise
     */
	public boolean isAcronym(List<String> words, String s) {
        // If the lengths do not match, it cannot be an acronym
        if (words.size() != s.length()) {
            return false;
        }

        // Build the acronym from the first characters of the words
        StringBuilder acronym = new StringBuilder();
        for (String word : words) {
            acronym.append(word.charAt(0)); // Add the first character of each word
        }

        // Compare the built acronym with the given string s
        return acronym.toString().equals(s);
    }

}
