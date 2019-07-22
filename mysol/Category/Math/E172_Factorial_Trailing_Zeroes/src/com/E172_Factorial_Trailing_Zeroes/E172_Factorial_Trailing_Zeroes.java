package com.E172_Factorial_Trailing_Zeroes;

import java.util.*;

/*Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.*/

public class E172_Factorial_Trailing_Zeroes {

	public static void main(String[] args) {
		int input = 15;
        int output = trailingZeroes(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    最终尾随零的数量之和质因子中2和5的数量有关，很容易想到质因子5的数量一定会比2少，
    所以只需要算出n!的质因子5的数量即可
	所以我们考虑1~n！之间5的倍数，25的倍数，125的倍数，625的倍数......的数量，即可算出答案
    */
	
	/*
     * @param n: an integer
     * @return: the number of trailing zeroes in n!
     */
	public static int trailingZeroes(int n) {
		if(n >= 5) {
			return (n / 5 + trailingZeroes(n / 5));
		} else {
			return 0;
		}
	}

}
