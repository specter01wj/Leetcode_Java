package com.subarraySum;
import java.util.*;

/*
Given an array of integers nums and an integer k, return the total 
number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

public class Ch3_subarraySum {

	public static void main(String[] args) {
		Ch3_subarraySum solution = new Ch3_subarraySum();
		int[] input = {1,2,3};
		int k = 3;
		int output = solution.subarraySum(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // base case: sum 0 occurs once

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            // Check if (prefixSum - k) has been seen before
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }

            // Update the prefix sum count map
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

}
