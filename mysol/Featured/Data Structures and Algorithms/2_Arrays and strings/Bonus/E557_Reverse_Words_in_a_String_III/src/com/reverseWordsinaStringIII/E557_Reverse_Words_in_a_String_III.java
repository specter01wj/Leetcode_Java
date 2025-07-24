package com.reverseWordsinaStringIII;
import java.util.*;

/*
Given a string s, reverse the order of characters in each word within 
a sentence while still preserving whitespace and initial word order.
*/

public class E557_Reverse_Words_in_a_String_III {

	public static void main(String[] args) {
		E557_Reverse_Words_in_a_String_III solution = new E557_Reverse_Words_in_a_String_III();
		String input = "Let's take LeetCode contest";
		String output = solution.reverseWords(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }
        return result.toString().trim();
    }

}
