package com.maxConsecOnes;
import java.util.*;

/*Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000*/

public class E485_Max_Consecutive_Ones {

	public static void main(String[] args) {
		int[] input = {1,1,0,1,1,1};
        int output = findMaxConsecutiveOnes(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
	solution:
	动态规划思想。 同时记录count和result，若当前数为1，count加一，若count此时大于result，
	将result更新为count。若不为1，重置连续数count为0。
	*/
	
	/**
	 * @param {number[]} nums
	 * @return {number}
	 */
	public static int findMaxConsecutiveOnes(int[] nums) {
		int result = 0, count = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 1) {
				count++;
				result = Math.max(count,  result);
			} else {
				count = 0;
			}
		}
		
		return result;
	}

}
