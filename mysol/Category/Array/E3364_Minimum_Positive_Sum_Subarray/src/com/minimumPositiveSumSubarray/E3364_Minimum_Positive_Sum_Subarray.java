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
		E3364_Minimum_Positive_Sum_Subarray solution = new E3364_Minimum_Positive_Sum_Subarray();
		List<Integer> input = List.of(3, -2, 1, 4);
		int l = 2, r = 3;
		int output = solution.minimumSumSubarray(input, l, r);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. We create a prefix sum array to calculate subarray sums in constant time.
	2. For each length between l and r, we slide a window and check the sum.
	3. If the sum is positive and less than the current minimum, we update the result.
	4. At the end, if we found at least one valid subarray, return the minimum positive sum; otherwise, return -1.
    */
	
	/*
     * @param nums: a list of integers
     * @param l: an integer
     * @param r: an integer
     * @return: the minimum sum of such a subarray
     */
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
