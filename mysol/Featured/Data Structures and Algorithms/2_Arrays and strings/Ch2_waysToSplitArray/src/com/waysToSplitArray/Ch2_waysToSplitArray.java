package com.waysToSplitArray;
import java.util.*;

/*
Example 2: 2270. Number of Ways to Split Array

Given an integer array nums, find the number of ways to split 
the array into two parts so that the first section has a sum 
greater than or equal to the sum of the second section. 
The second section should have at least one number.
*/

public class Ch2_waysToSplitArray {

	public static void main(String[] args) {
		Ch2_waysToSplitArray solution = new Ch2_waysToSplitArray();
		int[] input = {10,4,-8,7};
		int output = solution.waysToSplitArray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Prefix sum
    */
	
	/*
     * @param nums: a list of integers
     * @return: the number of valid splits in nums
     */
	public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }
        
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            long leftSection = prefix[i];
            long rightSection = prefix[n - 1] - prefix[i];
            if (leftSection >= rightSection) {
                ans++;
            }
        }
        
        return ans;
    }

}
