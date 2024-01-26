package com.dominoandTrominoTiling;
import java.util.*;

/*
You have two types of tiles: a 2 x 1 domino shape and a tromino shape. 
You may rotate these shapes.

Given an integer n, return the number of ways to tile an 2 x n board. 
Since the answer may be very large, return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are 
different if and only if there are two 4-directionally adjacent cells 
on the board such that exactly one of the tilings has both squares 
occupied by a tile.
*/

public class M790_Domino_and_Tromino_Tiling {

	public static void main(String[] args) {
		int input = 3;
		int output = numTilings(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Dynamic Programming
    */
	
	/*
     * @param n: an integer
     * @return: the number of ways to tile an 2 x n board
     */
	private static final int MOD = 1000000007;
    
    public static int numTilings(int n) {
        if (n <= 2) return n;
        
        long[] dp = new long[n + 1];
        dp[0] = 1; // base case for an empty board
        dp[1] = 1; // only one way to tile a 2x1 board
        dp[2] = 2; // two ways to tile a 2x2 board

        for (int i = 3; i <= n; i++) {
            // dp[i] is the sum of:
            // - the number of ways to tile a 2x(i-1) board and then adding a domino vertically
            // - the number of ways to tile a 2x(i-2) board and then adding two dominos horizontally
            // - the number of ways to tile a 2x(i-2) board and then adding a tromino plus a single square in two different configurations
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }

        return (int) dp[n];
    }

}
