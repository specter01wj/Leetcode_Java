package com.minimumOperationstoCollectElements;
import java.util.*;

/*
You are given an array nums of positive integers and an integer k.

In one operation, you can remove the last element of the array and 
add it to your collection.

Return the minimum number of operations needed to collect elements 1, 2, ..., k.
*/

public class E2869_Minimum_Operations_to_Collect_Elements {

	public static void main(String[] args) {
		E2869_Minimum_Operations_to_Collect_Elements solution = new E2869_Minimum_Operations_to_Collect_Elements();
		List<Integer> input = List.of(3, 1, 5, 4, 2);
		int k = 2;
		int output = solution.minOperations(input, k);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public int minOperations(List<Integer> nums, int k) {
        Set<Integer> collected = new HashSet<>();
        int operations = 0;

        // Start from the end of the array and collect elements
        for (int i = nums.size() - 1; i >= 0; i--) {
            int num = nums.get(i);
            if (num <= k) {
                collected.add(num);
            }
            operations++;

            // Check if all elements from 1 to k are collected
            if (collected.size() == k) {
                break;
            }
        }

        return operations;
    }

}
