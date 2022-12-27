package com.kthMissingPositiveNumber;
import java.util.*;

/*
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.


Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. 
The 5th missing positive integer is 9.

Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. 
The 2nd missing positive integer is 6.
*/

public class E1539_Kth_Missing_Positive_Number {

	public static void main(String[] args) {
		int[] input = {2,3,4,7,11};
		int k = 5;
		int output = findKthPositive(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Assume the final result is x,
	And there are m number not missing in the range of [1, x].
	Binary search the m in range [0, A.size()].
	
	If there are m number not missing,
	that is A[0], A[1] .. A[m-1],
	the number of missing under A[m] is A[m] - 1 - m.
	
	If A[m] - 1 - m < k, m is too small, we update left = m.
	If A[m] - 1 - m >= k, m is big enough, we update right = m.
	
	Note that, we exit the while loop, l = r,
	which equals to the number of missing number used.
	So the Kth positive number will be l + k.
    */
	
	/*
     * @param prices: a list of integers
     * @return: an integer array answer where answer[i] is the final price
     */
	public static int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length, m;
        while (l < r) {
            m = (l + r) / 2;
            if (arr[m] - 1 - m < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l + k;
    }

}
