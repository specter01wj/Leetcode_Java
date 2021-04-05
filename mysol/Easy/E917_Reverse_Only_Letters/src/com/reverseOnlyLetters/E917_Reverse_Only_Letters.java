package com.reverseOnlyLetters;
import java.util.*;

/*Given a string S, return the "reversed" string where all characters 
that are not a letter stay in the same place, and all letters reverse 
their positions.

		 

Example 1:

Input: "ab-cd"
Output: "dc-ba"

Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"*/

public class E917_Reverse_Only_Letters {

	public static void main(String[] args) {
		String input = "Test1ng-Leet=code-Q!";
        String output = reverseOnlyLetters(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    头部和尾部设置双指针遇到两个字母时，进行交换。
    Two pointers,
	from the begin and the of the string.
	find two letters and swap them.
    */
	
	/**
     * @param S: Customary string
     * @return: Reversed string
     */
	public static String reverseOnlyLetters(String S) {
		int l = 0, r = S.length() - 1;
		StringBuilder strBuilder = new StringBuilder(S);
		
		while(l < r) {
			if(!(S.charAt(l) >= 'A' && S.charAt(l) <= 'Z' || 
					S.charAt(l) >= 'a' && S.charAt(l) <= 'z')) {
				++l;
				continue;
			}
			if(!(S.charAt(r) >= 'A' && S.charAt(r) <= 'Z' || 
					S.charAt(r) >= 'a' && S.charAt(r) <= 'z')) {
				--r;
				continue;
			}
			
			char tmp = S.charAt(l);
			strBuilder.setCharAt(l++, S.charAt(r));
			strBuilder.setCharAt(r--, tmp);
		}
		
		return strBuilder.toString();
	}

}
