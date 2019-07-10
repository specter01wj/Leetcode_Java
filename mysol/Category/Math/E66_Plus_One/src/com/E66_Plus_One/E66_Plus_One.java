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
		int[] input = {9,9,9};//{4,3,2,1}
        int[] output = plusOne(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    // The complexity is O(1)
    // f(n) = 9/10 + 1/10 * O(n-1)
    //  ==>  O(n) =  10 / 9 = 1.1111 = O(1)
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
