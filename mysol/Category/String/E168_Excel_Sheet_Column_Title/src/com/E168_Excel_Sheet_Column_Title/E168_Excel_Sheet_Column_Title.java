package com.E168_Excel_Sheet_Column_Title;

import java.util.*;

/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"*/

public class E168_Excel_Sheet_Column_Title {

	public static void main(String[] args) {
		int input = 28;
        String output = convertToTitle(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    
    */
	
	/*
     * @param n: an integer
     * @return: return its corresponding column title as appear in an Excel sheet
     */
	public static String convertToTitle(int n) {
		StringBuilder str = new StringBuilder();
		
		while(n > 0) {
			n--;
			str.append( (char)((n % 26) + 'A') );
			n /= 26;
		}
		
		return str.reverse().toString();
	}

}
