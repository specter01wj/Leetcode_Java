package com.reformatTheString;
import java.util.*;

/*
You are given an alphanumeric string s. (Alphanumeric string 
is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is 
followed by another letter and no digit is followed by another digit. 
That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is 
impossible to reformat the string.


Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type 
in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.

Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.

Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.
*/

public class E1417_Reformat_The_String {

	public static void main(String[] args) {
		String input = "a0b1c2";
        String output = reformat(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static String reformat(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        List<Character> digits = new ArrayList<>(s.length());
        List<Character> characters = new ArrayList<>(s.length());
        // Check if it is a digit or character
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.add(ch);
            } else  {
                characters.add(ch);
            }
        }
        // it is impossible to reformat the string.
        if(Math.abs(digits.size() - characters.size()) >= 2) return "";
        
        StringBuilder result = new StringBuilder();
        // boolean to decide if we should start with characters or digits
        boolean digitOrChar = (digits.size() >= characters.size()) ? true : false; 

       for (int i = 0; i < s.length(); i++) {
            if (digitOrChar) {
                if (digits.size() > 0) {
                    result.append(digits.remove(0));    
                }
            } else {
                if (characters.size() > 0) {
                    result.append(characters.remove(0));    
                }
            }
            digitOrChar = !digitOrChar;
        }
        return result.toString();
    }

}
