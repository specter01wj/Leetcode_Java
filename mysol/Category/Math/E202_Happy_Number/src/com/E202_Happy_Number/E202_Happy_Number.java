package com.E202_Happy_Number;

import java.util.*;

/*Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of 
the squares of its digits, and repeat the process until the number equals 1 
(where it will stay), or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1*/

public class E202_Happy_Number {

	public static void main(String[] args) {
		int input = 19;
        boolean output = isHappy(input);
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
	public static boolean isHappy(int n) {
		HashSet<Integer> hash = new HashSet<Integer>();
		
		while(n != 1) {
			if(hash.contains(n)) {
				return false;
			}
			hash.add(n);
			n = getNextHappy(n);
		}
		
		return true;
	}
	
	private static int getNextHappy(int n) {
		int sum = 0;
		while(n != 0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}

}
