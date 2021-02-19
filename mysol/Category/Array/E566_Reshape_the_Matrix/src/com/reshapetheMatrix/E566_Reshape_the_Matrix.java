package com.reshapetheMatrix;
import java.util.*;

/*In MATLAB, there is a very useful function called 'reshape', 
which can reshape a matrix into a new one with different size 
but keep its original data.

You're given a matrix represented by a two-dimensional array, 
and two positive integers r and c representing the row number 
and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of 
the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, 
output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4
Output: 
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. 
The new reshaped matrix is a 1 * 4 matrix, 
fill it row by row by using the previous list.
Example 2:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 2, c = 4
Output: 
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. 
So output the original matrix.*/

public class E566_Reshape_the_Matrix {

	public static void main(String[] args) {
		int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};//{{1,2},{3,4}};
        int[][] output = matrixReshape(input, 2, 6);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + Arrays.deepToString(output));
	}
	
	/*
    solution:
    判断矩阵能否重置只需要判断原矩阵的行数*列数是否等于r*c即可。 重置过程在遍历原矩阵时即可完成。
    */
	/**
     * @param nums: List[List[int]]
     * @param r: an integer
     * @param c: an integer
     * @return: return List[List[int]]
     */
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		if(r * c != nums.length * nums[0].length) return nums;
		
		int[][] newNums = new int[r][c];
		int ir = 0, ic = 0;
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				newNums[ir][ic] = nums[i][j];
				ic++;
				if(ic == c) {
					ic = 0;
					ir++;
				}
			}
		}
		
		return newNums;
	}

}
