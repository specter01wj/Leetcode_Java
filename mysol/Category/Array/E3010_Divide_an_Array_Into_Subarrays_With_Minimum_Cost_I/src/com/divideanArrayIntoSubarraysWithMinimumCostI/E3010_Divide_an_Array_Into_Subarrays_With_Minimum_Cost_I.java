package com.divideanArrayIntoSubarraysWithMinimumCostI;
import java.util.*;

/*
You are given an array of integers nums of length n.

The cost of an array is the value of its first element. 
For example, the cost of [1,2,3] is 1 while the cost of [3,4,1] is 3.

You need to divide nums into 3 disjoint contiguous subarrays.

Return the minimum possible sum of the cost of these subarrays.
*/

public class E3010_Divide_an_Array_Into_Subarrays_With_Minimum_Cost_I {

	public static void main(String[] args) {
		E3010_Divide_an_Array_Into_Subarrays_With_Minimum_Cost_I solution = new E3010_Divide_an_Array_Into_Subarrays_With_Minimum_Cost_I();
		int[] input = {1,2,3,12};
		int output = solution.minimumCost(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Nested Loops:
		. The first loop identifies the boundary of the first subarray.
		. The second loop identifies the boundary of the second subarray.
		. The remaining elements form the third subarray.
	2. Costs:
		. The first element of each subarray determines the cost of that subarray.
	3. Optimization:
		. For each division, calculate the total cost and update the minimum cost.
	4. Return Value:
		. After checking all possible divisions, return the minimum cost.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the minimum possible sum of the cost of these subarrays
     */
	public int minimumCost(int[] nums) {
        int n = nums.length;
        if (n < 3) {
        	return -1;
        }

        // Initialize the minimum cost to a high value
        int minCost = Integer.MAX_VALUE;

        // Iterate through all possible divisions of the array into 3 subarrays
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // Divide the array into three subarrays
                int cost1 = nums[0]; // First subarray starts at index 0
                int cost2 = nums[i]; // Second subarray starts at index i
                int cost3 = nums[j]; // Third subarray starts at index j

                // Calculate the total cost for this division
                int totalCost = cost1 + cost2 + cost3;

                // Update the minimum cost if needed
                minCost = Math.min(minCost, totalCost);
            }
        }

        return minCost;
    }

}
