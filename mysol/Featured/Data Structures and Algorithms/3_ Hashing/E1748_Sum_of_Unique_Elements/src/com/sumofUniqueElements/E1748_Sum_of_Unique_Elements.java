package com.sumofUniqueElements;
import java.util.*;

/*
You are given an integer array nums. The unique elements of 
an array are the elements that appear exactly once in the array.

Return the sum of all the unique elements of nums.
*/

public class E1748_Sum_of_Unique_Elements {

	public static void main(String[] args) {
		E1748_Sum_of_Unique_Elements solution = new E1748_Sum_of_Unique_Elements();
		int[] input = {1,2,3,2};
		int output = solution.sumOfUnique(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param nums: a list of integers
     * @return: the sum of all the unique elements of nums
     */
	public int sumOfUnique(int[] nums) {
		Map<Integer, Integer> countMap = new HashMap<>();
		
		// Count occurrences of each number
		for (int num : nums) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}
		
		int sum = 0;
		// Sum elements that appear exactly once
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() == 1) {
				sum += entry.getKey();
			}
		}
		
		return sum;
	}

}
