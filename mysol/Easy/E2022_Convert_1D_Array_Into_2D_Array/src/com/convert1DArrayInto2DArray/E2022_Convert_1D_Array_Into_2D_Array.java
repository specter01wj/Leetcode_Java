package com.convert1DArrayInto2DArray;
import java.util.*;

/*
You are given a 0-indexed 1-dimensional (1D) integer array original, 
and two integers, m and n. You are tasked with creating a 2-dimensional (2D) 
array with  m rows and n columns using all the elements from original.

The elements from indices 0 to n - 1 (inclusive) of original should form the first 
row of the constructed 2D array, the elements from indices n to 2 * n - 1 
(inclusive) should form the second row of the constructed 2D array, and so on.

Return an m x n 2D array constructed according to the above procedure, or an empty 
2D array if it is impossible.


Example 1:


Input: original = [1,2,3,4], m = 2, n = 2
Output: [[1,2],[3,4]]
Explanation: The constructed 2D array should contain 2 rows and 2 columns.
The first group of n=2 elements in original, [1,2], becomes the first row in the constructed 2D array.
The second group of n=2 elements in original, [3,4], becomes the second row in the constructed 2D array.

Example 2:

Input: original = [1,2,3], m = 1, n = 3
Output: [[1,2,3]]
Explanation: The constructed 2D array should contain 1 row and 3 columns.
Put all three elements in original into the first row of the constructed 2D array.

Example 3:

Input: original = [1,2], m = 1, n = 1
Output: []
Explanation: There are 2 elements in original.
It is impossible to fit 2 elements in a 1x1 2D array, so return an empty 2D array.
*/

public class E2022_Convert_1D_Array_Into_2D_Array {

	public static void main(String[] args) {
		int[] input = {1,2,3,4};
		int m = 2, n = 2;
		int[][] output = construct2DArray(input, m, n);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.deepToString(output));
	}
	
	/*
    solution:
    loop and reconstruct
    */
	
	/*
     * @param original: a list of integers
     * @param m: an integer
     * @param n: an integer
     * @return: an m x n 2D array constructed according to the above procedure, 
     * or an empty 2D array if it is impossible
     */
	public static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }
        int[][] ans = new int[m][n];
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                ans[r][c] = original[r * n + c];
            }
        }
        return ans;
    }

}
