package com.E190_Reverse_Bits;

import java.util.*;

/*Reverse bits of a given 32 bits unsigned integer.

Example 1:

Input: 00000010100101000001111010011100
Output: 00111001011110000010100101000000
Explanation: The input binary string 00000010100101000001111010011100 represents 
the unsigned integer 43261596, so return 964176192 which its binary representation 
is 00111001011110000010100101000000.

Example 2:

Input: 11111111111111111111111111111101
Output: 10111111111111111111111111111111
Explanation: The input binary string 11111111111111111111111111111101 represents 
the unsigned integer 4294967293, so return 3221225471 which its binary representation 
is 10101111110010110010011101101001.*/

public class E190_Reverse_Bits {

	public static void main(String[] args) {
		int input = 00000000000000000000000000001010;
        int output = reverseBits(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    分离出输入数字的每一位，最低位左移31bit，次低位左移30bit，以此类推。
    */
	
	/*
     * @param n: an unsigned integer
     * @return: reverse bits of a given 32 bits unsigned integer
     */
	public static int reverseBits(int n) {
		int reversed = 0;
		
		for(int i = 0; i < 32; i++) {
			reversed = (reversed << 1) | (n & 1);
			n = (n >> 1);
		}
		
		return reversed;
	}

}
