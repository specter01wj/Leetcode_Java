package com.toeplitzMatrix;
import java.util.*;

/*Given an m x n matrix, return true if the matrix is Toeplitz. 
Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right 
has the same elements.

 

Example 1:


Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: true
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.

Example 2:


Input: matrix = [[1,2],[2,2]]
Output: false
Explanation:
The diagonal "[1, 2]" has different elements.*/

public class E766_Toeplitz_Matrix {

	public static void main(String[] args) {
		int[][] input = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        boolean output = isToeplitzMatrix(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    按照题意枚举每条对角线。即每个数和它右下方的数必须相同。
    */
	
	/**
     * @param matrix: the given matrix
     * @return: True if and only if the matrix is Toeplitz
     */
	public static boolean isToeplitzMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length - 1; i++) {
			for(int j = 0; j < matrix[i].length - 1; j++) {
				if(matrix[i][j] != matrix[i + 1][j + 1]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
