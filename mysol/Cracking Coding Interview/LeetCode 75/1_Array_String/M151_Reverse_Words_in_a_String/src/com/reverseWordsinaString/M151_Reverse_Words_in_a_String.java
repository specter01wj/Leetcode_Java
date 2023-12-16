package com.reverseWordsinaString;
import java.util.*;

/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. 
The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between 
two words. The returned string should only have a single space separating the words. 
Do not include any extra spaces.
*/

public class M151_Reverse_Words_in_a_String {

	public static void main(String[] args) {
		String input = "the sky is blue";
        String output = reverseWords(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static String reverseWords(String s) {
		// Trim the input string to remove leading and trailing spaces
        s = s.trim();

        // Split the string by spaces (one or more)
        String[] words = s.split("\\s+");

        // StringBuilder to build the reversed string
        StringBuilder reversed = new StringBuilder();

        // Iterate over the words array in reverse order
        for(int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            // Append a space if it's not the last word
            if (i > 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
	}

}
