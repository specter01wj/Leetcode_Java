package com.toLowerCase;
import java.util.*;

/*Implement function ToLowerCase() that has a string parameter str, 
and returns the same string in lowercase.



Example 1:

Input: "Hello"
Output: "hello"

Example 2:

Input: "here"
Output: "here"

Example 3:

Input: "LOVELY"
Output: "lovely"*/

public class E709_To_Lower_Case {

	public static void main(String[] args) {
		String input = "Hello";
        String output = toLowerCase(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	public static String toLowerCase(String str) {
		char[] a = str.toCharArray();
		
        for(int i = 0; i < a.length; i++) {
            if(a[i] >= 'A' && a[i] <= 'Z') {
            	a[i] = (char) (a[i] - 'A' + 'a');
            }
        }
        
        return new String(a);
	}

}
