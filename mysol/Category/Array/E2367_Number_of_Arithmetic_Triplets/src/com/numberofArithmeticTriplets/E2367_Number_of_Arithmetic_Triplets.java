package com.numberofArithmeticTriplets;
import java.util.*;

/*
You are given a 0-indexed, strictly increasing integer array nums and a 
positive integer diff. A triplet (i, j, k) is an arithmetic triplet if 
the following conditions are met:

. i < j < k,
. nums[j] - nums[i] == diff, and
. nums[k] - nums[j] == diff.

Return the number of unique arithmetic triplets.
*/

public class E2367_Number_of_Arithmetic_Triplets {

	public static void main(String[] args) {
		int[] input = {0,1,4,6,7,10};
		int diff = 3;
		int output = arithmeticTriplets(input, diff);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int arithmeticTriplets(int[] nums, int diff) {
		int cnt = 0;
		Set<Integer> numberSet = new HashSet<>();
		for (int num : nums) {
			if (numberSet.contains(num - diff) && numberSet.contains(num - diff * 2)) {
				++cnt;
			}
		}
		
		return cnt;
	}

}
