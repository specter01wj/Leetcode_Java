package com.checkifArrayIsSortedandRotated;
import java.util.*;

/*
Given an array nums, return true if the array was originally sorted in 
non-decreasing order, then rotated some number of positions (including zero). 
Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length 
such that A[i] == B[(i+x) % A.length], where % is the modulo operation.


Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].

Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.

Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
*/

public class E1752_Check_if_Array_Is_Sorted_and_Rotated {

	public static void main(String[] args) {
		int[] input = {3,4,5,1,2};
		boolean output = check(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Compare all neignbour elements (a,b) in A,
	the case of a > b can happen at most once.
	
	Note that the first element and the last element are also connected.
	
	If all a <= b, A is already sorted.
	If all a <= b but only one a > b,
	we can rotate and make b the first element.
	Other case, return false.
    */
	
	/*
     * @param nums: a list of integers
     * @return: true if the array was originally sorted in non-decreasing order, 
     * then rotated some number of positions
     */
	public static boolean check(int[] nums) {
       int k = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > nums[(i + 1) % n]) {
                k++;
            }
            if (k > 1) {
                return false;
            }
        }
        return true; 
    }

}
