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
    Track sum of all even #s.
	There are 4 cases for odd / even property of A[k] and queries[i][0], where k = queries[i][1]:
	1). even and odd, lose an even item in A; sum need to deduct A[k];
	2). even and even, get a bigger even item in A; sum need to add queries[i][0](same as deduct A[k] first then add both);
	3). odd and odd, get a bigger even item in A; sum need to add both;
	4). odd and even, no influence on even items in A;
	
	Therefore, we can simplify the above as following procedure:
	
	find sum of all even #s;
	for each queries, check the item in A and after-added-up value, if
	a) the item in A is even, deduct it from sum; according to 1) & 2).
	b) after-added-up we have an even value, then add the new value to sum; according to 2) & 3).
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
