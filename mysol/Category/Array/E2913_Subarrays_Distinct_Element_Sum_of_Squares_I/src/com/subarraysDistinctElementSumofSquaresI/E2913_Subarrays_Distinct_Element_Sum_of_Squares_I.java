package com.subarraysDistinctElementSumofSquaresI;
import java.util.*;

/*
You are given a 0-indexed integer array nums.

The distinct count of a subarray of nums is defined as:

	. Let nums[i..j] be a subarray of nums consisting of all the 
		indices from i to j such that 0 <= i <= j < nums.length. 
		Then the number of distinct values in nums[i..j] is called 
		the distinct count of nums[i..j].

Return the sum of the squares of distinct counts of all subarrays of nums.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

public class E2913_Subarrays_Distinct_Element_Sum_of_Squares_I {

	public static void main(String[] args) {
		E2913_Subarrays_Distinct_Element_Sum_of_Squares_I solution = new E2913_Subarrays_Distinct_Element_Sum_of_Squares_I();
		List<Integer> input = List.of(1, 2, 1);
		int output = solution.sumCounts(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int totalSum = 0;

        // Iterate over all possible subarray starting points
        for (int i = 0; i < n; i++) {
            HashSet<Integer> distinctSet = new HashSet<>();

            // Iterate over all possible subarray ending points
            for (int j = i; j < n; j++) {
                // Add the current element to the distinct set
                distinctSet.add(nums.get(j));

                // Get the size of the set (distinct count) and add its square to totalSum
                int distinctCount = distinctSet.size();
                totalSum += distinctCount * distinctCount;
            }
        }

        return totalSum;
    }

}
