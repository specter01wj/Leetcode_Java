package com.findtheWidthofColumnsofaGrid;
import java.util.*;

/*
You are given a 0-indexed m x n integer matrix grid. 
The width of a column is the maximum length of its integers.

	. For example, if grid = [[-10], [3], [12]], the width of the only 
		column is 3 since -10 is of length 3.

Return an integer array ans of size n where ans[i] is the width of the ith column.

The length of an integer x with len digits is equal to len if x is non-negative, 
and len + 1 otherwise.
*/

public class E2639_Find_the_Width_of_Columns_of_a_Grid {

	public static void main(String[] args) {
		E2639_Find_the_Width_of_Columns_of_a_Grid solution = new E2639_Find_the_Width_of_Columns_of_a_Grid();
		int[][] input = {{1},{22},{333}};
		int[] output = solution.findColumnWidth(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;    // Number of rows
        int n = grid[0].length; // Number of columns
        int[] ans = new int[n]; // To store the width of each column

        // Iterate through each column
        for (int col = 0; col < n; col++) {
            int maxWidth = 0; // To store the maximum width of the current column

            // Iterate through each row of the current column
            for (int row = 0; row < m; row++) {
                // Convert the integer to a string to find its length
                int len = String.valueOf(grid[row][col]).length();
                maxWidth = Math.max(maxWidth, len); // Update the max width for this column
            }

            ans[col] = maxWidth; // Store the max width for the current column
        }

        return ans; // Return the widths of all columns
    }

}
