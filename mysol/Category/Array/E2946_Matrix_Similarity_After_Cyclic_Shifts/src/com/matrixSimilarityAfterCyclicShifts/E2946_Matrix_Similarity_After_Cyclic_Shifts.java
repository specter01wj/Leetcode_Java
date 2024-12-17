package com.matrixSimilarityAfterCyclicShifts;
import java.util.*;

/*
You are given an m x n integer matrix mat and an integer k. 
The matrix rows are 0-indexed.

The following proccess happens k times:

	. Even-indexed rows (0, 2, 4, ...) are cyclically shifted to the left.
	. Odd-indexed rows (1, 3, 5, ...) are cyclically shifted to the right.

Return true if the final modified matrix after k steps is identical 
to the original matrix, and false otherwise.
*/

public class E2946_Matrix_Similarity_After_Cyclic_Shifts {

	public static void main(String[] args) {
		E2946_Matrix_Similarity_After_Cyclic_Shifts solution = new E2946_Matrix_Similarity_After_Cyclic_Shifts();
		int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
		int k = 4;
		boolean output = solution.areSimilar(input, k);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Normalization of k:
		. k is normalized to k % n because shifting n times results in the same row.
	2. Row Shifts:
		. For even-indexed rows: Use isShiftedLeft to check if the row matches after k left shifts.
		. For odd-indexed rows: Use isShiftedRight to check if the row matches after k right shifts.
	3. Shift Validation Methods:
		. isShiftedLeft: Checks if each element at index j matches the element at (j + k) % n.
		. isShiftedRight: Checks if each element at index j matches the element at (j - k + n) % n.
	4. Early Termination:
		. If any row doesn't match after the shifts, return false immediately.
	5. Return Result:
		. If all rows pass their respective checks, return true.
    */
	
	/*
     * @param mat: a list of 2D integers
     * @param k: an integer
     * @return: true if the final modified matrix after k steps is identical to the original matrix
     */
	public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;       // Number of rows
        int n = mat[0].length;    // Number of columns
        
        // Normalize k to avoid unnecessary full cycles
        k = k % n;
        
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) { 
                // Even-indexed rows: Shift left
                if (!isShiftedLeft(mat[i], k)) {
                    return false;
                }
            } else { 
                // Odd-indexed rows: Shift right
                if (!isShiftedRight(mat[i], k)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isShiftedLeft(int[] row, int k) {
        int n = row.length;
        for (int j = 0; j < n; j++) {
            // Check if the elements match after left shift
            if (row[j] != row[(j + k) % n]) {
                return false;
            }
        }
        return true;
    }

    private boolean isShiftedRight(int[] row, int k) {
        int n = row.length;
        for (int j = 0; j < n; j++) {
            // Check if the elements match after right shift
            if (row[j] != row[(j - k + n) % n]) {
                return false;
            }
        }
        return true;
    }

}
