package com.buddyStrings;
import java.util.*;

/*Given two strings a and b, return true if you can swap two 
letters in a so the result is equal to b, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) 
such that i != j and swapping the characters at a[i] and b[j]. 
For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

 

Example 1:

Input: a = "ab", b = "ba"
Output: true
Explanation: You can swap a[0] = 'a' and a[1] = 'b' to get "ba", 
which is equal to b.

Example 2:

Input: a = "ab", b = "ab"
Output: false
Explanation: The only letters you can swap are a[0] = 'a' and 
a[1] = 'b', which results in "ba" != b.

Example 3:

Input: a = "aa", b = "aa"
Output: true
Explanation: You can swap a[0] = 'a' and a[1] = 'a' to get "aa", 
which is equal to b.

Example 4:

Input: a = "aaaaaaabc", b = "aaaaaaacb"
Output: true*/

public class E859_Buddy_Strings {

	public static void main(String[] args) {
		String input1 = "aba";
		String input2 = "baa";
        int output = buddyStrings(input1, input2);
        System.out.println("input1: " + (input1) + " input2: " + (input2) + "\noutput: " + (output));
	}
	
	public static boolean buddyStrings(String a, String b) {
		
	}

}
