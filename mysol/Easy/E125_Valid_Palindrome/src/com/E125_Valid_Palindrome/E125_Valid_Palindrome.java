package com.E125_Valid_Palindrome;

import java.util.*;

/*Given a string, determine if it is a palindrome, considering only 
 * alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false*/

public class E125_Valid_Palindrome {

	public static void main(String[] args) {
		String input = "A man, a plan, a canal: Panama";
        boolean output = isPalindrome(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    使用两根指针遍历整个字符串即可.
	假定有指针i, j, 其中i是从前往后遍历, j是从后往前遍历.
	当i在j左边时继续循环, 每一次将i右移到数字/字母上, j左移到数字/字母上,
	比较二者对应的字符串内的字符是否相同, 不相同则原字符串不是回文串.
	如果全部的比较都相同, 说明是回文串.
    */
	
	/*
     * @param s: a string
     * @return: boolean determine if it is a palindrome
     */
	public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < s.length() && !isvalid(s.charAt(front))) { // nead to check range of a/b
                front++;
            }

            if (front == s.length()) { // for empty string “.,,,”     
                return true; 
            }           

            while (end >= 0 && ! isvalid(s.charAt(end))) { // same here, need to check border of a,b
                end--;
            }

            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } else {
                front++;
                end--;
            }
        }

        return end <= front; 
    }

    private static boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

}
