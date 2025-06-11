package com.moveZeroes;
import java.util.*;

/*
Given an integer array nums, move all 0's to the end of it while maintaining 
the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
*/

public class E283_Move_Zeroes {

	public static void main(String[] args) {
		E283_Move_Zeroes solution = new E283_Move_Zeroes();
		int[] input = {0,1,0,3,12};
		int[] inputCopy = Arrays.copyOf(input, input.length);
		solution.moveZeroes(inputCopy);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(inputCopy));
	}
	
	
	public void moveZeroes(int[] nums) {
		int insertPos = 0;

        // First pass: move all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Second pass: fill the rest with 0s
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

}
