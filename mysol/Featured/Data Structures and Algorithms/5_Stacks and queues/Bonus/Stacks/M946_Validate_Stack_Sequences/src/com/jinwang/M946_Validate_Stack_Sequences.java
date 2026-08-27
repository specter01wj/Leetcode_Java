package com.jinwang;

import java.util.Arrays;
import java.util.Stack;

public class M946_Validate_Stack_Sequences {

	public static void main(String[] args) {
		M946_Validate_Stack_Sequences solution = new M946_Validate_Stack_Sequences();

		// Example 1
		int[] pushed1 = {1, 2, 3, 4, 5};
		int[] popped1 = {4, 5, 3, 2, 1};

		System.out.println("Input: pushed = " + Arrays.toString(pushed1)
				+ ", popped = " + Arrays.toString(popped1));
		System.out.println("Output: "
				+ solution.validateStackSequences(pushed1, popped1));
		System.out.println();

		// Example 2
		int[] pushed2 = {1, 2, 3, 4, 5};
		int[] popped2 = {4, 3, 5, 1, 2};

		System.out.println("Input: pushed = " + Arrays.toString(pushed2)
				+ ", popped = " + Arrays.toString(popped2));
		System.out.println("Output: "
				+ solution.validateStackSequences(pushed2, popped2));
	}
	
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int j = 0;

		for (int num : pushed) {
			stack.push(num);

			// Pop while the top matches the next expected popped value
			while (!stack.isEmpty()
					&& j < popped.length
					&& stack.peek() == popped[j]) {
				stack.pop();
				j++;
			}
		}

		return stack.isEmpty();
	}

}
