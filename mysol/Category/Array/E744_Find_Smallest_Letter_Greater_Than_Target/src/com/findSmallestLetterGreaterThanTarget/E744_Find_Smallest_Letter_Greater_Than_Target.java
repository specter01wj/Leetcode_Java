package com.findSmallestLetterGreaterThanTarget;
import java.util.*;

/*
Given a characters array letters that is sorted in non-decreasing 
order and a character target, return the smallest character in the 
array that is larger than target.

Note that the letters wrap around.

For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 

Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"

Example 2:

Input: letters = ["c","f","j"], target = "c"
Output: "f"

Example 3:

Input: letters = ["c","f","j"], target = "d"
Output: "f"
*/

public class E744_Find_Smallest_Letter_Greater_Than_Target {

	public static void main(String[] args) {
		char[] input = {'c','f','j','k','m','o','q'};
        char output = nextGreatestLetter(input, 'f');
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static char nextGreatestLetter(char[] letters, char target) {
		int left = 0, right = letters.length - 1;
        while(left <= right) {
            int mid = left + (right-left) / 2;
            if(letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid-1;
            } 
           
        }
        if(left >= 0 && left < letters.length) {
            return letters[left];
        }
        else {
            return letters[0];
        }
	}

}
