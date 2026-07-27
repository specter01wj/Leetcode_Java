package com.jinwang;

import java.util.Stack;

public class Ch5_exp1 {

	public static void main(String[] args) {
		
		// Create a stack
		Stack<Integer> stack = new Stack<>();
		
		// Push elements
        System.out.println("=== Push ===");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);

	}

}
