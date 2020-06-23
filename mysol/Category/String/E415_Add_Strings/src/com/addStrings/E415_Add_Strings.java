package com.addStrings;

import java.util.*;

/*Given two non-negative integers num1 and num2 represented as string, 
return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs 
to integer directly.*/

public class E415_Add_Strings {

	public static void main(String[] args) {
		String input1 = "152", input2 = "91";
        String output = addStrings(input1, input2);
        System.out.println("input1: " + (input1) + " / input2: " + (input2) + 
        		"\noutput: " + (output));
	}
	
	public static String addStrings(String num1, String num2) {
		String res = "";
		int m = num1.length(), n = num2.length(), i = m - 1, j = n - 1, flag = 0;
		
		while(i >= 0 || j >= 0) {
			int a, b;
			if(i >= 0) {
				a = num1.charAt(i--) - '0';
			} else {
				a = 0;
			}
			
			if(j >= 0) {
				b = num2.charAt(j--) - '0';
			} else {
				b = 0;
			}
			
			int sum = a + b + flag;
			res = (char)(sum % 10 + '0') + res;
			flag = sum / 10;
		}
		
		return flag == 1 ? "1" + res : res;
	}

}
