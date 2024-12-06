package com.findIndicesWithIndexandValueDifferenceI;
import java.util.*;

/*
You are given a 0-indexed integer array nums having length n, 
an integer indexDifference, and an integer valueDifference.

Your task is to find two indices i and j, both in the range 
[0, n - 1], that satisfy the following conditions:

	. abs(i - j) >= indexDifference, and
	. abs(nums[i] - nums[j]) >= valueDifference

Return an integer array answer, where answer = [i, j] if there 
are two such indices, and answer = [-1, -1] otherwise. 
If there are multiple choices for the two indices, return any of them.
*/

public class E2903_Find_Indices_With_Index_and_Value_Difference_I {

	public static void main(String[] args) {
		E2903_Find_Indices_With_Index_and_Value_Difference_I solution = new E2903_Find_Indices_With_Index_and_Value_Difference_I();
		int[] input = {5,1,4,1};
		int indexDifference = 2, valueDifference = 4;
		int[] output = solution.findIndices(input, indexDifference, valueDifference);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. Nested Loops:
		. Use two nested loops to check all pairs of indices (i, j) in the array.
	2. Check Conditions:
		. For each pair (i, j), check the two conditions:
			. Math.abs(i - j) >= indexDifference
			. Math.abs(nums[i] - nums[j]) >= valueDifference
	3. Return Valid Pair:
		. If a pair satisfies both conditions, return [i, j].
	4. Fallback:
		. If no valid pair is found after checking all possibilities, return [-1, -1].
    */
	
	/*
     * @param nums: a list of integers
     * @param indexDifference: an integer
     * @param valueDifference: an integer
     * @return: an integer array answer
     */
	public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;

        // Iterate through all pairs of indices (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Check if the conditions are satisfied
                if (Math.abs(i - j) >= indexDifference && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[] {i, j};
                }
            }
        }

        // If no such indices are found, return [-1, -1]
        return new int[] {-1, -1};
    }

}
