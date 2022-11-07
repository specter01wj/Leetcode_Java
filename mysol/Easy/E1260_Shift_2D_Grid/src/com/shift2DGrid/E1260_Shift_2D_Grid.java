package com.shift2DGrid;
import java.util.*;

/*
Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:
. Element at grid[i][j] moves to grid[i][j + 1].
. Element at grid[i][n - 1] moves to grid[i + 1][0].
. Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.


Example 1:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]

Example 2:

Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]

Example 3:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]
*/

public class E1260_Shift_2D_Grid {

	public static void main(String[] args) {
		int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
		int k = 1;
		List<List<Integer>> output = shiftGrid(input, k);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. filling all the rows of result with empty lists
    2. every rows*col shifts grid became the same, skipping the similar shifts
    3. element at (begin) will be at 0,0 in new grid
    4. counter variable
    5. calculating row and cell for new grid
    6. adding new element in new row
    7. returning result list
    */
	
	/*
     * @param grid: a list of 2D integer
     * @param k: an integer
     * @return: the 2D grid after applying shift operation k times
     */
	public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList();
        int rows = grid.length, col = grid[0].length;

        for (int r = 0; r < rows; r++) {
            result.add(new ArrayList());
        }
        k %= (rows * col);
        int dimension = rows * col;
        int begin = dimension - k;
        int x = 0;
        for (int i = begin; i < begin + dimension; i++) {
            int r = (i / col) % rows, c = i % col;
            result.get(x / col).add(grid[r][c]);
            x++;
        }
        return result;
    }

}
