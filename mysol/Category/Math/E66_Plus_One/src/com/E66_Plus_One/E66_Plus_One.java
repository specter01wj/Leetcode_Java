package com.E66_Plus_One;

import java.util.*;

/*Given a non-empty array of digits representing a non-negative integer, 
 * plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, 
and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.*/

public class E66_Plus_One {

	public static void main(String[] args) {
		int[] input = {4,3,2,1};
        int[] output = plusOne(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
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
     * @param digits: an array of digits representing a non-negative integer
     * @return: an array of digits plus 1
     */
	public static int[] plusOne(int[] digits) {
		int carries = 1;
		
		for(int i = digits.length - 1; i >= 0 && carries > 0; i--) {
			int sum = digits[i] + carries;
			digits[i] = sum % 10;
			carries = sum / 10;
		}
		
		if(carries == 0) {
			return digits;
		}
		
		int[] rst = new int[digits.length + 1];
		rst[0] = 1;
		
		for(int i = 1; i < rst.length; i++) {
			rst[i] = digits[i - 1];
		}
		
		return rst;
	}

}
