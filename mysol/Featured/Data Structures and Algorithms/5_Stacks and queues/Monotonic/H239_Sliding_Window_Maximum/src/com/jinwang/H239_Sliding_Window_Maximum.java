package com.jinwang;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class H239_Sliding_Window_Maximum {

	public static void main(String[] args) {
		H239_Sliding_Window_Maximum solution = new H239_Sliding_Window_Maximum();

		int[] input1 = {1, 3, -1, -3, 5, 3, 6, 7};
		int k1 = 3;
		int[] output1 = solution.maxSlidingWindow(input1, k1);
		
		System.out.println("Input: " + Arrays.toString(input1));
		System.out.println("Output: " + Arrays.toString(output1));
		
		System.out.println();
		
		int[] input2 = {1};
		int k2 = 1;
		int[] output2 = solution.maxSlidingWindow(input2, k2);
		
		System.out.println("Input: " + Arrays.toString(input2));
		System.out.println("Output: " + Arrays.toString(output2));
	}
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] answer = new int[nums.length - k + 1];
		Deque<Integer> deque = new ArrayDeque<>();
		
		for (int i = 0; i < nums.length; i++) {
			
			// Remove indices that are outside the current window
			if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
				deque.pollFirst();
			}
			
			// Maintain monotonic decreasing order
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			
			// Store the current index
			deque.offerLast(i);
			
			// Record maximum once the first window is complete
			if (i >= k - 1) {
				answer[i - k + 1] = nums[deque.peekFirst()];
			}
		}
		
		return answer;
	}

}
