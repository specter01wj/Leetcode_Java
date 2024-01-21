package com.findPeakElement;
import java.util.*;

/*
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return 
its index. If the array contains multiple peaks, return the index to 
any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, 
an element is always considered to be strictly greater than a 
neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.
*/

public class M162_Find_Peak_Element {

	public static void main(String[] args) {
		int[] input = {1,2,1,3,5,6,4};
		int output = findPeakElement(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    BST
    */
	
	/*
     * @param nums: a list of integers
     * @return: the index to any of the peaks
     */
	public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak is in the left half or at mid
                right = mid;
            } else {
                // Peak is in the right half
                left = mid + 1;
            }
        }
        
        // When left equals right, we have found the peak element
        return left;
    }

}
