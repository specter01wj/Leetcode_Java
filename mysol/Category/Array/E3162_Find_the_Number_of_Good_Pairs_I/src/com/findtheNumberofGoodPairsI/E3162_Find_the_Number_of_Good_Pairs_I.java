package com.findtheNumberofGoodPairsI;
import java.util.*;

/*
You are given 2 integer arrays nums1 and nums2 of lengths n 
and m respectively. You are also given a positive integer k.

A pair (i, j) is called good if nums1[i] is divisible by 
nums2[j] * k (0 <= i <= n - 1, 0 <= j <= m - 1).

Return the total number of good pairs.
*/

public class E3162_Find_the_Number_of_Good_Pairs_I {

	public static void main(String[] args) {
		E3162_Find_the_Number_of_Good_Pairs_I solution = new E3162_Find_the_Number_of_Good_Pairs_I();
		int[] nums1 = {1,2,4,12}, nums2 = {2,4};
		int k = 3;
		int output = solution.numberOfPairs(nums1, nums2, k);
        System.out.println("input: " + Arrays.toString(nums1) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Iterate through each element in nums1 using index i.
	2. Iterate through each element in nums2 using index j.
	3. Check if nums1[i] is divisible by nums2[j] * k using the modulo condition nums1[i] % (nums2[j] * k) == 0.
	4. If the condition is satisfied, increase the count.
	5. Return the total count of good pairs.
    */
	
	/*
     * @param nums1: a list of integers
     * @param nums2: a list of integers
     * @param k: an integer
     * @return: the total number of good pairs
     */
	public int numberOfPairs(int[] nums1, int[] nums2, int k) {
		int count = 0;
		
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] % (nums2[j] * k) == 0) {
					count++;
				}
			}
		}
		
		return count;
	}

}
