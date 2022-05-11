package com.islandPerimeter;
import java.util.*;

/*You are given row x col grid representing a map where grid[i][j] = 1 
 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). 
The grid is completely surrounded by water, and there is exactly 
one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't 
connected to the water around the island. One cell is a square 
with side length 1. The grid is rectangular, width and height 
don't exceed 100. Determine the perimeter of the island.


Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
Example 2:

Input: grid = [[1]]
Output: 4
Example 3:

Input: grid = [[1,0]]
Output: 4*/

public class E463_Island_Perimeter {

	public static void main(String[] args) {
		int[][] input = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int output = islandPerimeter(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public static int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		int []dx  = {1, 0, -1, 0};
	    int []dy  = {0, 1, 0, -1};
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						if(valid(i + dx[k], j + dy[k], grid)) {
							perimeter++;
						}
					}
				}
			}
		}
		
		return perimeter;
	}
	
	private static boolean valid(int x, int y, int[][] grid) {
        if(0 <= x && x < grid.length && 0 <= y && y < grid[x].length) {
            return grid[x][y] == 0;
        }
        
        return true;
    } 

}
