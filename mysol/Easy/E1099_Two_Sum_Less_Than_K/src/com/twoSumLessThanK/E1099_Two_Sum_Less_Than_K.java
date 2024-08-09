package com.twoSumLessThanK;
import java.util.*;

/*
Given an array nums of integers and integer k, return 
the maximum sum such that there exists i < j with 
nums[i] + nums[j] = sum and sum < k. 
If no i, j exist satisfying this equation, return -1.
*/

public class E1099_Two_Sum_Less_Than_K {

	public static void main(String[] args) {
		E1099_Two_Sum_Less_Than_K solution = new E1099_Two_Sum_Less_Than_K();
		int[] input = {34, 23, 1, 24, 75, 33, 54, 8};
		int k = 60;
		int output = solution.twoSumLessThanK(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Sort the Array
    2. Initialize Two Pointers
    3. Iterate and Adjust Pointers
    4. Return the Maximum Sum
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: the maximum sum
     */
	public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array
        int left = 0;
        int right = nums.length - 1;
        int maxSum = -1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                maxSum = Math.max(maxSum, sum); // Update the max sum if the current sum is less than k
                left++; // Move the left pointer to the right
            } else {
                right--; // Move the right pointer to the left
            }
        }

        return maxSum; // Return the maximum sum found
    }

}
