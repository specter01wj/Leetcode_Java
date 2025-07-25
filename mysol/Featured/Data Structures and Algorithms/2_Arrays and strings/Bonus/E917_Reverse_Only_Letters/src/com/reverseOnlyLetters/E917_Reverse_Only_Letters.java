package com.reverseOnlyLetters;
import java.util.*;

/*
Given a string s, reverse the string according to the following rules:

	. All the characters that are not English letters remain in the same position.
	. All the English letters (lowercase or uppercase) should be reversed.

Return s after reversing it.
*/

public class E917_Reverse_Only_Letters {

	public static void main(String[] args) {
		E917_Reverse_Only_Letters solution = new E917_Reverse_Only_Letters();
		String input = "Test1ng-Leet=code-Q!";
		String output = solution.reverseOnlyLetters(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            if (!Character.isLetter(chars[left])) {
                left++;
            } else if (!Character.isLetter(chars[right])) {
                right--;
            } else {
                // Swap letters
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }

}
