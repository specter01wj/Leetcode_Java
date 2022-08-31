package com.projectionAreaof3DShapes;
import java.util.*;

/*
You are given an n x n grid where we place some 1 x 1 x 1 cubes that 
are axis-aligned with the x, y, and z axes.

Each value v = grid[i][j] represents a tower of v cubes placed on top 
of the cell (i, j).

We view the projection of these cubes onto the xy, yz, and zx planes.

A projection is like a shadow, that maps our 3-dimensional figure to 
a 2-dimensional plane. We are viewing the "shadow" when looking at 
the cubes from the top, the front, and the side.

Return the total area of all three projections.


Example 1:


Input: grid = [[1,2],[3,4]]
Output: 17
Explanation: Here are the three projections ("shadows") of the shape 
made with each axis-aligned plane.

Example 2:

Input: grid = [[2]]
Output: 5

Example 3:

Input: grid = [[1,0],[0,2]]
Output: 8
*/

public class E883_Projection_Area_of_3D_Shapes {

	public static void main(String[] args) {
		int[][] input = {{1,2},{3,4}};
        int output = projectionArea(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    front-back projection area on xz = sum(max value for every col)
	right-left projection area on yz = sum(max value for every row)
	top-down projection area on xy = sum(1 for every v > 0)
    */
	
	/**
     * @param grid: a List[List[int]]
     * @return: return a integer number
     */
	public static int projectionArea(int[][] grid) {
		int res = 0, n = grid.length;
        for (int i = 0; i < n; ++i) {
            int x = 0, y = 0;
            for (int j = 0; j < n; ++j) {
                x = Math.max(x, grid[i][j]);
                y = Math.max(y, grid[j][i]);
                if (grid[i][j] > 0) ++res;
            }
            res += x + y;
        }
        
        return res;
	}

}
