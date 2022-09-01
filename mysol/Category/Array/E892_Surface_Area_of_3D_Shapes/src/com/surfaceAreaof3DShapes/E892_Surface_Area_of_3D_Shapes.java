package com.surfaceAreaof3DShapes;
import java.util.*;

/*
You are given an n x n grid where you have placed some 1 x 1 x 1 cubes. 
Each value v = grid[i][j] represents a tower of v cubes placed on top of 
cell (i, j).

After placing these cubes, you have decided to glue any directly adjacent 
cubes to each other, forming several irregular 3D shapes.

Return the total surface area of the resulting shapes.

Note: The bottom face of each shape counts toward its surface area.


Example 1:


Input: grid = [[1,2],[3,4]]
Output: 34

Example 2:


Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
Output: 32

Example 3:


Input: grid = [[2,2,2],[2,1,2],[2,2,2]]
Output: 46
*/

public class E892_Surface_Area_of_3D_Shapes {

	public static void main(String[] args) {
		int[][] input = {{1,2},{3,4}};
        int output = surfaceArea(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	public static int surfaceArea(int[][] grid) {
		int length = grid.length;
		int surface1 = 0;
		int surface2 = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (grid[i][j] != 0) {
					surface1 += grid[i][j] * 4 + 2;
				}
				if (i != length - 1) {
					surface2 += (grid[i][j] > grid[i + 1][j] ? grid[i + 1][j] : grid[i][j]) * 2;
					surface2 += (grid[j][i] > grid[j][i + 1] ? grid[j][i + 1] : grid[j][i]) * 2;
				}
			}
		}
		return surface1 - surface2;
	}

}
