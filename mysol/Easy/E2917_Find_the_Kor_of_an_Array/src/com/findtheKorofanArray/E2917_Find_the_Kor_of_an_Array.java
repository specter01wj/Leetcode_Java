package com.findtheKorofanArray;
import java.util.*;

/*
You are given an integer array nums, and an integer k. 
Let's introduce K-or operation by extending the standard bitwise OR. 
In K-or, a bit position in the result is set to 1 if at least k numbers 
in nums have a 1 in that position.

Return the K-or of nums.
*/

public class E2917_Find_the_Kor_of_an_Array {

	public static void main(String[] args) {
		E2917_Find_the_Kor_of_an_Array solution = new E2917_Find_the_Kor_of_an_Array();
		int[] input = {7,12,9,8,9,15};
		int k = 4;
		int output = solution.findKOr(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Iterate Over Bit Positions:
		. Iterate through each bit position from 0 to 31 (for a 32-bit integer).
	2. Count Numbers with Bit Set:
		. For each bit position, count how many numbers in the array have that 
			bit set to 1 using (num & (1 << bit)).
	3. Check Against k:
		. If the count of numbers with the current bit set is greater than or 
			equal to k, set that bit in the result using result |= (1 << bit).
	4. Return Result:
		. After processing all bit positions, return the result.
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: the K-or of nums
     */
	public int findKOr(int[] nums, int k) {
        int result = 0;

        // Iterate over each bit position (0 to 31 for a 32-bit integer)
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;

            // Count how many numbers have the current bit set
            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            // If the bit is set in at least k numbers, set it in the result
            if (count >= k) {
                result |= (1 << bit);
            }
        }

        return result;
    }

}
