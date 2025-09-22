package com.checkiftheSentenceIsPangram;
import java.util.*;

/*
A pangram is a sentence where every letter of the English alphabet 
appears at least once.

Given a string sentence containing only lowercase English letters, 
return true if sentence is a pangram, or false otherwise.
*/

public class E1832_Check_if_the_Sentence_Is_Pangram {

	public static void main(String[] args) {
		E1832_Check_if_the_Sentence_Is_Pangram solution = new E1832_Check_if_the_Sentence_Is_Pangram();
		String input = "thequickbrownfoxjumpsoverthelazydog";
		boolean output = solution.checkIfPangram(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public boolean checkIfPangram(String sentence) {
		Set<Character> seen = new HashSet<>();
		
		for ( char c : sentence.toCharArray()) {
			seen.add(c);
		}
		
		return seen.size() == 26;
	}

}
