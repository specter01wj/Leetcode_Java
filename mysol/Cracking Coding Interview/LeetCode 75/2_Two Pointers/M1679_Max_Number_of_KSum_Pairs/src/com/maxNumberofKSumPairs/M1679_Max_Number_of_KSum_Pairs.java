package com.maxNumberofKSumPairs;
import java.util.*;

/*
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k 
and remove them from the array.

Return the maximum number of operations you can perform on the array.
*/

public class M1679_Max_Number_of_KSum_Pairs {

	public static void main(String[] args) {
		int[] input = {1,2,3,4};
		int k = 5;
		int output = maxOperations(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            int complement = k - num;
            // Check if the complement is present and has a non-zero count
            if (numCounts.getOrDefault(complement, 0) > 0) {
                // Perform an operation and decrease the count of the complement
                operations++;
                numCounts.put(complement, numCounts.get(complement) - 1);
            } else {
                // Otherwise, increase the count of the current number
                numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
            }
        }

        return operations;
    }

}
