package com.minimumSizeSubarraySum;
import java.util.*;

/*
Given an array of positive integers nums and a positive integer target, 
return the minimal length of a subarray whose sum is greater than or 
equal to target. If there is no such subarray, return 0 instead.
*/

public class M209_Minimum_Size_Subarray_Sum {

	public static void main(String[] args) {
		M209_Minimum_Size_Subarray_Sum solution = new M209_Minimum_Size_Subarray_Sum();
		int[] input = {2,3,1,2,4,3};
		int target = 7;
		int output = solution.minSubArrayLen(target, input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
