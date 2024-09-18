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
		int output = solution.deleteGreatestValue(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
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
