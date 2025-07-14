package com.maximumAverageSubarrayI;
import java.util.*;

/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum 
average value and return this value. Any answer with a calculation error 
less than 10-5 will be accepted.
*/

public class E643_Maximum_Average_Subarray_I {

	public static void main(String[] args) {
		E643_Maximum_Average_Subarray_I solution = new E643_Maximum_Average_Subarray_I();
		int[] input = {1,12,-5,-6,50,3};
		int k = 4;
		double output = solution.findMaxAverage(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Sliding window
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: find a contiguous subarray
     */
	public double findMaxAverage(int[] nums, int k) {
        double curr = 0;

        // Sum of first k elements
        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }

        double maxSum = curr;

        // Sliding window
        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, curr);
        }

        return maxSum / k;
    }

}
