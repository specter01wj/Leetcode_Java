package com.makeTwoArraysEqualbyReversingSubarrays;
import java.util.*;

/*
You are given two integer arrays of equal length target and arr. 
In one step, you can select any non-empty subarray of arr and reverse it. 
You are allowed to make any number of steps.

Return true if you can make arr equal to target or false otherwise.


Example 1:

Input: target = [1,2,3,4], arr = [2,4,1,3]
Output: true
Explanation: You can follow the next steps to convert arr to target:
1- Reverse subarray [2,4,1], arr becomes [1,4,2,3]
2- Reverse subarray [4,2], arr becomes [1,2,4,3]
3- Reverse subarray [4,3], arr becomes [1,2,3,4]
There are multiple ways to convert arr to target, this is not the only way to do so.

Example 2:

Input: target = [7], arr = [7]
Output: true
Explanation: arr is equal to target without any reverses.

Example 3:

Input: target = [3,7,9], arr = [3,7,11]
Output: false
Explanation: arr does not have value 9 and it can never be converted to target.
*/

public class E1460_Make_Two_Arrays_Equal_by_Reversing_Subarrays {

	public static void main(String[] args) {
		int[] target = {1,2,3,4}, arr = {2,4,1,3};
		boolean output = canBeEqual(target, arr);
        System.out.println("input: " + Arrays.toString(target) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Count the arrays and compare.
    */
	
	/*
     * @param target: a list of integers
     * @param arr: a list of integers
     * @return: true if you can make arr equal to target or false otherwise
     */
	public static boolean canBeEqual(int[] target, int[] arr) {
        int[] cnt = new int[1001];
        for (int t : target) {
            ++cnt[t];
        }
        for (int a : arr) {
            if (--cnt[a] < 0) {
                return false;
            }
        }
        return true;
    }

}
