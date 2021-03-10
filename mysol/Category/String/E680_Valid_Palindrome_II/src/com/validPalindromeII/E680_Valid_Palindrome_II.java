package com.validPalindromeII;
import java.util.*;

/*Given a non-empty string s, you may delete at most one character. 
Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True

Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.*/

public class E680_Valid_Palindrome_II {

	public static void main(String[] args) {
		String input = "abdcda";
        boolean output = validPalindrome(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }
        
        if(left >= right) {
        	return true;
        }
        
        return isSubPalindrome(s, left + 1, right) || isSubPalindrome(s, left, right - 1);
    }
    
    private static boolean isSubPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }

}
