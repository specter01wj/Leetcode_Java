package com.decodeString;
import java.util.*;

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string 
inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are 
no extra white spaces, square brackets are well-formed, etc. 
Furthermore, you may assume that the original data does not contain 
any digits and that digits are only for those repeat numbers, k. 
For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output 
will never exceed 105.
*/

public class M394_Decode_String {

	public static void main(String[] args) {
		String input = "3[a2[c]]";
        String output = decodeString(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Stack
    */
	
	/**
     * @param s: a string
     * @return: its decoded string
     */
	public static String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        resultStack.push(new StringBuilder());
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                counts.push(k);
                resultStack.push(new StringBuilder());
                k = 0;
            } else if (ch == ']') {
                StringBuilder temp = resultStack.pop();
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    resultStack.peek().append(temp);
                }
            } else {
                resultStack.peek().append(ch);
            }
        }

        return resultStack.pop().toString();
    }

}
