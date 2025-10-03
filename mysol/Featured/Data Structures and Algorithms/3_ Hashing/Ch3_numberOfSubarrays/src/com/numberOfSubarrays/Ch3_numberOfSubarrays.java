package com.numberOfSubarrays;
import java.util.*;

/*
Given an array of integers nums and an integer k. 
A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.
*/

public class Ch3_numberOfSubarrays {

	public static void main(String[] args) {
		Ch3_numberOfSubarrays solution = new Ch3_numberOfSubarrays();
		int[] input = {1,1,2,1,1};
		int k = 3;
		int output = solution.numberOfSubarrays(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: the number of nice sub-arrays
     */
	public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1); // base case: 0 odd numbers seen initially

        int oddCount = 0;
        int result = 0;

        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }

            // If we've seen (oddCount - k) before, add its frequency
            result += countMap.getOrDefault(oddCount - k, 0);

            // Record this oddCount in the map
            countMap.put(oddCount, countMap.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }

}
