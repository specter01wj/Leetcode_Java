package com.modifytheMatrix;
import java.util.*;

/*
Given a 0-indexed m x n integer matrix matrix, create a new 
0-indexed matrix called answer. Make answer equal to matrix, 
then replace each element with the value -1 with the maximum 
element in its respective column.

Return the matrix answer.
*/

public class E3033_Modify_the_Matrix {

	public static void main(String[] args) {
		E3033_Modify_the_Matrix solution = new E3033_Modify_the_Matrix();
		int[][] input = {{1,2,-1},{4,-1,6},{7,8,9}};
		int[][] output = solution.modifiedMatrix(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + Arrays.deepToString(output));
	}
	
	/*
    solution:
    1. Determine Maximum in Each Column:
		. Iterate through each column and find the maximum value in that column, storing it in an array maxInColumn.
	2. Replace -1 Values:
		. Traverse the matrix again, and whenever a -1 is encountered, replace it with the maximum value of its column from maxInColumn.
	3. Return Result:
		. Construct and return the modified answer matrix.
    */
	
	/*
     * @param matrix: a list of 2D integers
     * @return: the matrix answer
     */
	public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Step 1: Create an array to store the maximum value of each column
        int[] maxInColumn = new int[n];

        // Step 2: Initialize maxInColumn with minimum values
        for (int j = 0; j < n; j++) {
            maxInColumn[j] = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                maxInColumn[j] = Math.max(maxInColumn[j], matrix[i][j]);
            }
        }

        // Step 3: Create the answer matrix by replacing -1 values
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    answer[i][j] = maxInColumn[j];
                } else {
                    answer[i][j] = matrix[i][j];
                }
            }
        }

        return answer;
    }

}
