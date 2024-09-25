package com.maximumCountofPositiveIntegerandNegativeInteger;
import java.util.*;

/*
Given an array nums sorted in non-decreasing order, return 
the maximum between the number of positive integers and the 
number of negative integers.

	. In other words, if the number of positive integers in nums is 
pos and the number of negative integers is neg, then return 
the maximum of pos and neg.
*/

public class E2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer {

	public static void main(String[] args) {
		E2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer solution = new E2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer();
		int[] input = {-2,-1,-1,1,2,3};
		int output = solution.maximumCount(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    loop, count and compare max
    */
	
	/*
     * @param nums: a list of integers
     * @return: the maximum between the number of positive integers and the number of negative integers
     */
	public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;

        // Iterate through the array and count positive and negative integers
        for (int num : nums) {
            if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            }
        }

        // Return the maximum count between positive and negative integers
        return Math.max(pos, neg);
    }

}
