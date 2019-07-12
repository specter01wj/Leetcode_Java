package com.E69_Sqrtx;

import java.util.*;

/*Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer 
part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.*/

public class E69_Sqrtx {

	public static void main(String[] args) {
		int input = 41;
        int output = mySqrt(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
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
     * @param prices: a list of integers
     * @return: find a maximum profit
     */
	public static int mySqrt(int x) {
		if(x == 0) {
			return 0;
		}
		
		int left = 1, right = Integer.MAX_VALUE;
		
		while(true) {
			int mid = left + (right - left) / 2;
			if(mid > x / mid) {
				right = mid - 1;
			} else {
				if(mid + 1 > x / (mid + 1)) {
					return mid;
				}
				left = mid + 1;
			}
		}
		
	}

}
