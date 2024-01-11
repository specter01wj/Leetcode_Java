package com.rottingOranges;
import java.util.*;

/*
You are given an m x n grid where each cell can have one of three values:

 .0 representing an empty cell,
 .1 representing a fresh orange, or
 .2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a 
rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell 
has a fresh orange. If this is impossible, return -1.
*/

public class M994_Rotting_Oranges {

	public static void main(String[] args) {
		int[][] input = {{2,1,1},{1,1,0},{0,1,1}};
		int output = orangesRotting(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Initialize the queue with all rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0; // No fresh oranges to start with

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 4-directional

        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] dir : directions) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1) {
                        continue;
                    }

                    grid[x][y] = 2; // Rot the fresh orange
                    queue.offer(new int[]{x, y});
                    freshCount--; // Decrease the count of fresh oranges
                }
            }
            minutes++; // One minute has passed
        }

        return freshCount == 0 ? minutes : -1;
    }

}
