package com.sumofAllOddLengthSubarrays;
import java.util.*;

/*
Given an array of positive integers arr, return the sum of all possible 
odd-length subarrays of arr.

A subarray is a contiguous subsequence of the array.


Example 1:

Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

Example 2:

Input: arr = [1,2]
Output: 3
Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.

Example 3:

Input: arr = [10,11,12]
Output: 66
*/

public class E1588_Sum_of_All_Odd_Length_Subarrays {

	public static void main(String[] args) {
		int[] input = {1,4,2,5,3};
		int output = sumOddLengthSubarrays(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Consider the subarray that contains A[i],
	we can take 0,1,2..,i elements on the left,
	from A[0] to A[i],
	we have i + 1 choices.
	
	we can take 0,1,2..,n-1-i elements on the right,
	from A[i] to A[n-1],
	we have n - i choices.
	
	In total, there are k = (i + 1) * (n - i) subarrays, that contains A[i].
	And there are (k + 1) / 2 subarrays with odd length, that contains A[i].
	And there are k / 2 subarrays with even length, that contains A[i].
	
	A[i] will be counted ((i + 1) * (n - i) + 1) / 2 times for our question.
    */
	
	/*
     * @param arr: a list of integers
     * @return: the sum of all possible odd-length subarrays of arr
     */
	public static int sumOddLengthSubarrays(int[] arr) {
        int res = 0, n = arr.length;
        for (int i = 0; i < n; ++i) {
            res += ((i + 1) * (n - i) + 1) / 2 * arr[i];
        }
        return res;
    }

}
