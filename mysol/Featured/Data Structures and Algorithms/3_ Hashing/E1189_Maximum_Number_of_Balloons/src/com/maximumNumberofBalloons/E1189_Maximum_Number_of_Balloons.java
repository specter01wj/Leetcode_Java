package com.maximumNumberofBalloons;
import java.util.*;

/*
Given a string text, you want to use the characters of text to form 
as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum 
number of instances that can be formed.
*/

public class E1189_Maximum_Number_of_Balloons {

	public static void main(String[] args) {
		E1189_Maximum_Number_of_Balloons solution = new E1189_Maximum_Number_of_Balloons();
		String input = "loonbalxballpoon";
		int output = solution.maxNumberOfBalloons(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param text: a string
     * @return: the maximum number of instances
     */
	public int maxNumberOfBalloons(String text) {
		Map<Character, Integer> freq = new HashMap<>();
		
		// Count frequency of all characters
		for (char c : text.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		
		// balloon needs: b(1), a(1), l(2), o(2), n(1)
		int b = freq.getOrDefault('b', 0);
		int a = freq.getOrDefault('a', 0);
		int l = freq.getOrDefault('l', 0) / 2;
		int o = freq.getOrDefault('o', 0) / 2;
		int n = freq.getOrDefault('n', 0);
		
		return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
	}

}
