package com.jinwang;

import java.util.LinkedList;
import java.util.Queue;

public class E225_Implement_Stack_Using_Queues {

	public static void main(String[] args) {
		MyStack myStack = new MyStack();

		// Example 1
		myStack.push(1);
		myStack.push(2);

		System.out.println("Input: top()");
		System.out.println("Output: " + myStack.top());
		System.out.println();

		System.out.println("Input: pop()");
		System.out.println("Output: " + myStack.pop());
		System.out.println();

		System.out.println("Input: empty()");
		System.out.println("Output: " + myStack.empty());
	}

}

class MyStack {

	private Queue<Integer> queue;

	public MyStack() {
		queue = new LinkedList<>();
	}

	public void push(int x) {
		queue.offer(x);

		// Move previous elements behind the new element
		int size = queue.size();

		for (int i = 0; i < size - 1; i++) {
			queue.offer(queue.poll());
		}
	}

	public int pop() {
		return queue.poll();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}

}
