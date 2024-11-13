package com.checkifArrayisGood;
import java.util.*;

/*
You are given an integer array nums. We consider an array good if 
it is a permutation of an array base[n].

base[n] = [1, 2, ..., n - 1, n, n] (in other words, it is an array 
of length n + 1 which contains 1 to n - 1 exactly once, plus two 
occurrences of n). For example, base[1] = [1, 1] and base[3] = [1, 2, 3, 3].

Return true if the given array is good, otherwise return false.

Note: A permutation of integers represents an arrangement of these numbers.
*/

public class E2784_Check_if_Array_is_Good {

	public static void main(String[] args) {
		E2784_Check_if_Array_is_Good solution = new E2784_Check_if_Array_is_Good();
		int[] input = {1, 3, 3, 2};
		boolean output = solution.isGood(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Determine the Expected Maximum (n):
		. n is determined as nums.length - 1, as base[n] has n + 1 elements.
	2. Count Occurrences:
		. We use an array count to store the occurrences of each integer in nums.
	3. Validate Counts:
		. For numbers 1 to n - 1: Check that each appears exactly once. If not, return false.
		. For number n: Check that it appears exactly twice. If not, return false.
	4. Return Result:
		. If all checks are satisfied, return true, indicating that nums is a 
			valid permutation of base[n].
    */
	
	/*
     * @param nums: a list of integers
     * @return: true if the given array is good, otherwise return false
     */
	public boolean isGood(int[] nums) {
        int n = nums.length - 1; // Expected maximum element n
        int[] count = new int[n + 1];

        // Count the occurrences of each number
        for (int num : nums) {
            if (num > n) {
                return false; // Any number greater than n makes it invalid
            }
            count[num]++;
        }

        // Check that each number from 1 to n-1 appears exactly once
        for (int i = 1; i < n; i++) {
            if (count[i] != 1) {
                return false;
            }
        }

        // Check that n appears exactly twice
        return count[n] == 2;
    }

}
