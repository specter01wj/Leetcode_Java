package com.E326_Power_of_Three;

import java.util.*;

/*Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false*/

public class E326_Power_of_Three {

	public static void main(String[] args) {
		int input = 729;
        boolean output = isPowerOfThree(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Approach 1: Loop Iteration
	One simple way of finding out if a number n is a power of a number b is to keep 
	dividing n by b as long as the remainder is 0. This is because we can write
	
	n = b^x
	n = b x b x ... x b
	
	Hence it should be possible to divide n by b x times, every time with a remainder 
	of 0 and the end result to be 1.
    */
	
	/*
     * @param n: an integer
     * @return: boolean, if n is a power of three
     */
	public static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

}
