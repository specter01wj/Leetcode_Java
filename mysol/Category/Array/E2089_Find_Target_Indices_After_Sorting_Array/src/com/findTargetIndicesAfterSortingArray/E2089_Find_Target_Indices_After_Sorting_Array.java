package com.findTargetIndicesAfterSortingArray;
import java.util.*;

/*
You are given a 0-indexed integer array nums and a target element target.

A target index is an index i such that nums[i] == target.

Return a list of the target indices of nums after sorting nums in non-decreasing 
order. If there are no target indices, return an empty list. The returned list 
must be sorted in increasing order.


Example 1:

Input: nums = [1,2,5,2,3], target = 2
Output: [1,2]
Explanation: After sorting, nums is [1,2,2,3,5].
The indices where nums[i] == 2 are 1 and 2.

Example 2:

Input: nums = [1,2,5,2,3], target = 3
Output: [3]
Explanation: After sorting, nums is [1,2,2,3,5].
The index where nums[i] == 3 is 3.

Example 3:

Input: nums = [1,2,5,2,3], target = 5
Output: [4]
Explanation: After sorting, nums is [1,2,2,3,5].
The index where nums[i] == 5 is 4.
*/

public class E2089_Find_Target_Indices_After_Sorting_Array {

	public static void main(String[] args) {
		int[] input = {1,2,5,2,3};
		int target = 2;
		List<Integer> output = targetIndices(input, target);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    . The array nums is sorted using Array.sort() method.
	. Then while traversing nums, if any element equals the target its index is added in the ArrayList ans.
	. List ans is then returned as answer.
    */
	
	/*
     * @param nums: a list of integers
     * @param target: an integer
     * @return: a list of the target indices of nums after sorting nums in non-decreasing order
     */
	public static List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
	    ArrayList<Integer> ans = new ArrayList<Integer>();
		 
        for (int i=0;i < nums.length;i++) {
            if (nums[i] == target) {
                ans.add(i);
            }
        }
        return ans;   
    }

}
