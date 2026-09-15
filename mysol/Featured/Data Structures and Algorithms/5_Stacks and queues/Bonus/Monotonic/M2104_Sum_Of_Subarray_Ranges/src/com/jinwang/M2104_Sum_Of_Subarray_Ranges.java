package com.jinwang;

import java.util.Arrays;
import java.util.Stack;

public class M2104_Sum_Of_Subarray_Ranges {

	public static void main(String[] args) {
		M2104_Sum_Of_Subarray_Ranges solution =
                new M2104_Sum_Of_Subarray_Ranges();

        // Example 1
        int[] nums1 = {1, 2, 3};

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.subArrayRanges(nums1));
        System.out.println();

        // Example 2
        int[] nums2 = {1, 3, 3};

        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.subArrayRanges(nums2));
        System.out.println();

        // Example 3
        int[] nums3 = {4, -2, -3, 4, 1};

        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.subArrayRanges(nums3));
	}
	
	public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long minSum = 0;
        long maxSum = 0;

        Stack<Integer> stack = new Stack<>();

        // Sum of minimums
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty()
                    && (i == n || nums[stack.peek()] > nums[i])) {

                int index = stack.pop();
                int left = stack.isEmpty() ? index + 1 : index - stack.peek();
                int right = i - index;

                minSum += (long) nums[index] * left * right;
            }

            stack.push(i);
        }

        stack.clear();

        // Sum of maximums
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty()
                    && (i == n || nums[stack.peek()] < nums[i])) {

                int index = stack.pop();
                int left = stack.isEmpty() ? index + 1 : index - stack.peek();
                int right = i - index;

                maxSum += (long) nums[index] * left * right;
            }

            stack.push(i);
        }

        return maxSum - minSum;
    }

}
