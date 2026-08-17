package com.jinwang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class E496_Next_Greater_Element_I {

	public static void main(String[] args) {
		E496_Next_Greater_Element_I solution = new E496_Next_Greater_Element_I();

		// Example 1
		int[] nums1_1 = {4, 1, 2};
		int[] nums2_1 = {1, 3, 4, 2};
		
		System.out.println("Input: nums1 = " + Arrays.toString(nums1_1)
				+ ", nums2 = " + Arrays.toString(nums2_1));
		System.out.println("Output: "
				+ Arrays.toString(solution.nextGreaterElement(nums1_1, nums2_1)));
		System.out.println();
		
		// Example 2
		int[] nums1_2 = {2, 4};
		int[] nums2_2 = {1, 2, 3, 4};
		
		System.out.println("Input: nums1 = " + Arrays.toString(nums1_2)
				+ ", nums2 = " + Arrays.toString(nums2_2));
		System.out.println("Output: "
				+ Arrays.toString(solution.nextGreaterElement(nums1_2, nums2_2)));
	}
	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> nextGreater = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		
		for (int num : nums2) {
			// Current number is the next greater element
			while (!stack.isEmpty() && stack.peek() < num) {
				nextGreater.put(stack.pop(), num);
			}
			stack.push(num);
		}
		
		// Remaining numbers have no next greater element
		while (!stack.isEmpty()) {
			nextGreater.put(stack.pop(), -1);
		}
		
		int[] answer = new int[nums1.length];
		
		for (int i = 0; i < nums1.length; i++) {
			answer[i] = nextGreater.get(nums1[i]);
		}
		
		return answer;
	}

}
