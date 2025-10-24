package com.containsDuplicate;
import java.util.*;

/*
Given an integer array nums, return true if any value appears at least 
twice in the array, and return false if every element is distinct.
*/

public class E217_Contains_Duplicate {

	public static void main(String[] args) {
		E217_Contains_Duplicate solution = new E217_Contains_Duplicate();
		int[] input = {1,1,1,3,3,4,3,2,4,2};
		boolean output = solution.containsDuplicate(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> seen = new HashSet<>();
		
		for (int num : nums) {
			if (seen.contains(num)) {
				return true; // Found a duplicate
			}
			seen.add(num);
		}
		
		return false; // All elements are distinct
	}

}
