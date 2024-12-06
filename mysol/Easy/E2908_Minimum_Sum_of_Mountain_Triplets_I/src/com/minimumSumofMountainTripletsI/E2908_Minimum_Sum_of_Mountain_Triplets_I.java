package com.minimumSumofMountainTripletsI;
import java.util.*;

/*
You are given a 0-indexed array nums of integers.

A triplet of indices (i, j, k) is a mountain if:

	. i < j < k
	. nums[i] < nums[j] and nums[k] < nums[j]

Return the minimum possible sum of a mountain triplet of nums. 
If no such triplet exists, return -1.
*/

public class E2908_Minimum_Sum_of_Mountain_Triplets_I {

	public static void main(String[] args) {
		E2908_Minimum_Sum_of_Mountain_Triplets_I solution = new E2908_Minimum_Sum_of_Mountain_Triplets_I();
		int[] input = {5,4,8,7,10,2};
		int output = solution.minimumSum(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Iterate Through Middle Element (j):
		. The middle element j is the peak of the mountain, and it must 
			satisfy nums[i] < nums[j] and nums[k] < nums[j].
	2. Find Valid Left (i):
		. For each j, iterate through all elements to the left and find 
			the smallest valid i where nums[i] < nums[j].
	3. Find Valid Right (k):
		. Similarly, iterate through all elements to the right of j to 
			find the smallest valid k where nums[k] < nums[j].
	4. Check and Update Minimum Sum:
		. If both i and k are valid, calculate the sum of the triplet 
			and update minSum.
	5. Handle Edge Case:
		. If no valid mountain triplet is found, return -1.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the minimum possible sum of a mountain triplet of nums
     */
	public int minimumSum(int[] nums) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;
        boolean hasMountain = false;

        // Iterate through the middle element of the triplet (j)
        for (int j = 1; j < n - 1; j++) {
            int leftMin = Integer.MAX_VALUE;
            int rightMin = Integer.MAX_VALUE;

            // Find the smallest valid i (nums[i] < nums[j]) to the left of j
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    leftMin = Math.min(leftMin, nums[i]);
                }
            }

            // Find the smallest valid k (nums[k] < nums[j]) to the right of j
            for (int k = j + 1; k < n; k++) {
                if (nums[k] < nums[j]) {
                    rightMin = Math.min(rightMin, nums[k]);
                }
            }

            // If valid i and k are found, calculate the mountain triplet sum
            if (leftMin != Integer.MAX_VALUE && rightMin != Integer.MAX_VALUE) {
                hasMountain = true;
                int currentSum = leftMin + nums[j] + rightMin;
                minSum = Math.min(minSum, currentSum);
            }
        }

        // Return the minimum sum if a mountain triplet exists, otherwise -1
        return hasMountain ? minSum : -1;
    }

}
