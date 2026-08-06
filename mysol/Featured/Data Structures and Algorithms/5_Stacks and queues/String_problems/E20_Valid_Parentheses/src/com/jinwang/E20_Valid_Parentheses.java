package com.jinwang;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class E20_Valid_Parentheses {

	public static void main(String[] args) {
		
		E20_Valid_Parentheses solution = new E20_Valid_Parentheses();

        String input1 = "()";
        String input2 = "()[]{}";
        String input3 = "(]";
        String input4 = "([])";
        String input5 = "([)]";

        System.out.println("Input: " + input1 + "\nOutput: " + solution.isValid(input1));
        System.out.println();

        System.out.println("Input: " + input2 + "\nOutput: " + solution.isValid(input2));
        System.out.println();

        System.out.println("Input: " + input3 + "\nOutput: " + solution.isValid(input3));
        System.out.println();

        System.out.println("Input: " + input4 + "\nOutput: " + solution.isValid(input4));
        System.out.println();

        System.out.println("Input: " + input5 + "\nOutput: " + solution.isValid(input5));
	}
	
	public boolean isValid(String s) {

        Map<Character, Character> matching = new HashMap<>();

        matching.put('(', ')');
        matching.put('[', ']');
        matching.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Opening bracket
            if (matching.containsKey(c)) {
                stack.push(c);
            } else {
                // Closing bracket with no matching opening bracket
                if (stack.empty()) {
                    return false;
                }

                char previousOpening = stack.pop();

                // Brackets do not match
                if (matching.get(previousOpening) != c) {
                    return false;
                }
            }
        }

        // Valid only if no unmatched opening brackets remain
        return stack.empty();
    }

}
