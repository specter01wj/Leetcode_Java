package com.smallestMissingIntegerGreaterThanSequentialPrefixSum;
import java.util.*;

/*
You are given a 0-indexed array of integers nums.

A prefix nums[0..i] is sequential if, for all 1 <= j <= i, 
nums[j] = nums[j - 1] + 1. In particular, the prefix consisting 
only of nums[0] is sequential.

Return the smallest integer x missing from nums such that x is 
greater than or equal to the sum of the longest sequential prefix.
*/

public class E2996_Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum {

	public static void main(String[] args) {
		E2996_Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum solution = new E2996_Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum();
		int[] input = {1,2,3,2,5};
		int output = solution.missingInteger(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Finding the Longest Sequential Prefix:
		. Start with the first element and iterate through the array.
		. Add the current element to sum if it continues the sequential pattern (nums[i] == nums[i - 1] + 1).
	2. Determining the Missing Integer:
		. Start checking from the sum of the sequential prefix.
		. If the current integer is not found in the array, return it as the result.
		. Otherwise, increment x and repeat.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the smallest integer x missing from nums
     */
	public int missingInteger(int[] nums) {
        // Find the longest sequential prefix and its sum
        int sum = nums[0];
        int longestSequentialEnd = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
                longestSequentialEnd = i;
            } else {
                break;
            }
        }

        // Find the smallest integer missing from nums that is >= sum
        int x = sum;
        while (true) {
            boolean found = false;
            for (int num : nums) {
                if (num == x) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return x;
            }
            x++;
        }
    }

}
