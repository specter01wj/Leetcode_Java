package com.sumofSquaresofSpecialElements;
import java.util.*;

/*
You are given a 1-indexed integer array nums of length n.

An element nums[i] of nums is called special if i divides n, i.e. n % i == 0.

Return the sum of the squares of all special elements of nums.
*/

public class E2778_Sum_of_Squares_of_Special_Elements {

	public static void main(String[] args) {
		E2778_Sum_of_Squares_of_Special_Elements solution = new E2778_Sum_of_Squares_of_Special_Elements();
		int[] input = {2,7,1,19,18,3};
		int output = solution.sumOfSquares(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Identify Special Elements:
		. We iterate over each index i from 1 to n (since the array is 1-indexed in the problem).
		. If n % i == 0, then nums[i] is special (i.e., i divides n).
	2. Calculate the Sum of Squares:
		. For each special element, square the value nums[i - 1] (adjusting for 0-based indexing) and add it to sum.
	3. Return the Result:
		. After iterating through all indices, sum holds the result.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the sum of the squares of all special elements of nums
     */
	public int sumOfSquares(int[] nums) {
		int n = nums.length;
		int sum = 0;
		
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				sum += nums[i - 1] * nums[i - 1];
			}
		}
		
		return sum;
	}

}
