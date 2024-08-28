package com.mostFrequentEvenElement;
import java.util.*;

/*
Given an integer array nums, return the most frequent even element.

If there is a tie, return the smallest one. If there is no such element, return -1.
*/

public class E2404_Most_Frequent_Even_Element {

	public static void main(String[] args) {
		E2404_Most_Frequent_Even_Element solution = new E2404_Most_Frequent_Even_Element();
		int[] input = {0,1,2,2,4,4,1};
		int output = solution.mostFrequentEven(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int mostFrequentEven(int[] nums) {
        // Map to store the frequency of even numbers
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Traverse through the array and count frequencies of even numbers
        for (int num : nums) {
            if (num % 2 == 0) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
        }

        // Variables to track the most frequent even number and its frequency
        int mostFrequentEven = -1;
        int maxFrequency = 0;

        // Traverse through the map to find the most frequent even number
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            // Update the most frequent even number based on frequency and value
            if (freq > maxFrequency || (freq == maxFrequency && num < mostFrequentEven)) {
                mostFrequentEven = num;
                maxFrequency = freq;
            }
        }

        return mostFrequentEven;
    }

}
