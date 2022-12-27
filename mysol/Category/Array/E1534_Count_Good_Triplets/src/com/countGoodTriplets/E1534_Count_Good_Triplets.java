package com.countGoodTriplets;
import java.util.*;

/*
Given an array of integers arr, and three integers a, b and c. 
You need to find the number of good triplets.

A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:

	.0 <= i < j < k < arr.length
	.|arr[i] - arr[j]| <= a
	.|arr[j] - arr[k]| <= b
	.|arr[i] - arr[k]| <= c
Where |x| denotes the absolute value of x.

Return the number of good triplets.


Example 1:

Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
Output: 4
Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].

Example 2:

Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
Output: 0
Explanation: No triplet satisfies all conditions.
*/

public class E1534_Count_Good_Triplets {

	public static void main(String[] args) {
		int[] input = {3,0,1,1,9,7};
		int output = countGoodTriplets(input, 7, 2, 3);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    count good triplets
    */
	
	/*
     * @param arr: a list of integers
     * @param a: an integer
     * @param b: an integer
     * @param c: an integer
     * @return: the number of good triplets
     */
	public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;
        for(int i = 0; i < n -2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c)
                        count++;
                }
            }
        }
        return count;
    }

}
