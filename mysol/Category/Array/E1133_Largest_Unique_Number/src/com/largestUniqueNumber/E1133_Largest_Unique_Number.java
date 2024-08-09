package com.largestUniqueNumber;
import java.util.*;

/*
Given an integer array nums, return the largest integer 
that only occurs once. If no integer occurs once, return -1.
*/

public class E1133_Largest_Unique_Number {

	public static void main(String[] args) {
		E1133_Largest_Unique_Number solution = new E1133_Largest_Unique_Number();
		int[] input = {5,7,3,9,4,9,8,3,1};
		int output = solution.largestUniqueNumber(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Use a HashMap: Store the frequency of each number in the array.
	2. Find the Largest Unique Number: Iterate through the array to find the largest number that has a frequency of 1.
	3. Return the Result: If no such number exists, return -1.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the largest integer that only occurs once
     */
	public int largestUniqueNumber(int[] nums) {
        // Step 1: Count the frequency of each number using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Find the largest number that occurs only once
        int largestUnique = -1;
        for (int num : nums) {
            if (frequencyMap.get(num) == 1) {
                largestUnique = Math.max(largestUnique, num);
            }
        }
        
        return largestUnique;
    }

}
