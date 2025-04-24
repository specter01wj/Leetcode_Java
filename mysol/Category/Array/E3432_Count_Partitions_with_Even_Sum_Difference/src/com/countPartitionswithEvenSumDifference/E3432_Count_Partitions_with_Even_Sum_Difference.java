package com.countPartitionswithEvenSumDifference;
import java.util.*;

/*
You are given an integer array nums of length n.

A partition is defined as an index i where 0 <= i < n - 1, splitting 
the array into two non-empty subarrays such that:

	. Left subarray contains indices [0, i].
	. Right subarray contains indices [i + 1, n - 1].

Return the number of partitions where the difference between the sum 
of the left and right subarrays is even.
*/

public class E3432_Count_Partitions_with_Even_Sum_Difference {

	public static void main(String[] args) {
		E3432_Count_Partitions_with_Even_Sum_Difference solution = new E3432_Count_Partitions_with_Even_Sum_Difference();
		int[] input = {10,10,3,7,6};
		int output = solution.countPartitions(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Compute totalSum of the array
		This allows quick calculation of the right subarray sum at each partition:
		. rightSum = totalSum - leftSum
	2. Iterate through the array up to index n - 2
		. Maintain a running sum leftSum
		. For each partition index i, compute:
			. rightSum = totalSum - leftSum
			. Check if (leftSum - rightSum) % 2 == 0
		. If yes, increment the count
	3. Return the total valid count
    */
	
	/*
     * @param nums: a list of integers
     * @return: the number of partitions
     */
	public int countPartitions(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        int count = 0;

        // Traverse the array, excluding the last element for valid partitions
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            int rightSum = totalSum - leftSum;

            if (Math.abs(leftSum - rightSum) % 2 == 0) {
                count++;
            }
        }

        return count;
    }

}
