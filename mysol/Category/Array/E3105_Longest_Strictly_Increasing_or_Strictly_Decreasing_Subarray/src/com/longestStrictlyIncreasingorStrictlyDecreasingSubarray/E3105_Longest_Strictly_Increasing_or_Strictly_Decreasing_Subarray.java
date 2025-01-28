package com.longestStrictlyIncreasingorStrictlyDecreasingSubarray;
import java.util.*;

/*
You are given an array of integers nums. Return the length of the longest 
subarray of nums which is either strictly increasing or strictly decreasing.
*/

public class E3105_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray {

	public static void main(String[] args) {
		E3105_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray solution = new E3105_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray();
		int[] input = {1,4,3,3,2};
		int output = solution.longestMonotonicSubarray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    count good triplets
    */
	
	/*
     * @param arr: a list of integers
     * @param a: an integer
     * @param b: an integer
     * @param c: an integer
     * @return: the number of good triplets
     */
	public int longestMonotonicSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int maxLength = 1; // Minimum length of any subarray is 1
        int incLength = 1; // Length of the current increasing subarray
        int decLength = 1; // Length of the current decreasing subarray

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                incLength++;
                decLength = 1; // Reset decreasing subarray length
            } else if (nums[i] < nums[i - 1]) {
                decLength++;
                incLength = 1; // Reset increasing subarray length
            } else {
                // Reset both lengths when elements are equal
                incLength = 1;
                decLength = 1;
            }

            // Update the maximum length found so far
            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }

        return maxLength;
    }

}
