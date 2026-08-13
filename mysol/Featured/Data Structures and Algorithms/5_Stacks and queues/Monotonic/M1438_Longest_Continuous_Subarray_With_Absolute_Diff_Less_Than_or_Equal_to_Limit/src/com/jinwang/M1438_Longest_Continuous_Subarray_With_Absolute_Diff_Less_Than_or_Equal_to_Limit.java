package com.jinwang;

import java.util.ArrayDeque;
import java.util.Deque;

public class M1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit {

	public static void main(String[] args) {
		M1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit solution = new M1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit();
		
		int[] input1 = {8, 2, 4, 7};
		int limit1 = 4;
		int output1 = solution.longestSubarray(input1, limit1);
		
		System.out.println("Input: " + java.util.Arrays.toString(input1) + ", limit = " + limit1);
		System.out.println("Output: " + output1);
		System.out.println();
		
		int[] input2 = {10, 1, 2, 4, 7, 2};
		int limit2 = 5;
		int output2 = solution.longestSubarray(input2, limit2);
		System.out.println("Input: " + java.util.Arrays.toString(input2) + ", limit = " + limit2);
		System.out.println("Output: " + output2);
		System.out.println();
		
		int[] input3 = {4, 2, 2, 2, 4, 4, 2, 2};
		int limit3 = 0;
		int output3 = solution.longestSubarray(input3, limit3);
		System.out.println("Input: " + java.util.Arrays.toString(input3) + ", limit = " + limit3);
		System.out.println("Output: " + output3);
	}
	
	public int longestSubarray(int[] nums, int limit) {
		Deque<Integer> increasing = new ArrayDeque<>();
		Deque<Integer> decreasing = new ArrayDeque<>();
		
		int left = 0;
		int answer = 0;
		
		for (int right = 0; right < nums.length; right++) {
			
			// Maintain increasing deque
			while (!increasing.isEmpty() && increasing.peekLast() > nums[right]) {
				increasing.pollLast();
			}
			
			// Maintain decreasing deque
			while (!decreasing.isEmpty() && decreasing.peekLast() < nums[right]) {
				decreasing.pollLast();
			}
			
			increasing.offerLast(nums[right]);
			decreasing.offerLast(nums[right]);
			
			// Shrink window until max - min <= limit
			while (decreasing.peekFirst() - increasing.peekFirst() > limit) {
				if (nums[left] == decreasing.peekFirst()) {
					decreasing.pollFirst();
				}
				if (nums[left] == increasing.peekFirst()) {
					increasing.pollFirst();
				}
				left++;
			}
			answer = Math.max(answer, right - left + 1);
		}
		
		return answer;
	}

}
