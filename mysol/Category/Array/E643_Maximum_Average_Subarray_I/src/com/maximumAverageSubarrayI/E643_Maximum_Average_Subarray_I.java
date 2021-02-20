package com.maximumAverageSubarrayI;
import java.util.*;

/*Given an array consisting of n integers, find the contiguous subarray 
of given length k that has the maximum average value. And you need to 
output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75*/

public class E643_Maximum_Average_Subarray_I {

	public static void main(String[] args) {
		int[] input = {1,12,-5,-6,50,3};
        double output = findMaxAverage(input, 4);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    先算一个初始 k 的平均值，之后 for 循环找最大值（减去第一位加上最后一位）
    */
	
	/**
     * @param nums: an array
     * @param k: an integer
     * @return: the maximum average value
     */
	public static double findMaxAverage(int[] nums, int k) {
		int sum = 0;
		for(int i = 0; i < k; i++) {
			sum += nums[i];
		}
		int max = sum;
		
		for(int i = k; i < nums.length; i++) {
			sum = sum - nums[i - k] + nums[i];
			max = Math.max(max, sum);
		}
		
		return (double) max / k;
	}

}
