package com.jinwang;

import java.util.Arrays;
import java.util.Stack;

public class H1063_Number_Of_Valid_Subarrays {

	public static void main(String[] args) {
		H1063_Number_Of_Valid_Subarrays solution =
                new H1063_Number_Of_Valid_Subarrays();

        // Example 1
        int[] nums1 = {1, 4, 2, 5, 3};

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.validSubarrays(nums1));
        System.out.println();

        // Example 2
        int[] nums2 = {3, 2, 1};

        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.validSubarrays(nums2));
        System.out.println();

        // Example 3
        int[] nums3 = {2, 2, 2};

        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.validSubarrays(nums3));
	}
	
	public int validSubarrays(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }

            stack.push(num);
            count += stack.size();
        }

        return count;
    }

}
