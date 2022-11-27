package com.findNUniqueIntegersSumuptoZero;
import java.util.*;

/*
Given an integer n, return any array containing n unique integers such that they add up to 0.


Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

Example 2:

Input: n = 3
Output: [-1,0,1]

Example 3:

Input: n = 1
Output: [0]
*/

public class E1304_Find_N_Unique_Integers_Sum_up_to_Zero {

	public static void main(String[] args) {
		int input = 5;
		int[] output = sumZero(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    using 2 arrays
    */
	
	/*
     * @param n: an integer
     * @return: array containing n unique integers such that they add up to 0
     */
	public static int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = i * 2 - n + 1;
        }
        return res;
    }

}
