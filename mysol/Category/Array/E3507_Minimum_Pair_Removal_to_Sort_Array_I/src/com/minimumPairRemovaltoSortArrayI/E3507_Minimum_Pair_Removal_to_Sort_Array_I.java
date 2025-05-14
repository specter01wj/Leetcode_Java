package com.minimumPairRemovaltoSortArrayI;
import java.util.*;

/*
Given an array nums, you can perform the following operation any number of times:

	. Select the adjacent pair with the minimum sum in nums. 
		If multiple such pairs exist, choose the leftmost one.
	. Replace the pair with their sum.

Return the minimum number of operations needed to make the array non-decreasing.

An array is said to be non-decreasing if each element is greater than or 
equal to its previous element (if it exists).
*/

public class E3507_Minimum_Pair_Removal_to_Sort_Array_I {

	public static void main(String[] args) {
		int[] input = {5,2,3,1};
		int output = minimumPairRemoval(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int minimumPairRemoval(int[] nums) {
        int operations = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);

        while (!isSorted(list)) {
            int minSum = Integer.MAX_VALUE;
            int index = -1;

            // Step 1: Find the leftmost adjacent pair with the minimum sum
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            // Step 2: Replace the pair at 'index' and 'index+1' with their sum
            int merged = list.get(index) + list.get(index + 1);
            list.remove(index + 1); // remove right first to avoid shifting issues
            list.set(index, merged);

            operations++;
        }

        return operations;
    }

    private boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) return false;
        }
        return true;
    }

}
