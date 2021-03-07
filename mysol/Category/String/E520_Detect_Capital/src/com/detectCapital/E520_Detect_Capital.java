package com.detectCapital;
import java.util.*;

/*Given a word, you need to judge whether the usage of capitals 
in it is right or not.

We define the usage of capitals in a word to be right when one 
of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 

Example 1:

Input: "USA"
Output: True
 

Example 2:

Input: "FlaG"
Output: False*/

public class E520_Detect_Capital {

	public static void main(String[] args) {
		String input = "Google";
        boolean output = detectCapitalUse(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	public static boolean detectCapitalUse(String word) {
		int countUpper = 0, countLower = 0;
		boolean flag = word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
		
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
				countUpper++;
				if(i != 0 && countLower > 0 && !flag) return false;
				if(countLower > 0 && countUpper > 1) return false;
			} else {
				countLower++;
				if(countUpper > 1) return false;
			}
		}
		
		return true;
	}

}
