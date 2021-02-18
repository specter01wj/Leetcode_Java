package com.arrayPartitionI;
import java.util.*;

/*Given an integer array nums of 2n integers, group these integers 
into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum 
of min(ai, bi) for all i is maximized. Return the maximized sum.



Example 1:

Input: nums = [1,4,3,2]
Output: 4
Explanation: All possible pairings (ignoring the ordering of elements) are:
1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
So the maximum possible sum is 4.
Example 2:

Input: nums = [6,2,6,5,1,2]
Output: 9
Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + 
min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.*/

public class E561_Array_Partition_I {

	public static void main(String[] args) {
		int[] input = {1,4,3,2,100,9};//{6,2,6,5,1,2};
        int output = arrayPairSum(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    将数组排序后，取出所有奇数位（下标为偶数）求和即可。 
    简单思路：从大往小考虑，数组最大值不可能是答案的一部分，数组第二大的值如果要是答案的一部分，
    必须和最大值配对。 此时原问题的答案转化为子问题(去除最大值和第二大值)的答案+数组第二大的值。
    */
	
	/**
     * @param nums: an array
     * @return: the sum of min(ai, bi) for all i from 1 to n
     */
	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int ans = 0;
		
		for(int i = 0; i < nums.length; i += 2) {
			ans += nums[i];
		}
		
		return ans;
	}

}
