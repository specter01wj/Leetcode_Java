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
