package com.countElementsWithMaximumFrequency;
import java.util.*;

/*
You are given an array nums consisting of positive integers.

Return the total frequencies of elements in nums such that those 
elements all have the maximum frequency.

The frequency of an element is the number of occurrences of that 
element in the array.
*/

public class E3005_Count_Elements_With_Maximum_Frequency {

	public static void main(String[] args) {
		E3005_Count_Elements_With_Maximum_Frequency solution = new E3005_Count_Elements_With_Maximum_Frequency();
		int[] input = {1,2,2,3,1,4};
		int output = solution.maxFrequencyElements(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each element in the array
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Find the maximum frequency
        int maxFrequency = 0;
        for (int freq : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, freq);
        }
        
        // Calculate the total frequencies of elements with maximum frequency
        int totalCount = 0;
        for (int num : nums) {
            if (frequencyMap.get(num) == maxFrequency) {
                totalCount++;
            }
        }
        
        return totalCount;
    }

}
