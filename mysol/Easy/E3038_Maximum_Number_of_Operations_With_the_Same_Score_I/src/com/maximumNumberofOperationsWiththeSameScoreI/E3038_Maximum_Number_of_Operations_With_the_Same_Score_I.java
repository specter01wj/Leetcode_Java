package com.maximumNumberofOperationsWiththeSameScoreI;
import java.util.*;

/*
You are given an array of integers nums. Consider the following operation:

	. Delete the first two elements nums and define the score of the operation as the sum of these two elements.

You can perform this operation until nums contains fewer than two elements. 
Additionally, the same score must be achieved in all operations.

Return the maximum number of operations you can perform.
*/

public class E3038_Maximum_Number_of_Operations_With_the_Same_Score_I {

	public static void main(String[] args) {
		E3038_Maximum_Number_of_Operations_With_the_Same_Score_I solution = new E3038_Maximum_Number_of_Operations_With_the_Same_Score_I();
		int[] input = {3,2,1,4,5};
		int output = solution.maxOperations(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    loop
    */
	
	/*
     * @param nums: a list of integers
     * @return: the maximum number of operations you can perform
     */
	public int maxOperations(int[] nums) {
        // If there are fewer than two elements, no operations can be performed
        if (nums.length < 2) return 0;

        // Calculate the initial score using the first two elements
        int prev = nums[0] + nums[1], count = 1;

        // Iterate through the array, checking pairs of elements
        for (int i = 2; i < nums.length - 1; i += 2) {
            // If the current pair's sum matches the previous score, increment count
            if (nums[i] + nums[i + 1] == prev) {
                count++;
            } else {
                // If the score changes, stop processing further
                break;
            }
        }

        // Return the maximum number of operations with the same score
        return count;
    }

}
