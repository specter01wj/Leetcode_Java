package com.neitherMinimumnorMaximum;
import java.util.*;

/*
Given an integer array nums containing distinct positive integers, 
find and return any number from the array that is neither the minimum 
nor the maximum value in the array, or -1 if there is no such number.

Return the selected integer.
*/

public class E2733_Neither_Minimum_nor_Maximum {

	public static void main(String[] args) {
		E2733_Neither_Minimum_nor_Maximum solution = new E2733_Neither_Minimum_nor_Maximum();
		int[] input = {3,2,1,4};
		int output = solution.findNonMinOrMax(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int findNonMinOrMax(int[] nums) {
        // If the array has fewer than 3 elements, return -1 since we can't have a middle element
        if (nums.length < 3) {
            return -1;
        }

        // Find the minimum and maximum values in the array
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        // Return any number that is neither min nor max
        for (int num : nums) {
            if (num != min && num != max) {
                return num;
            }
        }

        return -1;
    }

}
