package com.maximumDifferenceBetweenIncreasingElements;
import java.util.*;

/*
Given a 0-indexed integer array nums of size n, find the maximum difference 
between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n 
and nums[i] < nums[j].

Return the maximum difference. If no such i and j exists, return -1.


Example 1:

Input: nums = [7,1,5,4]
Output: 4
Explanation:
The maximum difference occurs with i = 1 and j = 2, nums[j] - nums[i] = 5 - 1 = 4.
Note that with i = 1 and j = 0, the difference nums[j] - nums[i] = 7 - 1 = 6, 
but i > j, so it is not valid.

Example 2:

Input: nums = [9,4,3,2]
Output: -1
Explanation:
There is no i and j such that i < j and nums[i] < nums[j].

Example 3:

Input: nums = [1,5,2,10]
Output: 9
Explanation:
The maximum difference occurs with i = 0 and j = 3, nums[j] - nums[i] = 10 - 1 = 9.
*/

public class E2016_Maximum_Difference_Between_Increasing_Elements {

	public static void main(String[] args) {
		int[] input = {7,1,5,4};
		int output = maximumDifference(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Traverse input, compare current number to the minimum of the previous ones, 
    then update the max difference.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the maximum difference. If no such i and j exists, return -1
     */
	public static int maximumDifference(int[] nums) {
        int diff = -1;
        for (int i = 1, min = nums[0]; i < nums.length; ++i) {
            if (nums[i] > min) {
                diff = Math.max(diff, nums[i] - min);
            }
            min = Math.min(min, nums[i]);
        }
        return diff;
    }

}
