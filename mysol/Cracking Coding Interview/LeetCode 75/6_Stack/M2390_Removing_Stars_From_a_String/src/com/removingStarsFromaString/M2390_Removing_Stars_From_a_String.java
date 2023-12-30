package com.removingStarsFromaString;
import java.util.*;

/*
You are given a string s, which contains stars *.

In one operation, you can:

 .Choose a star in s.
 .Remove the closest non-star character to its left, 
  as well as remove the star itself.

Return the string after all stars have been removed.
*/

public class M2390_Removing_Stars_From_a_String {

	public static void main(String[] args) {
		String input = "leet**cod*e";
        String output = removeStars(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static String removeStars(String s) {
        // Use a StringBuilder as a stack to store the characters
        StringBuilder stack = new StringBuilder();

        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // If the current character is a star, remove the last character from the stack
            if (ch == '*') {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                // If it's not a star, add it to the stack
                stack.append(ch);
            }
        }

        // Convert the stack back to a string and return it
        return stack.toString();
    }

}
