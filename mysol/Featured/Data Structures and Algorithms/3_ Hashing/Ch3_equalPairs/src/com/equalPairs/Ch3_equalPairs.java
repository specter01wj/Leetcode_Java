package com.equalPairs;
import java.util.*;

/*
Given a 0-indexed n x n integer matrix grid, return the number of 
pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same 
elements in the same order (i.e., an equal array).
*/

public class Ch3_equalPairs {

	public static void main(String[] args) {
		Ch3_equalPairs solution = new Ch3_equalPairs();
		int[][] input = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
		int output = solution.equalPairs(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();

        // Serialize each row and count frequency
        for (int[] row : grid) {
            String key = Arrays.toString(row);
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }

        int count = 0;

        // Serialize each column and compare with rows
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = grid[i][j];
            }
            String key = Arrays.toString(col);
            count += rowMap.getOrDefault(key, 0);
        }

        return count;
    }

}
