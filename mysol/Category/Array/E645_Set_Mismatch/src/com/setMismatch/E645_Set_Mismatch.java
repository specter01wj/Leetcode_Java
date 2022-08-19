package com.setMismatch;
import java.util.*;

/*
You have a set of integers s, which originally contains all the numbers 
from 1 to n. Unfortunately, due to some error, one of the numbers in s 
got duplicated to another number in the set, which results in 
repetition of one number and loss of another number.

You are given an integer array nums representing the data status of 
this set after the error.

Find the number that occurs twice and the number that is missing and 
return them in the form of an array.

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]

Example 2:

Input: nums = [1,1]
Output: [1,2]
*/

public class E645_Set_Mismatch {

	public static void main(String[] args) {
		int[] input = {1,2,2,4};
        int[] output = findErrorNums(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    设置一个vis数组，vis[i]用于标记数字i是否出现过。 被重复标记的即为重复的数，未被标记的即为缺失的数。
    */
	
	/**
     * @param nums: an array
     * @return: the number occurs twice and the number that is missing
     */
	public static int[] findErrorNums(int[] nums) {
		boolean[] vis = new boolean[nums.length + 1];
        int answer_repeat = 0, answer_missing = 0;
        for(int i = 0; i < nums.length; i++) {
            if (!vis[nums[i]]) {
                vis[nums[i]] = true;
            } else {
                answer_repeat = nums[i];
            }
        }
        for(int i = 1; i<=nums.length; i++) {
            if (!vis[i]) {
                answer_missing = i;
                break;
            }
        }
        
        return new int[] {answer_repeat, answer_missing};
	}

}
