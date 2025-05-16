package com.runningSumof1dArray;
import java.util.*;

/*
Given an array nums. We define a running sum of an array as 
runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.
*/

public class E1480_Running_Sum_of_1d_Array {

	public static void main(String[] args) {
		E1480_Running_Sum_of_1d_Array solution = new E1480_Running_Sum_of_1d_Array();
		int[] input = {1,2,3,4};
		int[] output = solution.runningSum(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }

}
