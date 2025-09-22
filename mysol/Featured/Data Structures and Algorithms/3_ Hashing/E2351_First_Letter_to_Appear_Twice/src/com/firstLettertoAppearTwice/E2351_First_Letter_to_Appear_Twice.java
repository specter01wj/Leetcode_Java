package com.firstLettertoAppearTwice;
import java.util.*;

/*
Given a string s consisting of lowercase English letters, return the first letter to appear twice.
*/

public class E2351_First_Letter_to_Appear_Twice {

	public static void main(String[] args) {
		E2351_First_Letter_to_Appear_Twice solution = new E2351_First_Letter_to_Appear_Twice();
		String input = "abccbaacz";
		char output = solution.repeatedCharacter(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public char repeatedCharacter(String s) {
        Set<Character> seen = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                return c;
            }
            seen.add(c);
        }

        // Since the problem guarantees at least one repeated letter
        return ' ';
    }

}
