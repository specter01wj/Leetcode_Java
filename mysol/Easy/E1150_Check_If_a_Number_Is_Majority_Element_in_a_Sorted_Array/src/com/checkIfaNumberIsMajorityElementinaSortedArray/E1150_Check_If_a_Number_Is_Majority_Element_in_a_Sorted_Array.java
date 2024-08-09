package com.checkIfaNumberIsMajorityElementinaSortedArray;
import java.util.*;

/*
Given an integer array nums sorted in non-decreasing order 
and an integer target, return true if target is a majority 
element, or false otherwise.

A majority element in an array nums is an element that appears 
more than nums.length / 2 times in the array.
*/

public class E1150_Check_If_a_Number_Is_Majority_Element_in_a_Sorted_Array {

	public static void main(String[] args) {
		E1150_Check_If_a_Number_Is_Majority_Element_in_a_Sorted_Array solution = new E1150_Check_If_a_Number_Is_Majority_Element_in_a_Sorted_Array();
		int[] input = {2,4,5,5,5,5,5,6,6};
		int target = 5;
		boolean output = solution.isMajorityElement(input, target);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. findFirstOccurrence Function:
	  . This helper function performs a binary search to find the first occurrence of the target in the array.
	  . If the target is found, it returns the index of the first occurrence; otherwise, it returns -1.
	2. isMajorityElement Function:
	  . First, we calculate the length of the array n.
	  . We then use findFirstOccurrence to find the first occurrence of target in nums.
	  . If the target isn't found, we return false.
	  . If it is found, we check whether target appears more than n/2 times by checking if nums[firstIndex + n/2] equals target. 
	  	If it does, the target is a majority element, and we return true; otherwise, we return false.
    */
	
	/*
     * @param nums: a list of integers
     * @param target: an integer
     * @return: true if target is a majority element, or false otherwise
     */
	public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int firstIndex = findFirstOccurrence(nums, target);

        // If the target is not found in the array
        if (firstIndex == -1) {
            return false;
        }

        // Check if the target appears more than n/2 times
        int majorityIndex = firstIndex + n / 2;
        if (majorityIndex < n && nums[majorityIndex] == target) {
            return true;
        }
        
        return false;
    }

    private int findFirstOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;  // Target not found
    }

}
