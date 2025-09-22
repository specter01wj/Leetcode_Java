package com.repeatedCharacter;
import java.util.*;

/*
Given a string s consisting of lowercase English letters, return the first letter to appear twice.
*/

public class Ch3_repeatedCharacter {

	public static void main(String[] args) {
		Ch3_repeatedCharacter solution = new Ch3_repeatedCharacter();
		String input = "abccbaacz";
		char output = solution.repeatedCharacter(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashSet
    */
	
	/*
     * @param s: a string
     * @return: the first letter to appear twice
     */
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
