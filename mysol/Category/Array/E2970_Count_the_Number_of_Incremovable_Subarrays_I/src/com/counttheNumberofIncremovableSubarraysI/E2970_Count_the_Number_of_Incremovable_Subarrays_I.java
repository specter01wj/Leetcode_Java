package com.counttheNumberofIncremovableSubarraysI;
import java.util.*;

/*
You are given a 0-indexed array of positive integers nums.

A subarray of nums is called incremovable if nums becomes strictly 
increasing on removing the subarray. For example, the subarray [3, 4] 
is an incremovable subarray of [5, 3, 4, 6, 7] because removing this 
subarray changes the array [5, 3, 4, 6, 7] to [5, 6, 7] which is 
strictly increasing.

Return the total number of incremovable subarrays of nums.

Note that an empty array is considered strictly increasing.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

public class E2970_Count_the_Number_of_Incremovable_Subarrays_I {

	public static void main(String[] args) {
		E2970_Count_the_Number_of_Incremovable_Subarrays_I solution = new E2970_Count_the_Number_of_Incremovable_Subarrays_I();
		int[] input = {6,5,7,8};
		int output = solution.incremovableSubarrayCount(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Outer Loops:
		. Use two nested loops to generate all subarrays with indices [start, end].
	2. isIncremovable Method:
		. For each subarray [start, end], iterate through the array while skipping the indices in the subarray.
		. Keep track of the last seen number (prev) and check if the remaining elements form a strictly increasing sequence.
	3. Count:
		. Increment the count for every subarray that satisfies the "incremovable" condition.
    */
	
	/*
     * @param arr: a list of integers
     * @return: the total number of incremovable subarrays of nums
     */
	public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;

        // Iterate over all possible subarray start and end indices
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                if (isIncremovable(nums, start, end)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isIncremovable(int[] nums, int start, int end) {
        int n = nums.length;

        // Check the remaining array after removing the subarray [start, end]
        int prev = -1;

        for (int i = 0; i < n; i++) {
            if (i < start || i > end) { // Skip the subarray
                if (prev != -1 && nums[i] <= prev) {
                    return false; // Not strictly increasing
                }
                prev = nums[i];
            }
        }

        return true; // Remaining array is strictly increasing
    }

}
