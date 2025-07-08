package com.reverseString;
import java.util.*;

/*
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.
*/

public class E344_Reverse_String {

	public static void main(String[] args) {
		E344_Reverse_String solution = new E344_Reverse_String();
		char[] input = {'h','e','l','l','o'};
		char[] inputCopy = Arrays.copyOf(input, input.length);
		solution.reverseString(input);
        System.out.println("input: " + Arrays.toString(inputCopy) + "\noutput: " + Arrays.toString(input));
	}
	
	
	public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

}
