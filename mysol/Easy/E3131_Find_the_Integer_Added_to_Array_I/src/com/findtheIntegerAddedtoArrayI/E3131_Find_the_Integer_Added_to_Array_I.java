package com.findtheIntegerAddedtoArrayI;
import java.util.*;

/*
You are given two arrays of equal length, nums1 and nums2.

Each element in nums1 has been increased (or decreased in the 
case of negative) by an integer, represented by the variable x.

As a result, nums1 becomes equal to nums2. Two arrays are considered 
equal when they contain the same integers with the same frequencies.

Return the integer x.
*/

public class E3131_Find_the_Integer_Added_to_Array_I {

	public static void main(String[] args) {
		E3131_Find_the_Integer_Added_to_Array_I solution = new E3131_Find_the_Integer_Added_to_Array_I();
		int[] input1 = {2,6,4}, input2 = {9,7,5};
		int[] copyNums1 = Arrays.copyOf(input1, input1.length);
        int[] copyNums2 = Arrays.copyOf(input2, input2.length);
		int output = solution.addedInteger(copyNums1, copyNums2);
        System.out.println("input: " + Arrays.toString(input1) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Sorting: Ensures that the corresponding elements are aligned.
	2. Median Difference: Since addition preserves order, the difference between medians gives the correct value of x.
    */
	
	/*
     * @param nums1: a list of integers
     * @param nums2: a list of integers
     * @return: the number of good triplets
     */
	public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[nums2.length / 2] - nums1[nums1.length / 2];
    }

}
