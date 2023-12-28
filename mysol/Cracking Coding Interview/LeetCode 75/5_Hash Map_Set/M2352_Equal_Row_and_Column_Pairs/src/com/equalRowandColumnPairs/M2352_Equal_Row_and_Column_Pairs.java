package com.equalRowandColumnPairs;
import java.util.*;

/*
Given a 0-indexed n x n integer matrix grid, return the number of 
pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same 
elements in the same order (i.e., an equal array).
*/

public class M2352_Equal_Row_and_Column_Pairs {

	public static void main(String[] args) {
		int[][] input = {{3,2,1},{1,7,6},{2,7,7}};
		int output = equalPairs(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public static int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int r = 0;
                while (r < n && grid[row][r] == grid[r][col]) {
                    r++;
                }
                if (r == n) {
                    count++;
                }
            }
        }

        return count;
    }

}
