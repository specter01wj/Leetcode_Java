package com.rangeSumQueryImmutable;
import java.util.*;

/*
Given an integer array nums, handle multiple queries of the following type:

1. Calculate the sum of the elements of nums between indices left and right 
inclusive where left <= right.

Implement the NumArray class:

	. NumArray(int[] nums) Initializes the object with the integer array nums.
	. int sumRange(int left, int right) Returns the sum of the elements of nums 
	between indices left and right inclusive 
	(i.e. nums[left] + nums[left + 1] + ... + nums[right]).
*/

public class E303_Range_Sum_Query_Immutable {

	public static void main(String[] args) {
		int[] input = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(input);

        int result1 = numArray.sumRange(0, 2); // Expected 1
        int result2 = numArray.sumRange(2, 5); // Expected -1
        int result3 = numArray.sumRange(0, 5); // Expected -3

        System.out.println("input: " + Arrays.toString(input));
        System.out.println("sumRange(0, 2) -> " + result1);
        System.out.println("sumRange(2, 5) -> " + result2);
        System.out.println("sumRange(0, 5) -> " + result3);
	}
	
	/*
    solution:
    Prefix sum
    */
	
	/*
     * @param nums: a list of integers
     * @return: the sum of the elements
     */
	static class NumArray {
	    private final int[] pre;

	    public NumArray(int[] nums) {
	        pre = new int[nums.length + 1];
	        for (int i = 0; i < nums.length; i++) {
	            pre[i + 1] = pre[i] + nums[i];
	        }
	    }
	    
	    public int sumRange(int left, int right) {
	        return pre[right + 1] - pre[left];
	    }
	}

}
