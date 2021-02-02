package com.climbingStairs;
import java.util.*;

/*You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways 
can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step*/

public class E70_Climbing_Stairs {

	public static void main(String[] args) {
		int input = 5;
		int output = climbStairs(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    考虑最后一步走1阶还是走2阶。 方案数Dpn = 最后一步走1阶的方案数 + 最后一步走2阶的方案数。 
    Dpn = Dpn-1 + Dpn-2.
    */
	
	/**
     * @param n: An integer
     * @return: An integer
     */
	public static int climbStairs(int n) {
		if(n <= 1) return n;
		
		int last1 = 1, last2 = 1;
		int now = 0;
		for(int i = 2; i <= n; i++) {
			now = last1 + last2;
			last2 = last1;
			last1 = now;
		}
		
		return now;
	}

}
