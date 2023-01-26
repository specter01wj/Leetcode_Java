package com.minimumOperationstoMaketheArrayIncreasing;
import java.util.*;

/*
You are given an integer array nums (0-indexed). In one operation, 
you can choose an element of the array and increment it by 1.

	.For example, if nums = [1,2,3], you can choose to increment nums[1] to make nums = [1,3,3].
	
Return the minimum number of operations needed to make nums strictly increasing.

An array nums is strictly increasing if nums[i] < nums[i+1] for all 0 <= i < nums.length - 1. 
An array of length 1 is trivially strictly increasing.


Example 1:

Input: nums = [1,1,1]
Output: 3
Explanation: You can do the following operations:
1) Increment nums[2], so nums becomes [1,1,2].
2) Increment nums[1], so nums becomes [1,2,2].
3) Increment nums[2], so nums becomes [1,2,3].

Example 2:

Input: nums = [1,5,2,4,1]
Output: 14

Example 3:

Input: nums = [8]
Output: 0
*/

public class E1827_Minimum_Operations_to_Make_the_Array_Increasing {

	public static void main(String[] args) {
		int[] input = {1,5,2,4,1};
		int output = minOperations(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int minOperations(int[] nums) {
        int cnt = 0, prev = 0;
        for (int cur : nums) {
            if (cur <= prev) {
                cnt += ++prev - cur;
            } else {
                prev = cur;
            }
        }
        return cnt;
    }

}
