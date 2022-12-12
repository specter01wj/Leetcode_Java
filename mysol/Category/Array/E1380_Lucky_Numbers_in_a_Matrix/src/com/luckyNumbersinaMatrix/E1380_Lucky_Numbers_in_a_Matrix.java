package com.luckyNumbersinaMatrix;
import java.util.*;

/*
Given an m x n matrix of distinct numbers, 
return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element 
in its row and maximum in its column.


Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row 
and the maximum in its column.

Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row 
and the maximum in its column.

Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row 
and the maximum in its column.
*/

public class E1380_Lucky_Numbers_in_a_Matrix {

	public static void main(String[] args) {
		int[][] input = {{3,7,8},{9,11,13},{15,16,17}};
		List<Integer> output = luckyNumbers(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Find minimum and maxmium values for each row and each column, respectively;
	2. Since all numbers in the matrix are distinct, only when the row minimum equals 
	to the column maximum, it is a lucky number by the problem definition.
    */
	
	/*
     * @param matrix: a list of 2D integers
     * @return: all lucky numbers in the matrix in any order
     */
	public static List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] mi = new int[m], mx = new int[n];
        Arrays.fill(mi, Integer.MAX_VALUE);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                mi[i] = Math.min(matrix[i][j], mi[i]);
                mx[j] = Math.max(matrix[i][j], mx[j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mi[i] == mx[j])  {
                    res.add(mi[i]);
                    break;
                }
            }
        }
        return res; 
    }

}
