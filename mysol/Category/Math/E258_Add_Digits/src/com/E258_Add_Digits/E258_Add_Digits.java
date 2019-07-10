package com.E258_Add_Digits;

import java.util.*;

/*Given a non-negative integer num, repeatedly add all its digits until the result 
 * has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?*/

public class E258_Add_Digits {

	public static void main(String[] args) {
		int input = 3832;
        int output = addDigits(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    反复相加，直到最后小于10,退出循环
    */
	
	/*
     * @param num: a non-negative integer
     * @return: one digit
     */
	public static int addDigits(int num) {
		while(num >= 10) {
			int sum = 0;
			while(num > 0) {
				sum += num % 10;
				num /= 10;
			}
			num = sum;
		}
		
		return num;
	}

}
