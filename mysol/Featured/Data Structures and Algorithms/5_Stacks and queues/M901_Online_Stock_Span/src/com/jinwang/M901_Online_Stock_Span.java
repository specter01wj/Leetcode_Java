package com.jinwang;

import java.util.Stack;

public class M901_Online_Stock_Span {

	public static void main(String[] args) {
		StockSpanner stockSpanner = new StockSpanner();

		// Example 1
		int input1 = 100;
		System.out.println("Input: " + input1);
		System.out.println("Output: " + stockSpanner.next(input1));
		System.out.println();
		
		// Example 2
		int input2 = 80;
		System.out.println("Input: " + input2);
		System.out.println("Output: " + stockSpanner.next(input2));
		System.out.println();
		
		// Example 3
		int input3 = 60;
		System.out.println("Input: " + input3);
		System.out.println("Output: " + stockSpanner.next(input3));
		System.out.println();
		
		// Example 4
		int input4 = 70;
		System.out.println("Input: " + input4);
		System.out.println("Output: " + stockSpanner.next(input4));
		System.out.println();
		
		// Example 5
		int input5 = 60;
		System.out.println("Input: " + input5);
		System.out.println("Output: " + stockSpanner.next(input5));
		System.out.println();
		
		// Example 6
		int input6 = 75;
		System.out.println("Input: " + input6);
		System.out.println("Output: " + stockSpanner.next(input6));
		System.out.println();
		
		// Example 7
		int input7 = 85;
		System.out.println("Input: " + input7);
		System.out.println("Output: " + stockSpanner.next(input7));
	}

}

class StockSpanner {

	private Stack<int[]> stack;
	public StockSpanner() {
		stack = new Stack<>();
	}
	public int next(int price) {
		int span = 1;
		// Remove prices less than or equal to current price
		while (!stack.isEmpty() && stack.peek()[0] <= price) {
			span += stack.pop()[1];
		}
		// Store current price and its span
		stack.push(new int[]{price, span});
		return span;
	}

}
