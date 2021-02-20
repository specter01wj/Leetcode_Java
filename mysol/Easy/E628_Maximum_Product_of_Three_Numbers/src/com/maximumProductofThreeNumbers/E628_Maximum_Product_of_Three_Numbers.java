package com.maximumProductofThreeNumbers;
import java.util.*;

/*Given an integer array nums, find three numbers whose product is 
maximum and return the maximum product.

		 

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6*/

public class E628_Maximum_Product_of_Three_Numbers {

	public static void main(String[] args) {
		int[] input = {7,11,-2,6,9,10};//{1,2,3,4};
        int output = maximumProduct(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    我们将数组从小到大排序后， 
    1、假设数组元素全为负数或只有一个负数或全为正数，此时将数组中最大的三个元素相乘即为最大乘积； 
    2、假设只有一个正数或两个正数，此时将数组的前两个负数与最后一个正数相乘即为最大乘积； 
    3、假设正数多于三个且负数多于两个，则最大乘积应为前两个负数与最后一个正数的乘积与最大的
    三个元素的乘积中的最大值。
    */
	
	/**
     * @param nums: an integer array
     * @return: the maximum product
     */
	public static int maximumProduct(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		return Math.max(nums[0]*nums[1]*nums[n-1], nums[n-3]*nums[n-2]*nums[n-1]);
	}

}
