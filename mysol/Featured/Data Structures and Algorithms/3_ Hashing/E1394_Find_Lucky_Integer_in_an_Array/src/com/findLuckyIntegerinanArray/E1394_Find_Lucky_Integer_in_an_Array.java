package com.findLuckyIntegerinanArray;
import java.util.*;

/*
Given an array of integers arr, a lucky integer is an integer 
that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. If there is no 
lucky integer return -1.
*/

public class E1394_Find_Lucky_Integer_in_an_Array {

	public static void main(String[] args) {
		E1394_Find_Lucky_Integer_in_an_Array solution = new E1394_Find_Lucky_Integer_in_an_Array();
		int[] input = {1,2,2,3,3,3};
		int output = solution.findLucky(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int findLucky(int[] arr) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		
		// Count frequency of each number
		for (int num : arr) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		
		int result = -1;
		
		// Check for lucky integers
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			int num = entry.getKey();
			int freq = entry.getValue();
			if (num == freq) {
				result = Math.max(result, num);
			}
		}
		
		return result;
	}

}
