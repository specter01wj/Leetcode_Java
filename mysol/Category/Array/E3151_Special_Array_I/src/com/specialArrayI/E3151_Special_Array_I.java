package com.specialArrayI;
import java.util.*;

/*
An array is considered special if every pair of its adjacent 
elements contains two numbers with different parity.

You are given an array of integers nums. Return true if nums 
is a special array, otherwise, return false.
*/

public class E3151_Special_Array_I {

	public static void main(String[] args) {
		E3151_Special_Array_I solution = new E3151_Special_Array_I();
		int[] input = {2,1,4};
		boolean output = solution.isArraySpecial(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public boolean isArraySpecial(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if ((nums[i] % 2) == (nums[i - 1] % 2)) {
				return false; // Adjacent elements have the same parity
			}
		}
		
		return true; // All adjacent pairs have different parity
	}

}
