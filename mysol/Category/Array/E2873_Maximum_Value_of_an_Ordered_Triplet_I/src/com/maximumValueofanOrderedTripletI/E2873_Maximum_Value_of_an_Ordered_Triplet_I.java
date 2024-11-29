package com.maximumValueofanOrderedTripletI;
import java.util.*;

/*
You are given a 0-indexed integer array nums.

Return the maximum value over all triplets of indices (i, j, k) 
such that i < j < k. If all such triplets have a negative value, return 0.

The value of a triplet of indices (i, j, k) is equal to 
(nums[i] - nums[j]) * nums[k].
*/

public class E2873_Maximum_Value_of_an_Ordered_Triplet_I {

	public static void main(String[] args) {
		E2873_Maximum_Value_of_an_Ordered_Triplet_I solution = new E2873_Maximum_Value_of_an_Ordered_Triplet_I();
		int[] input = {12,6,1,2,7};
		long output = solution.maximumTripletValue(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Iterate Through All Triplets:
		. Use three nested loops to iterate over all combinations of indices (i, j, k) where i < j < k.
	2. Calculate Triplet Value:
		. For each triplet (i, j, k), calculate the value as: (nums[i]−nums[j])×nums[k]
	3. Update Maximum Value:
		. Compare the calculated triplet value with the current maximum and update it if the value is greater.
	4. Return the Result:
		. If no positive value is found, the maximum remains 0.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the maximum value over all triplets of indices (i, j, k)
     */
	public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxValue = 0;

        // Iterate through all possible triplets (i, j, k) where i < j < k
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Calculate the triplet value
                    long value = (long) (nums[i] - nums[j]) * nums[k];
                    // Update the maximum value
                    maxValue = Math.max(maxValue, value);
                }
            }
        }

        return maxValue;
    }

}
