package com.minimumOperationstoMakeColumnsStrictlyIncreasing;
import java.util.*;

/*
You are given a m x n matrix grid consisting of non-negative integers.

In one operation, you can increment the value of any grid[i][j] by 1.

Return the minimum number of operations needed to make all columns of 
grid strictly increasing.
*/

public class E3402_Minimum_Operations_to_Make_Columns_Strictly_Increasing {

	public static void main(String[] args) {
		E3402_Minimum_Operations_to_Make_Columns_Strictly_Increasing solution = new E3402_Minimum_Operations_to_Make_Columns_Strictly_Increasing();
		int[][] input = {{3,2},{1,3},{3,4},{0,1}};
		int output = solution.minimumOperations(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Traverse each column from top to bottom.
	2. Compare each cell grid[row][col] with the value just above it grid[row-1][col].
	3. If the current cell is not strictly greater, compute the difference needed to make it greater:
		grid[row-1][col] + 1 - grid[row][col].
	4. Add this difference to the operations counter and update the current cell.
    */
	
	/*
     * @param grid: a list of 2D integers
     * @return: the minimum number of operations
     */
	public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int operations = 0;

        for (int col = 0; col < n; col++) {
            for (int row = 1; row < m; row++) {
                // if current value is not strictly greater than the previous row
                if (grid[row][col] <= grid[row - 1][col]) {
                    int increment = grid[row - 1][col] + 1 - grid[row][col];
                    operations += increment;
                    grid[row][col] += increment; // update current cell to be strictly increasing
                }
            }
        }

        return operations;
    }

}
