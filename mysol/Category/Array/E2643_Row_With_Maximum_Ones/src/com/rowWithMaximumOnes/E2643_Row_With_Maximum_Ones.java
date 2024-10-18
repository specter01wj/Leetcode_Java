package com.rowWithMaximumOnes;
import java.util.*;

/*
Given a m x n binary matrix mat, find the 0-indexed position of 
the row that contains the maximum count of ones, and the number 
of ones in that row.

In case there are multiple rows that have the maximum count of ones, 
the row with the smallest row number should be selected.

Return an array containing the index of the row, and the number of ones in it.
*/

public class E2643_Row_With_Maximum_Ones {

	public static void main(String[] args) {
		E2643_Row_With_Maximum_Ones solution = new E2643_Row_With_Maximum_Ones();
		int[][] input = {{0,0},{1,1},{0,0}};
		int[] output = solution.rowAndMaximumOnes(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOnes = 0; // Maximum number of ones in any row
        int rowIndex = -1; // Row index with maximum number of ones

        // Iterate through each row
        for (int i = 0; i < mat.length; i++) {
            int onesCount = 0;

            // Count the number of 1's in the current row
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    onesCount++;
                }
            }

            // Update the row with the maximum number of 1's
            if (onesCount > maxOnes) {
                maxOnes = onesCount;
                rowIndex = i;
            }
        }

        return new int[]{rowIndex, maxOnes};
    }

}
