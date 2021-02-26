package com.transposeMatrix;
import java.util.*;

/*Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, 
switching the matrix's row and column indices.



 

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]

Example 2:

Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]*/

public class E867_Transpose_Matrix {

	public static void main(String[] args) {
		int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] output = transpose(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + Arrays.deepToString(output));
	}
	
	public static int[][] transpose(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] res = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				res[i][j] = matrix[j][i];
			}
		}
		
		return res;
	}

}
