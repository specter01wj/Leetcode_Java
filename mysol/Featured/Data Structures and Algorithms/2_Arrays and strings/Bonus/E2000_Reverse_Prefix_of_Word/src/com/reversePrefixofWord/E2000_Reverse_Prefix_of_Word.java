package com.reversePrefixofWord;
import java.util.*;

/*
Given a 0-indexed string word and a character ch, reverse the 
segment of word that starts at index 0 and ends at the index 
of the first occurrence of ch (inclusive). If the character 
ch does not exist in word, do nothing.

	. For example, if word = "abcdefd" and ch = "d", then you should 
	  reverse the segment that starts at 0 and ends at 3 (inclusive). 
	  The resulting string will be "dcbaefd".

Return the resulting string.
*/

public class E2000_Reverse_Prefix_of_Word {

	public static void main(String[] args) {
		E2000_Reverse_Prefix_of_Word solution = new E2000_Reverse_Prefix_of_Word();
		String input = "abcdefd";
		char ch = 'd';
		String output = solution.reversePrefix(input, ch);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx == -1) return word;

        StringBuilder sb = new StringBuilder(word.substring(0, idx + 1));
        sb.reverse().append(word.substring(idx + 1));
        return sb.toString();
    }

}
