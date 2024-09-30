package com.countDistinctNumbersonBoard;
import java.util.*;

/*
You are given a positive integer n, that is initially placed on a board. 
Every day, for 109 days, you perform the following procedure:

	. For each number x present on the board, find all numbers 1 <= i <= n such 
		that x % i == 1.
	. Then, place those numbers on the board.

Return the number of distinct integers present on the board after 109 days 
have elapsed.

Example 1:

Input: n = 5
Output: 4
Explanation: Initially, 5 is present on the board. 
The next day, 2 and 4 will be added since 5 % 2 == 1 and 5 % 4 == 1. 
After that day, 3 will be added to the board because 4 % 3 == 1. 
At the end of a billion days, the distinct numbers on the board will be 2, 3, 4, and 5. 

Example 2:

Input: n = 3
Output: 2
Explanation: 
Since 3 % 2 == 1, 2 will be added to the board. 
After a billion days, the only two distinct numbers on the board are 2 and 3.
*/

public class E2549_Count_Distinct_Numbers_on_Board {

	public static void main(String[] args) {
		E2549_Count_Distinct_Numbers_on_Board solution = new E2549_Count_Distinct_Numbers_on_Board();
		int input = 5;
		int output = solution.distinctIntegers(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. The problem can be solved by recognizing that after performing the procedure, 
    	all numbers from 2 to n will eventually appear on the board.
	2. If n == 1, the only number on the board is 1, so the result is 1.
	3. For any n > 1, all numbers from 2 to n will eventually be added to the board, 
		so the distinct numbers on the board will be n - 1.
    */
	
	/*
     * @param n: an integer
     * @return: the number of distinct integers present on the board after 109 days have elapsed
     */
	public int distinctIntegers(int n) {
        // If n is 1, then only 1 remains on the board
        if (n == 1) {
            return 1;
        }
        
        // For any n > 1, the result is always n - 1 distinct integers
        return n - 1;
    }

}
