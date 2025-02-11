package com.findtheXORofNumbersWhichAppearTwice;
import java.util.*;

/*
You are given an array nums, where each number in the array 
appears either once or twice.

Return the bitwise XOR of all the numbers that appear twice 
in the array, or 0 if no number appears twice.
*/

public class E3158_Find_the_XOR_of_Numbers_Which_Appear_Twice {

	public static void main(String[] args) {
		int[] input = {3,0,1,1,9,7};
		int output = countGoodTriplets(input, 7, 2, 3);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int duplicateNumbersXOR(int[] nums) {
		HashSet<Integer> seen = new HashSet<>();
		HashSet<Integer> duplicates = new HashSet<>();
		int xor = 0;
		
		for (int num : nums) {
			if (!seen.add(num)) { // If already seen, it's a duplicate
				if (duplicates.add(num)) { // Ensure we only XOR once per duplicate number
					xor ^= num;
				}
			}
		}
		
		return xor;
	}

}
