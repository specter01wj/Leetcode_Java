package com.jinwang;

public class E20_Valid_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
