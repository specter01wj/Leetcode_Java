package com.numberofUnequalTripletsinArray;
import java.util.*;

/*
You are given a 0-indexed array of positive integers nums. 
Find the number of triplets (i, j, k) that meet the following conditions:

	. 0 <= i < j < k < nums.length
	. nums[i], nums[j], and nums[k] are pairwise distinct.
		. In other words, nums[i] != nums[j], nums[i] != nums[k], and nums[j] != nums[k].

Return the number of triplets that meet the conditions.
*/

public class E2475_Number_of_Unequal_Triplets_in_Array {

	public static void main(String[] args) {
		E2475_Number_of_Unequal_Triplets_in_Array solution = new E2475_Number_of_Unequal_Triplets_in_Array();
		int[] input = {4,4,2,4,3};
		int output = solution.unequalTriplets(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int unequalTriplets(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        // Iterate over all triplets (i, j, k)
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Check if nums[i], nums[j], and nums[k] are distinct
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }

}
