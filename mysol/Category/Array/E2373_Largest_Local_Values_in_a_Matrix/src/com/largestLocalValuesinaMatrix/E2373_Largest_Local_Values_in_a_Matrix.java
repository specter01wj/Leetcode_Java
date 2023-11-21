package com.largestLocalValuesinaMatrix;
import java.util.*;

/*
You are given an n x n integer matrix grid.

Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:

. maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid 
  centered around row i + 1 and column j + 1.

In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.

Return the generated matrix.
*/

public class E2373_Largest_Local_Values_in_a_Matrix {

	public static void main(String[] args) {
		int[][] input = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
		int[][] output = largestLocal(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + Arrays.deepToString(output));
	}
	
	
	public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];

        // Iterate over each cell of the maxLocal matrix
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxLocal[i][j] = getMaxValue(grid, i, j);
            }
        }

        return maxLocal;
    }

    // Helper function to find the maximum value in a 3x3 matrix centered at (i+1, j+1)
    private static int getMaxValue(int[][] grid, int row, int col) {
        int maxVal = Integer.MIN_VALUE;

        // Iterate over the 3x3 matrix
        for (int i = row; i <= row + 2; i++) {
            for (int j = col; j <= col + 2; j++) {
                maxVal = Math.max(maxVal, grid[i][j]);
            }
        }

        return maxVal;
    }

}
