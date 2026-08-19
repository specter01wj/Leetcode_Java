package com.jinwang;

import java.util.Stack;

public class E232_Implement_Queue_using_Stacks {

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();

		// Push 1
		System.out.println("Input: push(1)");
		myQueue.push(1);
		System.out.println();
		
		// Push 2
		System.out.println("Input: push(2)");
		myQueue.push(2);
		System.out.println();
		
		// Peek
		System.out.println("Input: peek()");
		System.out.println("Output: " + myQueue.peek());
		System.out.println();
		
		// Pop
		System.out.println("Input: pop()");
		System.out.println("Output: " + myQueue.pop());
		System.out.println();
		
		// Empty
		System.out.println("Input: empty()");
		System.out.println("Output: " + myQueue.empty());
	}

}



class MyQueue {

	private Stack<Integer> inputStack;
	private Stack<Integer> outputStack;
	
	public MyQueue() {
		inputStack = new Stack<>();
		outputStack = new Stack<>();
	}
	
	public void push(int x) {
		inputStack.push(x);
	}
	
	public int pop() {
		moveToOutputStack();
		return outputStack.pop();
	}
	
	public int peek() {
		moveToOutputStack();
		return outputStack.peek();
	}
	
	public boolean empty() {
		return inputStack.isEmpty() && outputStack.isEmpty();
	}
	
	private void moveToOutputStack() {
		if (outputStack.isEmpty()) {
			while (!inputStack.isEmpty()) {
				outputStack.push(inputStack.pop());
			}
		}
	}

}
