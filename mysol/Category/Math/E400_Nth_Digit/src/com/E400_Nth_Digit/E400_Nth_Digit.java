package com.E400_Nth_Digit;

import java.util.*;

/*Find the nth digit of the infinite integer sequence 
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, 
which is part of the number 10.*/

public class E400_Nth_Digit {

	public static void main(String[] args) {
		int input = 11;
        int output = findNthDigit(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    The points of interest are the peaks and valleys in the given graph. 
    We need to find the largest peak following the smallest valley. 
    We can maintain two variables - minprice and maxprofit corresponding 
    to the smallest valley and maximum profit (maximum difference between 
    selling price and minprice) obtained so far respectively.
    */
	
	/*
     * @param prices: a list of integers
     * @return: find a maximum profit
     */
	public static int findNthDigit(int n) {
        // 初始化一位数的整数有9个，从1开始
        int len = 1;
        long count = 9;
        int start = 1;
        
        while (n > len * count) {
            // 以此类推，二位数的整数有90个，从10开始
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }
    	// 找到第n位数在整数start中
        start += (n - 1) / len;
        String s = Integer.toString(start);
        // 取出对应位置的整数值
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

}
