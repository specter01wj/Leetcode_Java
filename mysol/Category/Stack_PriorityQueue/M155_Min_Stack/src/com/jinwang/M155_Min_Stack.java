package com.jinwang;

import java.util.Stack;

public class M155_Min_Stack {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();

		// Example 1
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);

		System.out.println("Input: getMin()");
		System.out.println("Output: " + minStack.getMin());
		System.out.println();

		minStack.pop();

		System.out.println("Input: top()");
		System.out.println("Output: " + minStack.top());
		System.out.println();

		System.out.println("Input: getMin()");
		System.out.println("Output: " + minStack.getMin());
	}

}

class MinStack {

	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int value) {
		stack.push(value);

		if (minStack.isEmpty() || value <= minStack.peek()) {
			minStack.push(value);
		}
	}

	public void pop() {
		int value = stack.pop();

		if (value == minStack.peek()) {
			minStack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

}
