package com.thousandSeparator;
import java.util.*;

/*
Given an integer n, add a dot (".") as the thousands separator and return it in string format.


Example 1:

Input: n = 987
Output: "987"

Example 2:

Input: n = 1234
Output: "1.234"
*/

public class E1556_Thousand_Separator {

	public static void main(String[] args) {
		int input = 1234;
		String output = thousandSeparator(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static String thousandSeparator(int n) {
        String num = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = num.length(); i > 0; i -= 3) {
            if (sb.length() > 0) {
            	sb.insert(0, ".");
            }
            sb.insert(0, num.substring(Math.max(0, i - 3), i));
        }
        return sb.toString();
    }

}
