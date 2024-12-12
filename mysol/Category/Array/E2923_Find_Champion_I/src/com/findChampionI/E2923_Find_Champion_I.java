package com.findChampionI;
import java.util.*;

/*
There are n teams numbered from 0 to n - 1 in a tournament.

Given a 0-indexed 2D boolean matrix grid of size n * n. For all i, j 
that 0 <= i, j <= n - 1 and i != j team i is stronger than team j if 
grid[i][j] == 1, otherwise, team j is stronger than team i.

Team a will be the champion of the tournament if there is no team b 
that is stronger than team a.

Return the team that will be the champion of the tournament.
*/

public class E2923_Find_Champion_I {

	public static void main(String[] args) {
		E2923_Find_Champion_I solution = new E2923_Find_Champion_I();
		int[][] input = {{0,0,1},{1,0,1},{0,0,0}};
		int output = solution.findChampion(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public int findChampion(int[][] grid) {
        int n = grid.length;

        // Start with the assumption that team 0 is the champion
        int champion = 0;

        // Iterate through all teams to find a potential champion
        for (int i = 1; i < n; i++) {
            if (grid[champion][i] == 0) {
                // If the current champion loses to team i, update champion
                champion = i;
            }
        }

        // Verify if the identified champion is actually the champion
        for (int i = 0; i < n; i++) {
            if (i != champion && (grid[champion][i] == 0 || grid[i][champion] == 1)) {
                // If the champion loses to or fails to beat another team, return -1
                return -1;
            }
        }

        return champion;
    }

}
