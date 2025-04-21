package com.zigzagGridTraversalWithSkip;
import java.util.*;

/*
You are given an m x n 2D array grid of positive integers.

Your task is to traverse grid in a zigzag pattern while skipping every alternate cell.

Zigzag pattern traversal is defined as following the below actions:

	. Start at the top-left cell (0, 0).
	. Move right within a row until the end of the row is reached.
	. Drop down to the next row, then traverse left until the beginning of the row is reached.
	. Continue alternating between right and left traversal until every row has been traversed.

Note that you must skip every alternate cell during the traversal.

Return an array of integers result containing, in order, the value of the cells 
visited during the zigzag traversal with skips.
*/

public class E3417_Zigzag_Grid_Traversal_With_Skip {

	public static void main(String[] args) {
		E3417_Zigzag_Grid_Traversal_With_Skip solution = new E3417_Zigzag_Grid_Traversal_With_Skip();
		int[][] input = {{1,2},{3,4}};
		List<Integer> output = solution.zigzagTraversal(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Initialize Lists:
		. traversal: temporarily stores all visited values in strict zigzag order (no skipping yet).
		. result: final output list that includes only every second element from traversal.
	2. Iterate Over Rows:
		. Loop through each row index i from 0 to rows - 1.
	3. Zigzag Direction Check:
		. If i is even, traverse left to right: use inner loop from j = 0 to j < cols.
		. If i is odd, traverse right to left: use inner loop from j = cols - 1 down to j >= 0.
	4. Collect Zigzag Order:
		. For each cell visited in step 3, append grid[i][j] to the traversal list.
		. At this point, the list contains a complete zigzag walk through the grid.
	5. Skip Alternate Cells:
		. Iterate over traversal with step size 2 (i.e., index 0, 2, 4, ...) to select every other value.
		. Append only these selected values to the final result.
	6. Return Result:
		. Return the result list containing values from the zigzag traversal, with every second value skipped globally.
    */
	
	/*
     * @param grid: a list of 2D integers
     * @return: an array of integers result
     */
	public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> traversal = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: Traverse the grid in zigzag order and store all cells
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                // left to right
                for (int j = 0; j < cols; j++) {
                    traversal.add(grid[i][j]);
                }
            } else {
                // right to left
                for (int j = cols - 1; j >= 0; j--) {
                    traversal.add(grid[i][j]);
                }
            }
        }

        // Step 2: Skip every alternate cell
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < traversal.size(); i += 2) {
            result.add(traversal.get(i));
        }

        return result;
    }

}
