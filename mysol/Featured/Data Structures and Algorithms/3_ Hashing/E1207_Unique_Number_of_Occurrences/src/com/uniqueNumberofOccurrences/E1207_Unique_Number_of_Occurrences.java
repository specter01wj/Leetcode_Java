package com.uniqueNumberofOccurrences;
import java.util.*;

/*
Given an array of integers arr, return true if the number of 
occurrences of each value in the array is unique or false otherwise.
*/

public class E1207_Unique_Number_of_Occurrences {

	public static void main(String[] args) {
		E1207_Unique_Number_of_Occurrences solution = new E1207_Unique_Number_of_Occurrences();
		int[] input = {1,2,2,1,1,3};
		boolean output = solution.uniqueOccurrences(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param arr: a list of integers
     * @return: true if the number of occurrences of each value in the array is unique
     */
	public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Count frequency of each number
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Use a HashSet to check for duplicate frequencies
        Set<Integer> freqSet = new HashSet<>();
        for (int freq : countMap.values()) {
            if (!freqSet.add(freq)) {
                return false; // frequency already exists
            }
        }
        
        return true;
    }

}
