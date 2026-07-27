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
        
        // Pop elements
        System.out.println("\n=== Pop ===");
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack: " + stack);
        
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack: " + stack);
        
        // Push another element
        System.out.println("\n=== Push Again ===");
        stack.push(5);
        System.out.println("Stack: " + stack);
        
        // Peek
        System.out.println("\n=== Peek ===");
        System.out.println("Top Element: " + stack.peek());
        System.out.println("Stack: " + stack);

	}

}
