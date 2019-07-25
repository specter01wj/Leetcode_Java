package com.E191_Number_of_1_Bits;

import java.util.*;

/*Write a function that takes an unsigned integer and return the number 
 * of '1' bits it has (also known as the Hamming weight).

Example 1:

Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total 
of three '1' bits.

Example 2:

Input: 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total 
of one '1' bit.

Example 3:

Input: 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total 
of thirty one '1' bits.*/

public class E191_Number_of_1_Bits {

	public static void main(String[] args) {
		int input = 00000000000000000000000000001011;
        int output = hammingWeight(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    使用位运算符号‘&’，与1做与操作
	并将n右移一位( >>1 )
	直到n为0
    */
	
	/*
     * @param n: an unsigned integer
     * @return: the number of '1' bits
     */
	public static int hammingWeight(int n) {
		int ones = 0;
		
		while(n != 0) {
			ones += (n & 1);
			n = n >> 1;
		}
		
		return ones;
	}

}
