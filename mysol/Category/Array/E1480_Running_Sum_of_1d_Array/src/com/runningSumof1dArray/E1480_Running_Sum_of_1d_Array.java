package com.runningSumof1dArray;
import java.util.*;

/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.


Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

Example 2:

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

Example 3:

Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]
*/

public class E1480_Running_Sum_of_1d_Array {

	public static void main(String[] args) {
		int[] input = {1,2,3,4};
		int[] output = runningSum(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    Loop once, we can get the sum of subarray starting from the initial point.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the running sum of nums
     */
	public static int[] runningSum(int[] input) {
		int[] nums = input.clone();
        int i = 1;
        while (i < nums.length){
            nums[i] += nums[i-1];
            i++;
        }
        return nums;
    }

}
