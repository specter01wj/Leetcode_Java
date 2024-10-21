package com.findtheDistinctDifferenceArray;
import java.util.*;

/*
You are given a 0-indexed array nums of length n.

The distinct difference array of nums is an array diff of length 
n such that diff[i] is equal to the number of distinct elements in 
the suffix nums[i + 1, ..., n - 1] subtracted from the number of 
distinct elements in the prefix nums[0, ..., i].

Return the distinct difference array of nums.

Note that nums[i, ..., j] denotes the subarray of nums starting at 
index i and ending at index j inclusive. Particularly, if i > j then 
nums[i, ..., j] denotes an empty subarray.
*/

public class E2670_Find_the_Distinct_Difference_Array {

	public static void main(String[] args) {
		E2670_Find_the_Distinct_Difference_Array solution = new E2670_Find_the_Distinct_Difference_Array();
		int[] input = {1,2,3,4,5};
		int[] output = solution.distinctDifferenceArray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. Prefix and Suffix Sets: We use two HashSets to track the distinct 
    	elements in the prefix and suffix subarrays.
	2. Suffix Distinct Count: We iterate from the end of the array to count 
		the distinct elements in the suffix starting from each index and 
		store it in an array suffixDistinctCount.
	3. Result Calculation: For each index i, we calculate the number of 
		distinct elements in the prefix (using prefixSet.size()) and the 
		number of distinct elements in the suffix 
		(using suffixDistinctCount[i + 1] if it exists, otherwise 0).
	4. The result at each index is the difference between these two counts.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the distinct difference array of nums
     */
	public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Sets to keep track of distinct elements in prefix and suffix
        HashSet<Integer> prefixSet = new HashSet<>();
        HashSet<Integer> suffixSet = new HashSet<>();

        // Calculate the suffix distinct counts for each index
        int[] suffixDistinctCount = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            suffixSet.add(nums[i]);
            suffixDistinctCount[i] = suffixSet.size();
        }

        // Iterate through each index and calculate the result array
        for (int i = 0; i < n; i++) {
            prefixSet.add(nums[i]);

            // Distinct elements in the prefix is prefixSet.size()
            // Distinct elements in the suffix is suffixDistinctCount[i+1] (or 0 if no suffix)
            int suffixCount = (i + 1 < n) ? suffixDistinctCount[i + 1] : 0;
            result[i] = prefixSet.size() - suffixCount;
        }

        return result;
    }

}
