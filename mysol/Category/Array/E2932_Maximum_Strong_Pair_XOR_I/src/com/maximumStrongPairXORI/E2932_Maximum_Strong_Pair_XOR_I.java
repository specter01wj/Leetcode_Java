package com.maximumStrongPairXORI;
import java.util.*;

/*
You are given a 0-indexed integer array nums. A pair of integers x 
and y is called a strong pair if it satisfies the condition:

	. |x - y| <= min(x, y)

You need to select two integers from nums such that they form a strong 
pair and their bitwise XOR is the maximum among all strong pairs in the array.

Return the maximum XOR value out of all possible strong pairs in the array nums.

Note that you can pick the same integer twice to form a pair.
*/

public class E2932_Maximum_Strong_Pair_XOR_I {

	public static void main(String[] args) {
		E2932_Maximum_Strong_Pair_XOR_I solution = new E2932_Maximum_Strong_Pair_XOR_I();
		int[] input = {1,2,3,4,5};
		int output = solution.maximumStrongPairXor(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Iterate Through All Pairs:
		. Use nested loops to evaluate all pairs (i, j) where i <= j. 
			The i <= j condition ensures all combinations are considered, 
			including pairs where x == y.
	2. Check Strong Pair Condition:
		. A pair (x, y) is a strong pair if |x - y| <= min(x, y).
	3. Calculate XOR:
		. For every valid strong pair (x, y), calculate x ^ y (bitwise XOR).
	4. Update Maximum XOR:
		. Keep track of the maximum XOR value found among all strong pairs.
	5. Return Result:
		. After evaluating all pairs, return the maximum XOR value.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the maximum XOR value out of all possible strong pairs in the array nums
     */
	public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        int maxXor = 0;

        // Iterate through all possible pairs
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int x = nums[i];
                int y = nums[j];

                // Check if the pair (x, y) is a strong pair
                if (Math.abs(x - y) <= Math.min(x, y)) {
                    // Calculate XOR and update maxXor if it's larger
                    maxXor = Math.max(maxXor, x ^ y);
                }
            }
        }

        return maxXor;
    }

}
