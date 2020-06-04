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
    思路：直接对答案可能存在的区间进行二分 => 二分答案
	注意：判断区间的时候一个小技巧： mid * mid == x 中使用乘法可能会溢出，
	写成 mid == x / mid 即可防止溢出，不需要使用long或者BigInteger
    */
	
	/*
     * @param x: an integer
     * @return: integer, The sqrt of x
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
