package com.determineWhetherMatrixCanBeObtainedByRotation;
import java.util.*;

/*
Given two n x n binary matrices mat and target, return true if it is 
possible to make mat equal to target by rotating mat in 90-degree 
increments, or false otherwise.


Example 1:


Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.

Example 2:


Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
Output: false
Explanation: It is impossible to make mat equal to target by rotating mat.

Example 3:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
*/

public class E1886_Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation {

	public static void main(String[] args) {
		int[][] input = {{0,0,0},{0,1,0},{1,1,1}};
		int[][] target = {{1,1,1},{0,1,0},{0,0,0}};
		boolean output = findRotation(input, target);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. In order to rotate clockwise, first reverse rows order, then transpose the matrix;
	2. Rotate 0, 1, 2, 3 times and compare the rotated matrix with target, respectively.
    */
	
	/*
     * @param mat: a list of 2D integers
     * @param target: a list of 2D integers
     * @return: true if it is possible to make mat equal to target by rotating mat 
     * in 90-degree increments, or false otherwise
     */
	public static boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; ++i) {
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }
    private static void rotate(int[][] mat) {
        for (int i = 0, j = mat.length - 1; i < j; ++i, --j) {
            int[] tmp = mat[i];
            mat[i] = mat[j];
            mat[j] = tmp;
        } 
        for (int r = 0, R = mat.length; r < R; ++r) {
            for (int c = r + 1; c < R; ++c) {
                int tmp = mat[r][c];
                mat[r][c] = mat[c][r];
                mat[c][r] = tmp;
            }
        }
    }

}
