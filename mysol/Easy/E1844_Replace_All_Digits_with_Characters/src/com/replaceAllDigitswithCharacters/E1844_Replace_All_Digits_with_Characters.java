package com.replaceAllDigitswithCharacters;
import java.util.*;

/*
You are given a 0-indexed string s that has lowercase English letters 
in its even indices and digits in its odd indices.

There is a function shift(c, x), where c is a character and x is a digit, 
that returns the xth character after c.

	.For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'.
	
For every odd index i, you want to replace the digit s[i] with shift(s[i-1], s[i]).

Return s after replacing all digits. It is guaranteed that shift(s[i-1], 
s[i]) will never exceed 'z'.


Example 1:

Input: s = "a1c1e1"
Output: "abcdef"
Explanation: The digits are replaced as follows:
- s[1] -> shift('a',1) = 'b'
- s[3] -> shift('c',1) = 'd'
- s[5] -> shift('e',1) = 'f'

Example 2:

Input: s = "a1b2c3d4e"
Output: "abbdcfdhe"
Explanation: The digits are replaced as follows:
- s[1] -> shift('a',1) = 'b'
- s[3] -> shift('b',2) = 'd'
- s[5] -> shift('c',3) = 'f'
- s[7] -> shift('d',4) = 'h'
*/

public class E1844_Replace_All_Digits_with_Characters {

	public static void main(String[] args) {
		String input = "a1b2c3d4e";
        String output = replaceDigits(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    s[i] - '0' change a character to integer.
	shift(c, x) is (char)(c + x) in java.
    */
	
	/**
     * @param s: a string
     * @return: s after replacing all digits
     */
	public static String replaceDigits(String s) {
        char[] res = s.toCharArray();
        for (int i = 1; i < s.length(); i += 2) {
            res[i] = (char)(res[i - 1] + res[i] - '0');
        }
        return String.valueOf(res);
    }

}
