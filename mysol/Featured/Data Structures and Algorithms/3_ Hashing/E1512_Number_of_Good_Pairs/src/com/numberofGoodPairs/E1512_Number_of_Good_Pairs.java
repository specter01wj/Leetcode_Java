package com.numberofGoodPairs;
import java.util.*;

/*
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.
*/

public class E1512_Number_of_Good_Pairs {

	public static void main(String[] args) {
		E1512_Number_of_Good_Pairs solution = new E1512_Number_of_Good_Pairs();
		int[] input = {1,2,3,1,1,3};
		int output = solution.numIdenticalPairs(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashMap
    */
	
	/*
     * @param nums: a list of integers
     * @return: the number of good pairs
     */
	public int numIdenticalPairs(int[] nums) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		int count = 0;
		
		for (int num : nums) {
			if (freqMap.containsKey(num)) {
				count += freqMap.get(num); // all previous occurrences can pair with this
			}
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		
		return count;
	}

}
