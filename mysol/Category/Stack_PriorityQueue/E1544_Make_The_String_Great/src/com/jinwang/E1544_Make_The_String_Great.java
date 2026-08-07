package com.jinwang;

import java.util.Stack;

public class E1544_Make_The_String_Great {

	public static void main(String[] args) {
		E1544_Make_The_String_Great solution = new E1544_Make_The_String_Great();

        String input1 = "leEeetcode";
        String input2 = "abBAcC";
        String input3 = "s";

        System.out.println("Input: " + input1 +
                "\nOutput: " + solution.makeGood(input1));
        System.out.println();

        System.out.println("Input: " + input2 +
                "\nOutput: " + solution.makeGood(input2));
        System.out.println();

        System.out.println("Input: " + input3 +
                "\nOutput: " + solution.makeGood(input3));
	}
	
	public String makeGood(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.empty() && Math.abs(stack.peek() - c) == 32) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (char c : stack) {
            ans.append(c);
        }

        return ans.toString();
    }

}
