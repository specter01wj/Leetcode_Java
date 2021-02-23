package com.degreeofanArray;
import java.util.*;

/*Given a non-empty array of non-negative integers nums, 
the degree of this array is defined as the maximum frequency 
of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) 
subarray of nums, that has the same degree as nums.

 

Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation: 
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.*/

public class E697_Degree_of_an_Array {

	public static void main(String[] args) {
		int[] input = {1,2,2,3,1,4,2};
        int output = findShortestSubArray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    题意分析：
	1、从题目中发现，字串的第一个元素就是出现次数最多的第一个元素，
	字串的最后一个元素就是出现次数最多的最后一个元素。
	2、因此我们要求出第一次出现的元素到最后一次出现的字串的最小长度。
	解题思路：
	1、用一个MAP记录每个字符出现的次数。
	2、在用一个MAP记录每个元素第一次出现的位置，用于记录当前元素的字串长度。
	3、次数变大后，字串长度要重新更新
    */
	
	/**
     * @param nums: a list of integers
     * @return: return a integer
     */
	public static int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> startIndex = new HashMap<>();
		Map<Integer, Integer> count = new HashMap<>();
		
		int len = Integer.MAX_VALUE, frequency = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(!startIndex.containsKey(nums[i])) {
				startIndex.put(nums[i], i);
			}
			count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
			if(count.get(nums[i]) == frequency) {
				len = Math.min(i - startIndex.get(nums[i]) + 1, len);
			} else if(count.get(nums[i]) > frequency) {
				len = i - startIndex.get(nums[i]) + 1;
				frequency = count.get(nums[i]);
			}
		}
		
		return len;
	}

}
