package com.findMissingandRepeatedValues;
import java.util.*;

/*
You are given a 0-indexed 2D integer matrix grid of size n * n with values 
in the range [1, n2]. Each integer appears exactly once except a which 
appears twice and b which is missing. 
The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a 
and ans[1] equals to b.
*/

public class E2965_Find_Missing_and_Repeated_Values {

	public static void main(String[] args) {
		E2965_Find_Missing_and_Repeated_Values solution = new E2965_Find_Missing_and_Repeated_Values();
		int[][] input = {{9,1,7},{8,9,2},{3,4,6}};
		int[] output = solution.findMissingAndRepeatedValues(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int nSquared = n * n;

        // Create a frequency array to track occurrences of each number.
        int[] frequency = new int[nSquared + 1];

        // Count the occurrences of each number in the grid.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                frequency[grid[i][j]]++;
            }
        }

        int repeated = -1;
        int missing = -1;

        // Find the repeated and missing numbers.
        for (int i = 1; i <= nSquared; i++) {
            if (frequency[i] == 2) {
                repeated = i;
            } else if (frequency[i] == 0) {
                missing = i;
            }

            // If both values are found, break early.
            if (repeated != -1 && missing != -1) {
                break;
            }
        }

        // Return the result as a 0-indexed array.
        return new int[]{repeated, missing};
    }

}
