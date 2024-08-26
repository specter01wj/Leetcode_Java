package com.checkifanArrayIsConsecutive;
import java.util.*;

/*
Given an integer array nums, return true if nums is consecutive, 
otherwise return false.

An array is consecutive if it contains every number in the range 
[x, x + n - 1] (inclusive), where x is the minimum number in the 
array and n is the length of the array.
*/

public class E2229_Check_if_an_Array_Is_Consecutive {

	public static void main(String[] args) {
		E2229_Check_if_an_Array_Is_Consecutive solution = new E2229_Check_if_an_Array_Is_Consecutive();
		int[] input = {1,3,4,2};
		boolean output = solution.isConsecutive(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public boolean isConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        // Find the minimum and maximum values
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
            set.add(num);
        }
        
        // Check if the number of unique elements matches the range
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        
        return (max - min + 1) == nums.length;
    }

}
