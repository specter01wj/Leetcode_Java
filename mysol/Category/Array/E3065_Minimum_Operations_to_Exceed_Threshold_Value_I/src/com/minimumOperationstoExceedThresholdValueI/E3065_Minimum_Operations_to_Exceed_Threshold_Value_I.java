package com.minimumOperationstoExceedThresholdValueI;
import java.util.*;

/*
You are given a 0-indexed integer array nums, and an integer k.

In one operation, you can remove one occurrence of the smallest element of nums.

Return the minimum number of operations needed so that all elements 
of the array are greater than or equal to k.
*/

public class E3065_Minimum_Operations_to_Exceed_Threshold_Value_I {

	public static void main(String[] args) {
		E3065_Minimum_Operations_to_Exceed_Threshold_Value_I solution = new E3065_Minimum_Operations_to_Exceed_Threshold_Value_I();
		int[] input = {2,11,10,1,3};
		int k = 10;
		int output = solution.minOperations(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int minOperations(int[] nums, int k) {
        // Sort the array to make it easier to remove the smallest elements
        Arrays.sort(nums);
        
        int operations = 0;
        int i = 0;

        // Iterate through the array until all elements are >= k
        while (i < nums.length && nums[i] < k) {
            operations++;
            i++;
        }

        return operations;
    }

}
