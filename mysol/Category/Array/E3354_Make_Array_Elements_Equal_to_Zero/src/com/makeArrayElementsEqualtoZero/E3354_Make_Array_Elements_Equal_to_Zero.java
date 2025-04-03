package com.makeArrayElementsEqualtoZero;
import java.util.*;

/*
You are given an integer array nums.

Start by selecting a starting position curr such that nums[curr] == 0, 
and choose a movement direction of either left or right.

After that, you repeat the following process:

	. If curr is out of the range [0, n - 1], this process ends.
	. If nums[curr] == 0, move in the current direction by incrementing curr 
		if you are moving right, or decrementing curr if you are moving left.
	. Else if nums[curr] > 0:
		. Decrement nums[curr] by 1.
		. Reverse your movement direction (left becomes right and vice versa).
		. Take a step in your new direction.

A selection of the initial position curr and movement direction is considered 
valid if every element in nums becomes 0 by the end of the process.

Return the number of possible valid selections.
*/

public class E3354_Make_Array_Elements_Equal_to_Zero {

	public static void main(String[] args) {
		E3354_Make_Array_Elements_Equal_to_Zero solution = new E3354_Make_Array_Elements_Equal_to_Zero();
		int[] input = {1,0,2,0,3};
		int output = solution.countValidSelections(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. countValidSelections: Iterates through the array to find all positions with 0, 
    	and for each such position, tries both left and right directions using the simulate method.
	2. simulate: Simulates the movement and mutation process. If after the entire process 
		all elements are zero, it returns true; otherwise, false.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the number of possible valid selections
     */
	public int countValidSelections(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (simulate(nums.clone(), i, -1)) {
                    count++;
                }
                if (simulate(nums.clone(), i, 1)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean simulate(int[] arr, int curr, int direction) {
        int n = arr.length;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += direction;
            } else if (arr[curr] > 0) {
                arr[curr]--;
                direction *= -1;
                curr += direction;
            }
        }

        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }

}
