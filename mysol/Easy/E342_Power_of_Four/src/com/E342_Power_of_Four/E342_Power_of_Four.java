package com.E342_Power_of_Four;

import java.util.*;

/*Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false*/

public class E342_Power_of_Four {

	public static void main(String[] args) {
		int input = 4096;
        boolean output = isPowerOfFour(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    使用位运算的性质
    */
	
	/*
     * @param num: an integer
     * @return: boolean, whether the integer is a power of 4
     */
	public static boolean isPowerOfFour(int num) {
        if (num < 1){
            return false;
        }
        if ((num & (num - 1)) != 0){
            return false;
        }
        while (num > 1) {
            num = num >>2;
        }
        if (num == 1){
            return true;
        }
        return false;
    }

}
