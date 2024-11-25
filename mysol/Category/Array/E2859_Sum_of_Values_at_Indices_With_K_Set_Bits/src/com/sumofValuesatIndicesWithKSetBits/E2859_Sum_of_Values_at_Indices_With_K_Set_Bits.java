package com.sumofValuesatIndicesWithKSetBits;
import java.util.*;

/*
You are given a 0-indexed integer array nums and an integer k.

Return an integer that denotes the sum of elements in nums whose 
corresponding indices have exactly k set bits in their binary representation.

The set bits in an integer are the 1's present when it is written in binary.

	. For example, the binary representation of 21 is 10101, which has 3 set bits.
*/

public class E2859_Sum_of_Values_at_Indices_With_K_Set_Bits {

	public static void main(String[] args) {
		E2859_Sum_of_Values_at_Indices_With_K_Set_Bits solution = new E2859_Sum_of_Values_at_Indices_With_K_Set_Bits();
		List<Integer> input = List.of(5, 10, 1, 5, 2);
        int k = 1;
		int output = solution.sumIndicesWithKSetBits(input, k);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Iterate Through Indices:
		. Loop through all indices of the nums list.
		. For each index, check if the number of set bits in its binary 
			representation equals k.
	2. Count Set Bits:
		. Use the countSetBits helper method:
			. Increment a counter for each set bit (1) in the binary representation.
			. Use the bitwise AND operation (n & 1) to check if the least significant bit is set.
			. Right shift the number (n >>= 1) to process the next bit.
	3. Accumulate the Sum:
		. If the index has exactly k set bits, add the corresponding value from nums to the sum.
	4. Return Result:
		. After processing all indices, return the accumulated sum.
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: an integer that denotes the sum of elements in nums
     */
	public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (countSetBits(i) == k) {
                sum += nums.get(i);
            }
        }

        return sum;
    }

    // Helper method to count the number of set bits (1s) in the binary representation of a number
    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1); // Increment if the last bit is 1
            n >>= 1;         // Right shift to process the next bit
        }
        return count;
    }

}
