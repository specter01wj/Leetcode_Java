package com.checkForTarget;
import java.util.*;

/*
Example 2: Given a sorted array of unique integers and a target integer, 
return true if there exists a pair of numbers that sum to target, false otherwise. 
This problem is similar to Two Sum. (In Two Sum, the input is not sorted).

For example, given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13, 
return true because 4 + 9 = 13.
*/

public class Ch2_checkForTarget {

	public static void main(String[] args) {
		Ch2_checkForTarget solution = new Ch2_checkForTarget();
		int[] input = {1, 2, 4, 6, 8, 9, 14, 15};
		int target = 13;
		boolean output = solution.checkForTarget(input, target);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    two pointers
    */
	
	/*
     * @param nums: a list of integers
     * @param target: an integer
     * @return: boolean
     */
	public boolean checkForTarget(int[] nums, int target) {
	    int left = 0;
	    int right = nums.length - 1;

	    while (left < right) {
	        // curr is the current sum
	        int curr = nums[left] + nums[right];
	        if (curr == target) {
	            return true;
	        }

	        if (curr > target) {
	            right--;
	        } else {
	            left++;
	        }
	    }

	    return false;
	}

}
