package com.E367_Valid_Perfect_Square;

import java.util.*;

/*Given a positive integer num, write a function which returns True 
 * if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false*/

public class E367_Valid_Perfect_Square {

	public static void main(String[] args) {
		int input = 16;
        boolean output = isPerfectSquare(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    利用二分法求解。利用二分法找到一个最小的ans，满足ans的平方不小于num,
    然后判断ans的平方是否等于num即可
    */
	
	/*
     * @param num: a positive integer
     * @return: boolean, if num is a perfect square else False
     */
	

}
