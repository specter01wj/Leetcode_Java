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
