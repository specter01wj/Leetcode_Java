package com.removeDuplicatesfromSortedArray;
import java.util.*;

/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates 
in-place such that each unique element appears only once. The relative order of the 
elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, 
you need to do the following things:

	. Change the array nums such that the first k elements of nums contain the 
		unique elements in the order they were present in nums initially. 
		The remaining elements of nums are not important as well as the size of nums.
	. Return k.
*/

public class E26_Remove_Duplicates_from_Sorted_Array {

	public static void main(String[] args) {
		E26_Remove_Duplicates_from_Sorted_Array solution = new E26_Remove_Duplicates_from_Sorted_Array();
		int[] input = {0,0,1,1,1,2,2,3,3,4};
		int output = solution.removeDuplicates(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1; // Start from 1 since the first element is always unique
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

}
