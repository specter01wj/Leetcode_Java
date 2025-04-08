package com.minimumOperationstoMakeArrayValuesEqualtoK;
import java.util.*;

/*
You are given an integer array nums and an integer k.

An integer h is called valid if all values in the array that are 
strictly greater than h are identical.

For example, if nums = [10, 8, 10, 8], a valid integer is h = 9 
because all nums[i] > 9 are equal to 10, but 5 is not a valid integer.

You are allowed to perform the following operation on nums:

	. Select an integer h that is valid for the current values in nums.
	. For each index i where nums[i] > h, set nums[i] to h.

Return the minimum number of operations required to make every element 
in nums equal to k. If it is impossible to make all elements equal to k, return -1.
*/

public class E3375_Minimum_Operations_to_Make_Array_Values_Equal_to_K {

	public static void main(String[] args) {
		E3375_Minimum_Operations_to_Make_Array_Values_Equal_to_K solution = new E3375_Minimum_Operations_to_Make_Array_Values_Equal_to_K();
		int[] input = {5,2,5,4,5};
		int k = 2;
		int output = solution.minOperations(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int minOperations(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        for (int x : nums) {
            if (x < k) {
                return -1; // can't increase a number
            } else if (x > k) {
                st.add(x); // collect distinct values > k
            }
        }
        return st.size(); // each distinct > k takes 1 op
    }

}
