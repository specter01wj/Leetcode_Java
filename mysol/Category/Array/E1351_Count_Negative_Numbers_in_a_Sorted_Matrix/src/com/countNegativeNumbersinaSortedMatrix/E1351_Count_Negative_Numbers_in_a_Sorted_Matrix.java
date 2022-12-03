package com.countNegativeNumbersinaSortedMatrix;
import java.util.*;

/*
Given a m x n matrix grid which is sorted in non-increasing order both 
row-wise and column-wise, return the number of negative numbers in grid.


Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
*/

public class E1351_Count_Negative_Numbers_in_a_Sorted_Matrix {

	public static void main(String[] args) {
		int[][] input = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		int output = countNegatives(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    This solution uses the fact that the negative regions of the matrix will form a staircase shape.
    What this solution then does is to trace the outline of the staircase.
    */
	
	/*
     * @param grid: a list of 2D integers
     * @return: the number of negative numbers in grid
     */
	public static int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length, r = m - 1, c = 0, cnt = 0;
        while (r >= 0 && c < n) {
            if (grid[r][c] < 0) {
                --r;
                cnt += n - c;
            } else {
                ++c;
            }
        }
        return cnt;
    }

}
