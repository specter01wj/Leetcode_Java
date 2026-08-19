package com.jinwang;

import java.util.Stack;

public class M2390_Removing_Stars_From_a_String {

	public static void main(String[] args) {
		M2390_Removing_Stars_From_a_String solution = new M2390_Removing_Stars_From_a_String();
		
		// Example 1
		String input1 = "leet**cod*e";
		System.out.println("Input: " + input1);
		System.out.println("Output: " + solution.removeStars(input1));
		System.out.println();
		
		// Example 2
		String input2 = "erase*****";
		System.out.println("Input: " + input2);
		System.out.println("Output: " + solution.removeStars(input2));
	}
	
	public String removeStars(String s) {

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '*') {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		StringBuilder answer = new StringBuilder();
		for (char c : stack) {
			answer.append(c);
		}
		return answer.toString();
	}

}
