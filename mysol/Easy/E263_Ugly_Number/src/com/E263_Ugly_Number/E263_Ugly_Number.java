package com.E263_Ugly_Number;

import java.util.*;

/*Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example 1:

Input: 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: 8
Output: true
Explanation: 8 = 2 × 2 × 2
Example 3:

Input: 14
Output: false 
Explanation: 14 is not ugly since it includes another prime factor 7.*/

public class E263_Ugly_Number {

	public static void main(String[] args) {
		int input = 8;
        boolean output = isUgly(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    看这个数是否只有2，3，5的因子
    */
	
	/*
     * @param num: an integer
     * @return: boolean, true if num is an ugly number or false
     */
	public static boolean isUgly(int num) {
		if(num <= 0) {
			return false;
		}
		if(num == 1) {
			return true;
		}
		
		while(num >= 2 && num % 2 == 0) {
			num /= 2;
		}
		while(num >= 3 && num % 3 == 0) {
			num /= 3;  
		}
        while(num >= 5 && num % 5 == 0) {
        		num /= 5;  
        }
        
        return num == 1;
	}

}
