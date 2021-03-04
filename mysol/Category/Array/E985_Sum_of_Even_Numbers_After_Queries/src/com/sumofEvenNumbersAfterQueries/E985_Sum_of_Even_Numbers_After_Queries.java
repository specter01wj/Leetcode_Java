package com.sumofEvenNumbersAfterQueries;
import java.util.*;

/*We have an array A of integers, and an array queries of queries.

For the i-th query val = queries[i][0], index = queries[i][1], 
we add val to A[index].  Then, the answer to the i-th query is 
the sum of the even values of A.

(Here, the given index = queries[i][1] is a 0-based index, 
and each query permanently modifies the array A.)

Return the answer to all queries.  Your answer array should 
have answer[i] as the answer to the i-th query.

 

Example 1:

Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
Output: [8,6,2,4]
Explanation: 
At the beginning, the array is [1,2,3,4].
After adding 1 to A[0], the array is [2,2,3,4], 
and the sum of even values is 2 + 2 + 4 = 8.
After adding -3 to A[1], the array is [2,-1,3,4], 
and the sum of even values is 2 + 4 = 6.
After adding -4 to A[0], the array is [-2,-1,3,4], 
and the sum of even values is -2 + 4 = 2.
After adding 2 to A[3], the array is [-2,-1,3,6], 
and the sum of even values is -2 + 6 = 4.*/

public class E985_Sum_of_Even_Numbers_After_Queries {

	public static void main(String[] args) {
		int[] input = {1,2,3,4};
		int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        int[] output = sumEvenAfterQueries(input, queries);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    The points of interest are the peaks and valleys in the given graph. 
    We need to find the largest peak following the smallest valley. 
    We can maintain two variables - minprice and maxprofit corresponding 
    to the smallest valley and maximum profit (maximum difference between 
    selling price and minprice) obtained so far respectively.
    */
	
	/*
     * @param A: a list of integers
     * @param queries: a list of integers
     * @return: sum of even numbers
     */
	public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int sum = 0;
		
		for(int a : A) {
			sum += (a % 2 == 0 ? a : 0);
		}
		
		int[] ans = new int[queries.length];
		
		for(int i = 0; i < ans.length; i++) {
			int idx = queries[i][1];
			if(A[idx] % 2 == 0) {
				sum -= A[idx];
			}
			A[idx] += queries[i][0];
			if(A[idx] % 2 == 0) {
				sum += A[idx];
			}
			ans[i] = sum;
		}
		
		return ans;
	}

}
