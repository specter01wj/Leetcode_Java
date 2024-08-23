package com.largestSubarrayLengthK;
import java.util.*;

/*
An array A is larger than some array B if for the first index i 
where A[i] != B[i], A[i] > B[i].

For example, consider 0-indexing:

 . [1,3,2,4] > [1,2,2,4], since at index 1, 3 > 2.
 . [1,4,4,4] < [2,1,1,1], since at index 0, 1 < 2.

A subarray is a contiguous subsequence of the array.

Given an integer array nums of distinct integers, return the 
largest subarray of nums of length k.
*/

public class E1708_Largest_Subarray_Length_K {

	public static void main(String[] args) {
		E1708_Largest_Subarray_Length_K solution = new E1708_Largest_Subarray_Length_K();
		int[] input = {1,4,5,2,3};
		int k = 3;
		int[] output = solution.largestSubarray(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] largestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] largest = new int[k];
        
        // Start with the first subarray of length k
        int startIndex = 0;
        
        // Iterate to find the subarray that starts at the largest value
        for (int i = 1; i <= n - k; i++) {
            // Compare subarrays starting at index 'startIndex' and 'i'
            for (int j = 0; j < k; j++) {
                if (nums[startIndex + j] < nums[i + j]) {
                    startIndex = i;
                    break;
                } else if (nums[startIndex + j] > nums[i + j]) {
                    break;
                }
            }
        }
        
        // Fill the result array with the largest subarray found
        for (int i = 0; i < k; i++) {
            largest[i] = nums[startIndex + i];
        }
        
        return largest;
    }

}
