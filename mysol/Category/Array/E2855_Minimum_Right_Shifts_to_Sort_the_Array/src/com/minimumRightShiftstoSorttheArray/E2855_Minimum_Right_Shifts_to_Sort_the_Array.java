package com.minimumRightShiftstoSorttheArray;
import java.util.*;

/*
You are given a 0-indexed array nums of length n containing 
distinct positive integers. Return the minimum number of right 
shifts required to sort nums and -1 if this is not possible.

A right shift is defined as shifting the element at index i to 
index (i + 1) % n, for all indices.
*/

public class E2855_Minimum_Right_Shifts_to_Sort_the_Array {

	public static void main(String[] args) {
		E2855_Minimum_Right_Shifts_to_Sort_the_Array solution = new E2855_Minimum_Right_Shifts_to_Sort_the_Array();
		List<Integer> input = List.of(3, 4, 5, 1, 2);
		int output = solution.minimumRightShifts(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Check if Already Sorted:
		. Iterate through the array to see if it’s already sorted. 
			If it is, return 0.
	2. Find Rotation Point:
		. Identify the single point where the order breaks 
			(where a smaller number follows a larger number).
		. If there’s more than one break, return -1 because it’s 
			impossible to sort the array with right shifts.
	3. Validate Rotated Array:
		. After the rotation point, check if the array is sorted up 
			to the end and wraps correctly to the beginning.
		. Ensure the last element is not greater than the first 
			element after the rotation.
	4. Calculate Right Shifts:
		. The number of right shifts needed is n - rotationPoint.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the minimum number of right shifts required to sort nums
     */
	public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();

        // Check if the array is already sorted
        boolean alreadySorted = true;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                alreadySorted = false;
                break;
            }
        }
        if (alreadySorted) return 0;

        // Find the rotation point where the sequence breaks
        int rotationPoint = -1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                if (rotationPoint != -1) {
                    // More than one rotation point means it's not sortable
                    return -1;
                }
                rotationPoint = i;
            }
        }

        // Check if the array is sorted after applying the rotation
        for (int i = rotationPoint; i < n - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                return -1;
            }
        }
        if (nums.get(n - 1) > nums.get(0)) {
            return -1;
        }

        // Return the number of shifts needed
        return n - rotationPoint;
    }

}
