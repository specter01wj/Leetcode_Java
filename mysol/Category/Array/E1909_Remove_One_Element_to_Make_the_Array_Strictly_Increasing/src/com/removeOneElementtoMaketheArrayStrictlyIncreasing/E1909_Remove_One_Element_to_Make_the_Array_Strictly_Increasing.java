package com.removeOneElementtoMaketheArrayStrictlyIncreasing;
import java.util.*;

/*
Given a 0-indexed integer array nums, return true if it can be made strictly 
increasing after removing exactly one element, or false otherwise. 
If the array is already strictly increasing, return true.

The array nums is strictly increasing if nums[i - 1] < nums[i] for each 
index (1 <= i < nums.length).


Example 1:

Input: nums = [1,2,10,5,7]
Output: true
Explanation: By removing 10 at index 2 from nums, it becomes [1,2,5,7].
[1,2,5,7] is strictly increasing, so return true.

Example 2:

Input: nums = [2,3,1,2]
Output: false
Explanation:
[3,1,2] is the result of removing the element at index 0.
[2,1,2] is the result of removing the element at index 1.
[2,3,2] is the result of removing the element at index 2.
[2,3,1] is the result of removing the element at index 3.
No resulting array is strictly increasing, so return false.

Example 3:

Input: nums = [1,1,1]
Output: false
Explanation: The result of removing any element is [1,1].
[1,1] is not strictly increasing, so return false.
*/

public class E1909_Remove_One_Element_to_Make_the_Array_Strictly_Increasing {

	public static void main(String[] args) {
		int[] input = {1,2,10,5,7};
		boolean output = canBeIncreasing(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static boolean canBeIncreasing(int[] nums) {
        for (int i = 1, dips = 0, previous = nums[0]; i < nums.length; i++) {
            if (nums[i] <= previous) {
                if (++dips == 2) {
                    return false;
                }
                if (i == 1 || nums[i] > nums[i - 2]) {
                    previous = nums[i];
                }
            } else {
                previous = nums[i];
            }
        }
	    return true;
    }

}
