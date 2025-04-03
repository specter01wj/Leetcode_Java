package com.minimumTotalOperations;
import java.util.*;

/*
Given an array of integers nums, you can perform any number of 
operations on this array.

In each operation, you can:

	. Choose a prefix of the array.
	. Choose an integer k (which can be negative) and add k to each element in the chosen prefix.

A prefix of an array is a subarray that starts from the beginning of 
the array and extends to any point within it.

Return the minimum number of operations required to make all elements in arr equal.
*/

public class E3353_Minimum_Total_Operations {
	
	public static void main(String[] args) {
		E3353_Minimum_Total_Operations solution = new E3353_Minimum_Total_Operations();
		int[] input = {1,4,2};
		int output = solution.minOperations(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int minOperations(int[] nums) {
        int operations = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                operations++;
            }
        }
        return operations;
    }

}
