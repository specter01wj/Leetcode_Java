package com.serachInsertPosition;
import java.util.*;

/*Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0*/

public class E35_Search_Insert_Position {

	public static void main(String[] args) {
		int[] input = {1,3,5};
        int output = searchInsert(input, 5);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    find the first position >= target
    */
	
	/*
     * @param nums: a list of integers
     * @param target: an integer
     * @return: an integer
     */
	public static int[] rotate(int[] nums, int target) {
		
	}

}
