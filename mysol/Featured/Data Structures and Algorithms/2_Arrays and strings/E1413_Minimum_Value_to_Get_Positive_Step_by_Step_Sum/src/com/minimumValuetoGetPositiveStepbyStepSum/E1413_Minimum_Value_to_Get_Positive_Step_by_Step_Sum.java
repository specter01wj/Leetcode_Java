package com.minimumValuetoGetPositiveStepbyStepSum;
import java.util.*;

/*
Given an array of integers nums, you start with an initial 
positive value startValue.

In each iteration, you calculate the step by step sum of 
startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that 
the step by step sum is never less than 1.
*/

public class E1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum {

	public static void main(String[] args) {
		E1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum solution = new E1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum();
		int[] input = {-3,2,-3,4,2};
		int output = solution.minStartValue(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Prefix sum
    */
	
	/*
     * @param nums: a list of integers
     * @return: the minimum positive value of startValue
     */
	public int minStartValue(int[] nums) {
	    int sum = 0;
	    int minSum = 0;

	    for (int num : nums) {
	        sum += num;
	        minSum = Math.min(minSum, sum);
	    }

	    return 1 - minSum;
	}

}
