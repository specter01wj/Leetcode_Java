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
	
	/*
    solution:
    1. Using a Set to Track Collected Elements:
		. A HashSet is used to store collected elements because it ensures 
			uniqueness and allows for efficient O(1) insert and lookup operations.
	2. Iterate from the End of the List:
		. Start iterating from the last element of the list towards the first, 
			simulating the process of removing elements from the end.
		. Add elements to the collected set if they are less than or equal to k.
	3. Count Operations:
		. Increment the operations counter for each element processed.
	4. Stop When All Elements Are Collected:
		. If the size of the collected set equals k (indicating all elements 
			from 1 to k are collected), break out of the loop.
	5. Return the Result:
		. The operations variable contains the minimum number of operations 
			required to collect all elements.
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: the minimum number of operations needed to collect elements
     */
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
