package com.jinwang;

import java.util.Stack;

public class E1047_Remove_All_Adjacent_Duplicates_In_String {

	public static void main(String[] args) {
		E1047_Remove_All_Adjacent_Duplicates_In_String solution = new E1047_Remove_All_Adjacent_Duplicates_In_String();

        String input1 = "abbaca";
        String input2 = "azxxzy";

        System.out.println("Input: " + input1 + "\nOutput: " + solution.removeDuplicates(input1));
        System.out.println();

        System.out.println("Input: " + input2 + "\nOutput: " + solution.removeDuplicates(input2));
	}
	
	public String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (char c : s.toCharArray()) {
			if (!stack.empty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		
		StringBuilder ans = new StringBuilder();
		
		while (!stack.empty()) {
			ans.append(stack.pop());
		}
		
		return ans.reverse().toString();
	}

}
