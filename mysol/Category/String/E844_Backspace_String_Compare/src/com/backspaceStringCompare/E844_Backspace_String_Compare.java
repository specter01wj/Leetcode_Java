package com.backspaceStringCompare;
import java.util.*;

/*
Given two strings s and t, return true if they are equal when 
both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.


Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
*/

public class E844_Backspace_String_Compare {

	public static void main(String[] args) {
		String input1 = "ab#c";
		String input2 = "ad#c";
        boolean output = backspaceCompare(input1, input2);
        System.out.println("input1: " + (input1) + "; input2: " + input2 + "\noutput: " + (output));
	}
	
	/*
    solution:
    利用set即可。
    */
	
	/**
     * @param s: an array of char
     * @param t: an array of char
     * @return: boolean whether they are equal
     */
	public static boolean backspaceCompare(String s, String t) {
		int i = s.length() - 1, j = t.length() - 1, back;
		
        while (true) {
            back = 0;
            
            while (i >= 0 && (back > 0 || s.charAt(i) == '#')) {
                back += s.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            
            back = 0;
            
            while (j >= 0 && (back > 0 || t.charAt(j) == '#')) {
                back += t.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            
            if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        
        return i == -1 && j == -1;
	}

}
