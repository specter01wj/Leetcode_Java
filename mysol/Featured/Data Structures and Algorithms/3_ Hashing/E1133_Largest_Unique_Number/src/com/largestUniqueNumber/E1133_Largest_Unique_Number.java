package com.largestUniqueNumber;
import java.util.*;

/*
Given an integer array nums, return the largest integer that only occurs once. 
If no integer occurs once, return -1.
*/

public class E1133_Largest_Unique_Number {

	public static void main(String[] args) {
		E1133_Largest_Unique_Number solution = new E1133_Largest_Unique_Number();
		int[] input = {5,7,3,9,4,9,8,3,1};
		int output = solution.largestUniqueNumber(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequency of each number
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the largest number with frequency == 1
        int maxUnique = -1;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                maxUnique = Math.max(maxUnique, entry.getKey());
            }
        }

        return maxUnique;
    }

}
