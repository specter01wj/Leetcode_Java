package com.lengthofLongestSubarrayWithatMostKFrequency;
import java.util.*;

/*
You are given an integer array nums and an integer k.

The frequency of an element x is the number of times it occurs in an array.

An array is called good if the frequency of each element in this array is less than or equal to k.

Return the length of the longest good subarray of nums.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

public class M2958_Length_of_Longest_Subarray_With_at_Most_K_Frequency {

	public static void main(String[] args) {
		M2958_Length_of_Longest_Subarray_With_at_Most_K_Frequency solution = new M2958_Length_of_Longest_Subarray_With_at_Most_K_Frequency();
		int[] input = {1,2,3,1,2,3,1,2};
		int k = 2;
		int output = solution.maxSubarrayLength(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // If frequency of nums[right] exceeds k, shrink the window
            while (freq.get(nums[right]) > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}
