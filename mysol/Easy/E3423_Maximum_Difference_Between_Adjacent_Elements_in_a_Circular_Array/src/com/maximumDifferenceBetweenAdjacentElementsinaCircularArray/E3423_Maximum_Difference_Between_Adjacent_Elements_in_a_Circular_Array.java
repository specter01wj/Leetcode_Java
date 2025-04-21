package com.maximumDifferenceBetweenAdjacentElementsinaCircularArray;
import java.util.*;

/*
Given a circular array nums, find the maximum absolute difference between 
adjacent elements.
*/

public class E3423_Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array {

	public static void main(String[] args) {
		E3423_Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array solution = new E3423_Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array();
		int[] input = {1,2,4};
		int output = solution.maxAdjacentDistance(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1 .Since the array is circular, we need to consider each element nums[i] and 
    	its neighbor nums[i+1], but for the last element, its neighbor is the 
    	first element nums[0].
	2. Compute the absolute difference |nums[i] - nums[(i+1)%n]| for every index i.
	3. Track the maximum of all these differences.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the maximum absolute difference between adjacent elements
     */
	public int maxAdjacentDistance(int[] nums) {
		int maxDiff = 0;
		int n = nums.length;
		
		for (int i = 0; i < n; i++) {
			int next = (i + 1) % n; // Circular wrap
			int diff = Math.abs(nums[i] - nums[next]);
			maxDiff = Math.max(maxDiff, diff);
		}
		
		return maxDiff;
	}

}
