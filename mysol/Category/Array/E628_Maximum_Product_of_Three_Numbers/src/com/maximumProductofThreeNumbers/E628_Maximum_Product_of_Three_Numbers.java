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
	
	public static int maximumProduct(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		return Math.max(nums[0]*nums[1]*nums[n-1], nums[n-3]*nums[n-2]*nums[n-1]);
	}

}
