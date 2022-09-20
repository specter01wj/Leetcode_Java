package com.removeOutermostParentheses;
import java.util.*;

/*
A valid parentheses string is either empty "", "(" + A + ")", or A + B, 
where A and B are valid parentheses strings, and + represents string 
concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses 
strings.
A valid parentheses string s is primitive if it is nonempty, and there 
does not exist a way to split it into s = A + B, with A and B nonempty 
valid parentheses strings.

Given a valid parentheses string s, consider its primitive 
decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive 
valid parentheses strings.

Return s after removing the outermost parentheses of every primitive 
string in the primitive decomposition of s.


Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", 
with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", 
with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, 
this is "()()" + "()" + "()(())" = "()()()()(())".

Example 3:

Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
*/

public class E1021_Remove_Outermost_Parentheses {

	public static void main(String[] args) {
		String input = "(()())(())(()(()))";
        String output = removeOuterParentheses(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    opened count the number of opened parenthesis.
	Add every char to the result,
	unless the first left parenthesis,
	and the last right parenthesis.
    */
	
	/**
     * @param s: a string
     * @return: after removing the outermost parentheses
     */
	public static String removeOuterParentheses(String s) {
		StringBuilder str = new StringBuilder();
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && (opened++ > 0)) {
            	str.append(c);
            }
            if (c == ')' && (opened-- > 1)) {
            	str.append(c);
            }
        }
        return str.toString();
	}

}
