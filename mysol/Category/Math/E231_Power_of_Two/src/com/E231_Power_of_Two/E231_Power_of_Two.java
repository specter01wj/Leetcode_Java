package com.E231_Power_of_Two;

import java.util.*;

/*Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false*/

public class E231_Power_of_Two {

	public static void main(String[] args) {
		int input = 16;
        boolean output = isPowerOfTwo(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    
    */
	
	/*
     * @param n: an integer
     * @return: boolean, True or false
     */
	public static boolean isPowerOfTwo(int n) {
		if(n <= 0) {
			return false;
		}
		
		return (n & (n - 1)) == 0;
	}

}
