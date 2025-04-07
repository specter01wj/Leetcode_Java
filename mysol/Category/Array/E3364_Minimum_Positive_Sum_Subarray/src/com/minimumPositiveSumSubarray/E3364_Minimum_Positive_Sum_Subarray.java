package com.minimumPositiveSumSubarray;
import java.util.*;

/*
You are given an integer array nums and two integers l and r. 
Your task is to find the minimum sum of a subarray whose size is 
between l and r (inclusive) and whose sum is greater than 0.

Return the minimum sum of such a subarray. If no such subarray exists, return -1.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

public class E3364_Minimum_Positive_Sum_Subarray {

	public static void main(String[] args) {
		int[] input = {3, -2, 1, 4};
		int l = 2, r = 3;
		int output = minimumSumSubarray(input, l, r);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefix = new int[n + 1];
        
        // Build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int minPositiveSum = Integer.MAX_VALUE;

        // Try all subarray lengths from l to r
        for (int len = l; len <= r; len++) {
            for (int i = 0; i + len <= n; i++) {
                int sum = prefix[i + len] - prefix[i];
                if (sum > 0) {
                    minPositiveSum = Math.min(minPositiveSum, sum);
                }
            }
        }

        return minPositiveSum == Integer.MAX_VALUE ? -1 : minPositiveSum;
    }

}
