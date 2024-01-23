package com.letterCombinationsofaPhoneNumber;
import java.util.*;

/*
Given a string containing digits from 2-9 inclusive, return 
all possible letter combinations that the number could represent. 
Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) 
is given below. Note that 1 does not map to any letters.
*/

public class M17_Letter_Combinations_of_a_Phone_Number {

	public static void main(String[] args) {
		String input = "23";
		List<String> output = letterCombinations(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> combinations = new ArrayList<>();
        backtrack(combinations, digits, "", 0);
        return combinations;
    }

    private static void backtrack(List<String> combinations, String digits, String current, int index) {
        if (index == digits.length()) {
            combinations.add(current);
            return;
        }

        String letters = LETTERS[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            backtrack(combinations, digits, current + letter, index + 1);
        }
    }

}
