package com.maximumUniqueSubarraySumAfterDeletion;
import java.util.*;

/*
You are given an integer array nums.

You are allowed to delete any number of elements from nums without 
making it empty. After performing the deletions, select a subarray 
of nums such that:

	1. All elements in the subarray are unique.
	2. The sum of the elements in the subarray is maximized.

Return the maximum sum of such a subarray.
*/

public class E3487_Maximum_Unique_Subarray_Sum_After_Deletion {

	public static void main(String[] args) {
		E3487_Maximum_Unique_Subarray_Sum_After_Deletion solution = new E3487_Maximum_Unique_Subarray_Sum_After_Deletion();
		int[] input = {1,2,-1,-2,1,0,-1};
		int output = solution.maxSum(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int maxSum(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        int sum = 0;
        int maxNegative = Integer.MIN_VALUE;

        // Collect all unique positive integers
        for (int num : nums) {
            if (num > 0) {
                unique.add(num);
            } else {
                maxNegative = Math.max(maxNegative, num);
            }
        }

        // Sum all unique positive values
        for (int val : unique) {
            sum += val;
        }

        // If we have any positive numbers, return their sum
        if (!unique.isEmpty()) {
            return sum;
        }

        // Otherwise, return the largest negative number
        return maxNegative;
    }

}
