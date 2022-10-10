package com.partitionArrayIntoThreePartsWithEqualSum;
import java.util.*;

/*
Given an array of integers arr, return true if we can partition 
the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes 
i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + 
arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + 
arr[arr.length - 1])


Example 1:

Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1

Example 2:

Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false

Example 3:

Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
*/

public class E1013_Partition_Array_Into_Three_Parts_With_Equal_Sum {

	public static void main(String[] args) {
		int[] input = {0,2,1,-6,6,-7,9,1,2,0,1};
//		int[] input = {0,2,1,-6,6,7,9,-1,2,0,1};
		boolean output = canThreePartsEqualSum(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Method: Count valid parts
	1. Loop through the array A, and compute part of sum; 
	   if the average value is found, reset the part to 0, 
	   and increase the counter;
	2. By the end if the average can be seen for at least 
	   3 times and if the total sum is divisible by 3, return true; 
	   otherwise return false.
    */
	
	/**
     * @param arr: an array
     * @return: true if we can partition the array into three non-empty parts with equal sums
     */
	public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum(), part = 0, average = sum / 3, cnt = 0;
        for (int a : arr) {
            part += a;
            if (part == average) { // find the average: sum / 3
                ++cnt; // find an average, increase the counter.
                part = 0; // reset part.
            }
        }
        return cnt >= 3 && sum % 3 == 0;
    }

}
