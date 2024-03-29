package com.matrixCellsinDistanceOrder;
import java.util.*;

/*
You are given four integers row, cols, rCenter, and cCenter. 
There is a rows x cols matrix and you are on the cell with the 
coordinates (rCenter, cCenter).

Return the coordinates of all cells in the matrix, sorted by 
their distance from (rCenter, cCenter) from the smallest distance 
to the largest distance. You may return the answer in any order 
that satisfies this condition.

The distance between two cells (r1, c1) and (r2, c2) is |r1 - r2| + |c1 - c2|.


Example 1:

Input: rows = 1, cols = 2, rCenter = 0, cCenter = 0
Output: [[0,0],[0,1]]
Explanation: The distances from (0, 0) to other cells are: [0,1]

Example 2:

Input: rows = 2, cols = 2, rCenter = 0, cCenter = 1
Output: [[0,1],[0,0],[1,1],[1,0]]
Explanation: The distances from (0, 1) to other cells are: [0,1,1,2]
The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.

Example 3:

Input: rows = 2, cols = 3, rCenter = 1, cCenter = 2
Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
Explanation: The distances from (1, 2) to other cells are: [0,1,1,2,2,3]
There are other answers that would also be accepted as correct, 
such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
*/

public class E1030_Matrix_Cells_in_Distance_Order {

	public static void main(String[] args) {
		int rows = 2, cols = 2, rCenter = 0, cCenter = 1;
		int[][] output = allCellsDistOrder(rows, cols, rCenter, cCenter);
        System.out.println("rows: " + (rows) + " cols: " + (cols) + 
        		" rCenter: " + (rCenter) + " cCenter: " + (cCenter) + "\noutput: " + Arrays.deepToString(output));
	}
	
	/*
    solution:
    The max distance is R + C, and the result array's length is R * C. 
    Since the distance is limited (generally, compared with the cell count), 
    we can use Counting Sort to solve it efficiently.
    */
	
	/*
     * @param rows: an integer
     * @param cols: an integer
     * @param rCenter: an integer
     * @param cCenter: an integer
     * @return: the coordinates of all cells in the matrix
     */
	public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[] counter = new int[rows + cols + 1];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int dist = Math.abs(r - rCenter) + Math.abs(c - cCenter);
                counter[dist + 1] += 1;
            }
        }
        
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }
        
        int[][] ans = new int[rows * cols][];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int dist = Math.abs(r - rCenter) + Math.abs(c - cCenter);
                ans[counter[dist]] = new int[] { r, c };
                counter[dist]++;
            }
        }
        
        return ans;
    }

}
