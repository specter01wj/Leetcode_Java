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
