package com.checkifGridSatisfiesConditions;
import java.util.*;

/*
You are given a 2D matrix grid of size m x n. You need to check if each cell grid[i][j] is:

	. Equal to the cell below it, i.e. grid[i][j] == grid[i + 1][j] (if it exists).
	. Different from the cell to its right, i.e. grid[i][j] != grid[i][j + 1] (if it exists).

Return true if all the cells satisfy these conditions, otherwise, return false.
*/

public class E3142_Check_if_Grid_Satisfies_Conditions {

	public static void main(String[] args) {
		E3142_Check_if_Grid_Satisfies_Conditions solution = new E3142_Check_if_Grid_Satisfies_Conditions();
		int[][] input = {{1,0,2},{1,0,2}};
		boolean output = solution.satisfiesConditions(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Iterate through each cell (i, j) in the grid.
	2. If the cell has a row below (i < m - 1), check if grid[i][j] == grid[i + 1][j]. If not, return false.
	3. If the cell has a right neighbor (j < n - 1), check if grid[i][j] != grid[i][j + 1]. If not, return false.
	4. If all cells satisfy the conditions, return true.
    */
	
	/*
     * @param int[][] grid: a list of 2D integers
     * @return: the number of good triplets
     */
	public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check if grid[i][j] is equal to the cell below it
                if (i < m - 1 && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
                // Check if grid[i][j] is different from the cell to its right
                if (j < n - 1 && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }

}
