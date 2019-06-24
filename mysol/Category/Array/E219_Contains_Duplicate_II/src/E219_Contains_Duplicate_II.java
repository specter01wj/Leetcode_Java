import java.util.*;

/*Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/

public class E219_Contains_Duplicate_II {

	public static void main(String[] args) {
		int[] input = {1,2,3,1};//{1,2,3,1,2,3}; 2
        boolean output = containsNearbyDuplicate(input, 3);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    
    */
	
	/**
     * @param nums: the given array
     * @return: if any value appears at least twice in the array
     */
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		
	}

}
