package com.rangeAdditionII;
import java.util.*;

/*
You are given an m x n matrix M initialized with all 0's 
and an array of operations ops, where ops[i] = [ai, bi] 
means M[x][y] should be incremented by one for all 
0 <= x < ai and 0 <= y < bi.

Count and return the number of maximum integers 
in the matrix after performing all the operations.


Example 1:

Input: m = 3, n = 3, ops = [[2,2],[3,3]]
Output: 4
Explanation: The maximum integer in M is 2, 
and there are four of it in M. So return 4.

Example 2:

Input: m = 3, n = 3, 
ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],
[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
Output: 4

Example 3:

Input: m = 3, n = 3, ops = []
Output: 9
*/

public class E598_Range_Addition_II {

	public static void main(String[] args) {
		int[][] input = {{2,2},{3,3}};
        int output = maxCount(3,3,input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    对于任意两个操作[a1,b1],[a2,b2],其所能涵盖的面积的交集为[min(a1,a2),min(b1,b2)]。
    因此我们只需要求出所有操作的min_m和min_n即可。
    */
	
	/**
     * @param m: an integer
     * @param n: an integer
     * @param ops: List[List[int]]
     * @return: return an integer
     */
	public static int maxCount(int m, int n, int[][] ops) {
		int res_m = m, res_n = n;
        for (int i = 0; i < ops.length; ++i) {
            res_m = Math.min(res_m, ops[i][0]);
            res_n = Math.min(res_n, ops[i][1]);
        }
        return res_n * res_m;
	}

}
