package com.E67_Add_Binary;

import java.util.*;

/*Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"*/

public class E67_Add_Binary {

	public static void main(String[] args) {
		String input1 = "1010", input2 = "1011";
        String output = addBinary(input1, input2);
        System.out.println("input1: " + (input1) + "input2: " + (input2) + "\noutput: " + (output));
	}
	
	/*
    solution:
    The points of interest are the peaks and valleys in the given graph. 
    We need to find the largest peak following the smallest valley. 
    We can maintain two variables - minprice and maxprofit corresponding 
    to the smallest valley and maximum profit (maximum difference between 
    selling price and minprice) obtained so far respectively.
    */
	
	/*
     * @param a: a string of binary
     * @param b: a string of binary
     * @return: string, binary sum
     */
	public static String addBinary(String a, String b) {
		String ans = "";
		
		int carry = 0;
		
		for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
			int sum = carry;
			sum += (i >= 0) ? a.charAt(i) - '0' : 0;
			sum += (j >= 0) ? b.charAt(j) - '0' : 0;
			ans = (sum % 2) + ans;
			carry = sum / 2;
		}
		
		if(carry != 0) {
			ans = carry +ans;
		}
		
		return ans;
	}

}
