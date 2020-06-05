package com.E268_Missing_Number;

import java.util.*;

/*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8*/

public class E268_Missing_Number {

	public static void main(String[] args) {
		int[] input = {9,6,4,2,3,5,7,0,1};//{27,26,29,30,31};
        int output = missingNumber(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    The basic idea is to use XOR operation. 
    We all know that a^b^b =a, which means two xor operations with the same number 
    will eliminate the number and reveal the original number.
	In this solution, I apply XOR operation to both the index and value of the array. 
	In a complete array with no missing numbers, the index and value should be perfectly 
	corresponding( nums[index] = index), so in a missing array, what left finally is 
	the missing number.
    */
	
	/*
     * @param nums: an array of integers
     * @return: an integer
     */
	public static int missingNumber(int[] nums) {
        //sol1:
		int xor = 0, i = 0;
        
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
		//sol2: (only for numbers from 0 to n)
		/*int n = nums.length + 1;
        int sum = 0;
        int expectedSum = n* (n-1)/2;

        for(int i = 0, len = nums.length; i < len; i++){
            sum += nums[i];
        }

        return expectedSum - sum;*/
    }

}
