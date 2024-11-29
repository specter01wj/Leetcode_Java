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
    count good triplets
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
