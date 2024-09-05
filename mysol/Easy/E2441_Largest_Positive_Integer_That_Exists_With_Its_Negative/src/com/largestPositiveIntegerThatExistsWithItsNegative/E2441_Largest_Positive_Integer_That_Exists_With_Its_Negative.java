package com.largestPositiveIntegerThatExistsWithItsNegative;
import java.util.*;

/*
Given an integer array nums that does not contain any zeros, 
find the largest positive integer k such that -k also exists in the array.

Return the positive integer k. If there is no such integer, return -1.
*/

public class E2441_Largest_Positive_Integer_That_Exists_With_Its_Negative {

	public static void main(String[] args) {
		E2441_Largest_Positive_Integer_That_Exists_With_Its_Negative solution = new E2441_Largest_Positive_Integer_That_Exists_With_Its_Negative();
		int[] input = {-1,10,6,7,-7,1};
		int output = solution.findMaxK(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. use a HashSet to store the elements of the array for fast lookup.
	2. iterate over the array and check if both k and -k exist in the set.
	3. keep track of the largest k that satisfies this condition.
	4. if no such k is found, we return -1.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the positive integer k. If there is no such integer, return -1
     */
	public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxK = -1;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (num > 0 && set.contains(-num)) {
                maxK = Math.max(maxK, num);
            }
        }

        return maxK;
    }

}
