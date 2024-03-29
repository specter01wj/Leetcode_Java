package com.checkifMatrixIsXMatrix;
import java.util.*;

/*
A square matrix is said to be an X-Matrix if both of the following conditions hold:

1. All the elements in the diagonals of the matrix are non-zero.
2. All other elements are 0.

Given a 2D integer array grid of size n x n representing a square matrix, 
return true if grid is an X-Matrix. Otherwise, return false.


Example 1:

Input: grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
Output: true
Explanation: Refer to the diagram above. 
An X-Matrix should have the green elements (diagonals) be non-zero and the red elements be 0.
Thus, grid is an X-Matrix.


Example 2:

Input: grid = [[5,7,0],[0,3,1],[0,5,0]]
Output: false
Explanation: Refer to the diagram above.
An X-Matrix should have the green elements (diagonals) be non-zero and the red elements be 0.
Thus, grid is not an X-Matrix.
*/

public class E2319_Check_if_Matrix_Is_XMatrix {

	public static void main(String[] args) {
		int[][] input = {{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};
		boolean output = checkXMatrix(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    double loop and check
    */
	
	/*
     * @param grid: a 2D list of integers
     * @return: true if grid is an X-Matrix. Otherwise, return false
     */
	public static boolean checkXMatrix(int[][] grid) {
		int n = grid.length;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || i + j == n - 1) {
					// For diagonal elements
					if (grid[i][j] == 0) {
						return false;
					}
				} else {
					// For non-diagonal elements
					if (grid[i][j] != 0) {
						return false;
					}
				}
			}
		}
		
		return true;
	}

}
