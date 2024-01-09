package com.numberofProvinces;
import java.util.*;

/*
There are n cities. Some of them are connected, while some are not. 
If city a is connected directly with city b, and city b is connected 
directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and 
no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 
if the ith city and the jth city are directly connected, and 
isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
*/

public class M547_Number_of_Provinces {

	public static void main(String[] args) {
		int[][] input = {{1,1,0},{1,1,0},{0,0,1}};
		int output = findCircleNum(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    DFS
    */
	
	/*
     * @param isConnected: a 2D list of integers
     * @return: the total number of provinces
     */
	public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length]; // Track visited cities
        int count = 0; // Count of provinces

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i); // Perform DFS for unvisited city
                count++; // Each DFS call indicates a new province
            }
        }

        return count;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true; // Mark city as visited
                dfs(isConnected, visited, j); // DFS for connected cities
            }
        }
    }

}
