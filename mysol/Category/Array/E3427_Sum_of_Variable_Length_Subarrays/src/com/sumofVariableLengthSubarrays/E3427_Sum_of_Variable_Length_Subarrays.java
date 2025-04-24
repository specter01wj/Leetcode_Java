package com.sumofVariableLengthSubarrays;
import java.util.*;

/*
You are given an integer array nums of size n. For each index i 
where 0 <= i < n, define a subarray nums[start ... i] where 
start = max(0, i - nums[i]).

Return the total sum of all elements from the subarray defined 
for each index in the array.
*/

public class E3427_Sum_of_Variable_Length_Subarrays {

	public static void main(String[] args) {
		E3427_Sum_of_Variable_Length_Subarrays solution = new E3427_Sum_of_Variable_Length_Subarrays();
		int[] input = {2,3,1};
		int output = solution.subarraySum(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Initialize a variable totalSum to store the result.
	2. Loop through each index i of the array:
		. Calculate start = Math.max(0, i - nums[i])
		. Loop through from start to i and sum elements in that range
	3. Add this subarray sum to totalSum
	4. Return totalSum
    */
	
	/*
     * @param nums: a list of integers
     * @return: the total sum of all elements from the subarray defined for each index in the array
     */
	public int subarraySum(int[] nums) {
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            for (int j = start; j <= i; j++) {
                totalSum += nums[j];
            }
        }

        return totalSum;
    }

}
