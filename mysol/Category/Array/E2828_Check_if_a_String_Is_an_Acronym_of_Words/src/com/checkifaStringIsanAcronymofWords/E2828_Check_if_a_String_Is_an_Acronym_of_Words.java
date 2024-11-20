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
