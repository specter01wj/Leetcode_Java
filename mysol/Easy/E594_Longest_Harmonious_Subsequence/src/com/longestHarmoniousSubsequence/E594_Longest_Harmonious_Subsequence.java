package com.longestHarmoniousSubsequence;
import java.util.*;

/*We define a harmonious array as an array where the difference 
 between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest 
harmonious subsequence among all its possible subsequences.

A subsequence of array is a sequence that can be derived from 
the array by deleting some or no elements without changing 
the order of the remaining elements.

Example 1:

Input: nums = [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].

Example 2:

Input: nums = [1,2,3,4]
Output: 2

Example 3:

Input: nums = [1,1,1,1]
Output: 0
*/

public class E594_Longest_Harmonious_Subsequence {

	public static void main(String[] args) {
		int[] input = {1,3,2,2,5,2,3,7};
        int output = findLHS(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    直接统计数组中元素的个数，取相邻两 个数不为0 的数的 个数和 的最大值即为答案。
    */
	
	/**
     * @param nums: a list of integers
     * @return: return a integer
     */
	public static int findLHS(int[] nums) {
		TreeMap<Integer,Integer> vis = new TreeMap<>();
		
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            vis.put(nums[i], vis.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 0; i < nums.length; i++) {
            if(vis.getOrDefault(nums[i] - 1, 0) != 0) {
                ans = Math.max(ans, vis.get(nums[i] - 1) + vis.get(nums[i]));
            }
        }
        
        return ans;
	}

}
