package com.designNeighborSumService;
import java.util.*;

/*
You are given a n x n 2D array grid containing distinct elements 
in the range [0, n2 - 1].

Implement the NeighborSum class:

	. NeighborSum(int [][]grid) initializes the object.
	. int adjacentSum(int value) returns the sum of elements which 
		are adjacent neighbors of value, that is either to the top, 
		left, right, or bottom of value in grid.
	. int diagonalSum(int value) returns the sum of elements which 
		are diagonal neighbors of value, that is either to the 
		top-left, top-right, bottom-left, or bottom-right of value in grid.
*/

public class E3242_Design_Neighbor_Sum_Service {

	public static void main(String[] args) {
		E3242_Design_Neighbor_Sum_Service solution = new E3242_Design_Neighbor_Sum_Service();
		int[][] grid = {
	            {0, 1, 2},
	            {3, 4, 5},
	            {6, 7, 8}
	        };

	        NeighborSum obj = solution.new NeighborSum(grid);

	        int adj1 = obj.adjacentSum(1);
	        int adj4 = obj.adjacentSum(4);
	        int diag4 = obj.diagonalSum(4);
	        int diag8 = obj.diagonalSum(8);

	        System.out.println("Input Grid: " + Arrays.deepToString(grid));
	        System.out.println("adjacentSum(1) = " + adj1); // Expected: 6
	        System.out.println("adjacentSum(4) = " + adj4); // Expected: 16
	        System.out.println("diagonalSum(4) = " + diag4); // Expected: 16
	        System.out.println("diagonalSum(8) = " + diag8); // Expected: 4
	}
	
	
	class NeighborSum {
	    private int[][] grid;
	    private int n;
	    private Map<Integer, int[]> valueToPosition;

	    public NeighborSum(int[][] grid) {
	        this.grid = grid;
	        this.n = grid.length;
	        this.valueToPosition = new HashMap<>();
	        
	        // Store value positions in the map
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                valueToPosition.put(grid[i][j], new int[]{i, j});
	            }
	        }
	    }
	    
	    public int adjacentSum(int value) {
	        if (!valueToPosition.containsKey(value)) return 0;
	        int[] pos = valueToPosition.get(value);
	        int i = pos[0], j = pos[1];
	        int sum = 0;
	        
	        // Adjacent neighbors (top, bottom, left, right)
	        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	        for (int[] dir : directions) {
	            int ni = i + dir[0], nj = j + dir[1];
	            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
	                sum += grid[ni][nj];
	            }
	        }
	        
	        return sum;
	    }
	    
	    public int diagonalSum(int value) {
	        if (!valueToPosition.containsKey(value)) return 0;
	        int[] pos = valueToPosition.get(value);
	        int i = pos[0], j = pos[1];
	        int sum = 0;
	        
	        // Diagonal neighbors (top-left, top-right, bottom-left, bottom-right)
	        int[][] directions = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	        for (int[] dir : directions) {
	            int ni = i + dir[0], nj = j + dir[1];
	            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
	                sum += grid[ni][nj];
	            }
	        }
	        
	        return sum;
	    }
	}

	/**
	 * Your NeighborSum object will be instantiated and called as such:
	 * NeighborSum obj = new NeighborSum(grid);
	 * int param_1 = obj.adjacentSum(value);
	 * int param_2 = obj.diagonalSum(value);
	 */

}
