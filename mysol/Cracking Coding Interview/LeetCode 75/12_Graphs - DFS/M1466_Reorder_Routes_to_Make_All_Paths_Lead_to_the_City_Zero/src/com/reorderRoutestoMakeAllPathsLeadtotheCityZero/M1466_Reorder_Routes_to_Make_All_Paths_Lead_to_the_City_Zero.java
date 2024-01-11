package com.reorderRoutestoMakeAllPathsLeadtotheCityZero;
import java.util.*;

/*
There are n cities numbered from 0 to n - 1 and n - 1 roads such 
that there is only one way to travel between two different cities 
(this network form a tree). Last year, The ministry of transport 
decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] 
represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many 
people want to travel to this city.

Your task consists of reorienting some roads such that each city can 
visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.
*/

public class M1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {

	public static void main(String[] args) {
		int n = 6;
        int[][] input = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int output = minReorder(n, input);
        System.out.println("input1: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public static int minReorder(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        
        for(int i = 0; i < n; ++i) {
            al.add(new ArrayList<>());
        }

        for (var c : connections) {
            al.get(c[0]).add(c[1]);
            al.get(c[1]).add(-c[0]);
        }

        return dfs(al, new boolean[n], 0);
    }

    private static int dfs(List<List<Integer>> al, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;

        for (var to : al.get(from)) {
            if (!visited[Math.abs(to)]) {
                change += dfs(al, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }

        return change;  
    }

}
