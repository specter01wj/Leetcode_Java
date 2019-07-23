package com.E136_Single_Number;

import java.util.*;

/*Given a non-empty array of integers, every element appears twice except for one. 
 * Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it 
without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4*/

public class E136_Single_Number {

	public static void main(String[] args) {
		int[] input = {1,4,2,1,2};
        int output = singleNumber(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    异或运算具有很好的性质，相同数字异或运算后为0，并且具有交换律和结合律，
    故将所有数字异或运算后即可得到只出现一次的数字。
    */
	
	/*
     * @param nums: a list of integers
     * @return: integer, find the single one
     */
	public static int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int rst = 0;
        
        for (int i = 0; i < nums.length; i++) {
            rst ^= nums[i];
        }
        
        return rst;
    }

}
