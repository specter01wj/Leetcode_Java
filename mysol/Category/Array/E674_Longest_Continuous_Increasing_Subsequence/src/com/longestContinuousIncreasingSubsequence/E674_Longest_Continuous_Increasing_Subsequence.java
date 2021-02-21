package com.longestContinuousIncreasingSubsequence;
import java.util.*;

/*Given an unsorted array of integers nums, return the length of the 
longest continuous increasing subsequence (i.e. subarray). 
The subsequence must be strictly increasing.

A continuous increasing subsequence is defined by two indices l and 
r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], 
nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 3
Explanation: 
The longest continuous increasing subsequence is [1,3,5] with length 3.
Even though [1,3,5,7] is an increasing subsequence, it is not continuous 
as elements 5 and 7 are separated by element 4.

Example 2:

Input: nums = [2,2,2,2,2]
Output: 1
Explanation: 
The longest continuous increasing subsequence is [2] with length 1. 
Note that it must be strictly increasing.*/

public class E674_Longest_Continuous_Increasing_Subsequence {

	public static void main(String[] args) {
		int[] input = {1,3,5,4,7};
        int output = findLengthOfLCIS(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	public static int findLengthOfLCIS(int[] nums) {
		int res = 0, cnt = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(i == 0 || nums[i - 1] < nums[i]) {
				res = Math.max(res, ++cnt);
			} else {
				cnt = 1;
			}
		}
		
		return res;
	}

}
