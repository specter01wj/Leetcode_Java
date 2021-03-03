package com.squaresofaSortedArray;
import java.util.*;

/*Given an integer array nums sorted in non-decreasing order, 
return an array of the squares of each number sorted in 
non-decreasing order.

		 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]*/

public class E977_Squares_of_a_Sorted_Array {

	public static void main(String[] args) {
		int[] input = {-4,-1,0,3,10};
		System.out.println("input: " + Arrays.toString(input) );
        int[] output = sortedSquares(input);
        System.out.println("output: " + Arrays.toString(output));
	}
	
	/*
    solution:
    直接原地平方，然后进行排序
    */
	
	/**
     * @param A: The array A.
     * @return: The array of the squares.
     */
	/*
	 * public static int[] sortedSquares(int[] nums) { int length = nums.length;
	 * for(int i = 0; i < length; i++) { nums[i] = nums[i] * nums[i]; }
	 * Arrays.sort(nums);
	 * 
	 * return nums; }
	 */
	
	
	/*
    solution:
    左指针从头开始，右指针从尾开始，若相遇则结束。
    */
	
	/**
     * @param A: The array A.
     * @return: The array of the squares.
     */
	public static int[] sortedSquares(int[] nums) {
		int left = 0, right = nums.length - 1;
        int[] answer = new int[nums.length];
        
        while (left <= right) {
            int left_num = nums[left] * nums[left];
            int right_num = nums[right] * nums[right];
            answer[right - left] = Math.max(left_num, right_num);
            left = left + (left_num > right_num ? 1 : 0);
            right = right - (int)(left_num <= right_num ? 1 : 0);
        }
        
        return answer;
	}

}
