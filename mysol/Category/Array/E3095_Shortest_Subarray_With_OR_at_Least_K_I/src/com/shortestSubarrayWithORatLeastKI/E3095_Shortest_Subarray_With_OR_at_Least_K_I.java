package com.shortestSubarrayWithORatLeastKI;
import java.util.*;

/*
You are given an array nums of non-negative integers and an integer k.

An array is called special if the bitwise OR of all of its elements is at least k.

Return the length of the shortest special non-empty subarray of nums, 
or return -1 if no special subarray exists.
*/

public class E3095_Shortest_Subarray_With_OR_at_Least_K_I {

	public static void main(String[] args) {
		E3095_Shortest_Subarray_With_OR_at_Least_K_I solution = new E3095_Shortest_Subarray_With_OR_at_Least_K_I();
		int[] input = {2,1,8};
		int k = 10;
		int output = solution.minimumSubarrayLength(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Outer Loop: Iterate over all starting indices i in the array.
	2. Inner Loop: For each starting index i, calculate the bitwise 
		OR of subarrays starting from i and ending at j.
	3. Check Condition: If the OR value is at least k, update the 
		minimum subarray length (minLength) and break out of the inner 
		loop as any larger subarray starting at i will also meet the condition.
	4. Edge Case: If no subarray satisfies the condition, return -1.
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: the length of the shortest special non-empty subarray of nums
     */
	public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int orValue = 0;
            for (int j = i; j < n; j++) {
                orValue |= nums[j];
                if (orValue >= k) {
                    minLength = Math.min(minLength, j - i + 1);
                    break; // No need to continue since we found a subarray from i to j
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

}
