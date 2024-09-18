package com.deleteGreatestValueinEachRow;
import java.util.*;

/*
You are given an m x n matrix grid consisting of positive integers.

Perform the following operation until grid becomes empty:

	. Delete the element with the greatest value from each row. 
		If multiple such elements exist, delete any of them.
	. Add the maximum of deleted elements to the answer.

Return the answer after performing the operations described above.
*/

public class E2500_Delete_Greatest_Value_in_Each_Row {

	public static void main(String[] args) {
		E2500_Delete_Greatest_Value_in_Each_Row solution = new E2500_Delete_Greatest_Value_in_Each_Row();
		int[][] input = {{1,2,4},{3,3,1}};
		int[][] inputCopy = new int[input.length][];
	    for (int i = 0; i < input.length; i++) {
	        inputCopy[i] = Arrays.copyOf(input[i], input[i].length);
	    }
		int output = solution.deleteGreatestValue(inputCopy);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Sort Each Row: Since we are required to delete the greatest value from 
    	each row in every operation, sorting each row in ascending order will 
    	help us easily access these values. After sorting, the largest values 
    	will be at the end of each row.
	2. Iterate Through Columns: We then iterate through each column from left 
		to right. At each column index k, we pick the element grid[i][k] from 
		each row i.	
	3. Find Maximum in Each Step: For each column k, we find the maximum value 
		among the selected elements from all rows. This maximum represents the 
		greatest value deleted in that operation.	
	4. Accumulate the Answer: We add the maximum value found in each step to 
		our answer.
	5. Return the Result: After iterating through all columns, we return the 
		accumulated answer.
    */
	
	/*
     * @param arr: a list of 2D integers
     * @return: the answer after performing the operations described above
     */
	public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }
        int ans = 0;
        for (int k = 0; k < n; k++) {
            int maxVal = 0;
            for (int i = 0; i < m; i++) {
                int val = grid[i][k];
                if (val > maxVal) {
                    maxVal = val;
                }
            }
            ans += maxVal;
        }
        return ans;
    }

}
