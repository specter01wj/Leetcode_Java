package com.uniquePaths;
import java.util.*;

/*
There is a robot on an m x n grid. The robot is initially located 
at the top-left corner (i.e., grid[0][0]). 
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique 
paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or 
equal to 2 * 109.
*/

public class M62_Unique_Paths {

	public static void main(String[] args) {
		int m = 3, n = 7;
		int output = uniquePaths(m, n);
        System.out.println("input: " + (m) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Dynamic Programming
    */
	
	/*
     * @param m: an integer
     * @param n: an integer
     * @return: the number of possible unique paths
     */
	public static int uniquePaths(int m, int n) {
        // Create a 2D array for dynamic programming
        int[][] dp = new int[m][n];

        // Initialize the first row and first column to 1, 
        // since there is only one way to reach any cell in the first row or column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the rest of the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The number of ways to get to the current cell is the sum of ways 
                // to get to the cell directly above and the cell to the left
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // The bottom-right corner will have the total number of unique paths
        return dp[m - 1][n - 1];
    }

}
