package com.minimumValuetoGetPositiveStepbyStepSum;
import java.util.*;

/*
Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in 
nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is 
never less than 1.


Example 1:

Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum 
is less than 1.
step by step sum
startValue = 4 | startValue = 5 | nums
  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
  (4 +2 ) = 6  | (5 +2 ) = 7    |   2

Example 2:

Input: nums = [1,2]
Output: 1
Explanation: Minimum start value should be positive. 

Example 3:

Input: nums = [1,-2,-3]
Output: 5
*/

public class E1413_Minimum_Value_to_Get_Positive_Step_by_Step_Sum {

	public static void main(String[] args) {
		int[] input = {-3,2,-3,4,2};
		int output = minStartValue(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    This question uses the concept of Prefix Sum and can be optimally solved in 
    One-Pass w/ Constant-Space.
	To solve this question, we need to find the Minimum Prefix Sum <= 0 ending at each index.
	At an index i:
	prefixSum = Sum of first i elements.
	To keep track of the minimum prefix sum, we use minVal. It is initially assigned to zero 
	so that we can find the minimum prefix sum <= 0.
	Final Minimum Positive startValue will be 1 - Minimum Prefix Sum as this will ensure 
	that the prefix sum is always >= 1 at every index of the input array.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the minimum positive value of startValue
     */
	public static int minStartValue(int[] nums) {
        int minVal = 0;
        int prefixSum = 0;
        for (int n : nums) {
            prefixSum += n;
            minVal = Math.min(minVal, prefixSum);
        }
        return 1 - minVal;
    }

}
