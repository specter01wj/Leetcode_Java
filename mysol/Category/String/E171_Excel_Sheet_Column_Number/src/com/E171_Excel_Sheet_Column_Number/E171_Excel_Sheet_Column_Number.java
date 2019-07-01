package com.E171_Excel_Sheet_Column_Number;

import java.util.*;

/*Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701*/

public class E171_Excel_Sheet_Column_Number {

	public static void main(String[] args) {
		String input = "AB";
        int output = titleToNumber(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    把这个字符串看成26进制数，把它转化成10进制即可
    */
	
	/*
     * @param s: a string
     * @return: return its corresponding column number
     */
	public static int titleToNumber(String s) {
		int res = 0;
		
		for(int i = 0; i < s.length(); i++) {
			double t1 = Math.pow(26, s.length() - 1 - i);
			int r1 = (s.charAt(i) - 64);
			res += Math.pow(26, s.length() - 1 - i) * (s.charAt(i) - 64);
		}
		
		return res;
	}

}
