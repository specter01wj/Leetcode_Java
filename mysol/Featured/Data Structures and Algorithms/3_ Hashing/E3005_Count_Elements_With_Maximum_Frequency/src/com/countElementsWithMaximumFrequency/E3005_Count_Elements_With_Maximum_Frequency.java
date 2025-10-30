package com.countElementsWithMaximumFrequency;
import java.util.*;

/*
You are given an array nums consisting of positive integers.

Return the total frequencies of elements in nums such that those 
elements all have the maximum frequency.

The frequency of an element is the number of occurrences of that element in the array.
*/

public class E3005_Count_Elements_With_Maximum_Frequency {

	public static void main(String[] args) {
		E3005_Count_Elements_With_Maximum_Frequency solution = new E3005_Count_Elements_With_Maximum_Frequency();
		int[] input = {1,2,2,3,1,4};
		int output = solution.maxFrequencyElements(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int sum = 0;

        // Count frequency of each number
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, freq);

            // Update max frequency if needed
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }

        // Sum up the frequencies of elements that match max frequency
        for (int freq : freqMap.values()) {
            if (freq == maxFreq) {
                sum += freq;
            }
        }

        return sum;
    }

}
