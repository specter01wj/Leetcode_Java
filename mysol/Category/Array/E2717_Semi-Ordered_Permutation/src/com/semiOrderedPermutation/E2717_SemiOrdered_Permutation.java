package com.semiOrderedPermutation;
import java.util.*;

/*
You are given a 0-indexed permutation of n integers nums.

A permutation is called semi-ordered if the first number equals 1 
and the last number equals n. You can perform the below operation 
as many times as you want until you make nums a semi-ordered permutation:

	. Pick two adjacent elements in nums, then swap them.

Return the minimum number of operations to make nums a semi-ordered permutation.

A permutation is a sequence of integers from 1 to n of length n containing 
each number exactly once.
*/

public class E2717_SemiOrdered_Permutation {

	public static void main(String[] args) {
		E2717_SemiOrdered_Permutation solution = new E2717_SemiOrdered_Permutation();
		int[] input = {2,4,1,3};
		int output = solution.semiOrderedPermutation(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int index1 = -1;
        int indexN = -1;

        // Find the positions of 1 and n in the array
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) index1 = i;
            if (nums[i] == n) indexN = i;
        }

        // Calculate moves to bring 1 to the start and n to the end
        int moves = index1 + (n - 1 - indexN);

        // If `1` is before `n`, no extra move needed; otherwise, one move overlaps
        if (index1 > indexN) moves -= 1;

        return moves;
    }

}
