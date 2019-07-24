package com.E371_Sum_of_Two_Integers;

import java.util.*;

/*Calculate the sum of two integers a and b, 
 * but you are not allowed to use the operator + and -.

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = -2, b = 3
Output: 1*/

public class E371_Sum_of_Two_Integers {

	public static void main(String[] args) {
		int input1 = 11, input2 = 3;
        int output = getSum(input1, input2);
        System.out.println("input1: " + (input1) + " / input2: " + (input2) + "\noutput: " + (output));
	}
	
	/*
    solution:
    
    */
	
	/*
     * @param a: an integer
     * @param b: an integer
     * @return: sum of two integers a and b
     */
	public static int getSum(int a, int b) {
		if(a == 0) return b;
		if(b == 0) return a;
		
		while(b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
	}

}
