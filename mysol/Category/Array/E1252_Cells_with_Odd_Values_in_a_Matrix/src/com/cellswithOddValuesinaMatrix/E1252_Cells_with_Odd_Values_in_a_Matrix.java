package com.cellswithOddValuesinaMatrix;
import java.util.*;

/*
There is an m x n matrix that is initialized to all 0's. 
There is also a 2D array indices where each indices[i] = [ri, ci] 
represents a 0-indexed location to perform some increment operations on the matrix.

For each location indices[i], do both of the following:

1. Increment all the cells on row ri.
2. Increment all the cells on column ci.

Given m, n, and indices, return the number of odd-valued cells in the matrix 
after applying the increment to all locations in indices.


Example 1:

Input: m = 2, n = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.

Example 2:

Input: m = 2, n = 2, indices = [[1,1],[0,0]]
Output: 0
Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.
*/

public class E1252_Cells_with_Odd_Values_in_a_Matrix {

	public static void main(String[] args) {
		int[][] input = {{0,1},{1,1}};
		int output = oddCells(2, 3, input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int oddCells(int m, int n, int[][] indices) {
        boolean[] oddRows = new boolean[m], oddCols = new boolean[n];
        for (int[] idx : indices) {
            oddRows[idx[0]] ^= true; // if row idx[0] appears odd times, it will correspond to true.
            oddCols[idx[1]] ^= true; // if column idx[1] appears odd times, it will correspond to true.
        }
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                cnt += oddRows[i] ^ oddCols[j] ? 1 : 0; // only cell (i, j) with odd times count of row + column would get odd values.
            }
        }
        return cnt;
    }

}
