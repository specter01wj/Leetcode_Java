package com.minimumDistancetotheTargetElement;
import java.util.*;

/*
Given an integer array nums (0-indexed) and two integers target and start, 
find an index i such that nums[i] == target and abs(i - start) is minimized. 
Note that abs(x) is the absolute value of x.

Return abs(i - start).

It is guaranteed that target exists in nums.


Example 1:

Input: nums = [1,2,3,4,5], target = 5, start = 3
Output: 1
Explanation: nums[4] = 5 is the only value equal to target, so the answer is abs(4 - 3) = 1.

Example 2:

Input: nums = [1], target = 1, start = 0
Output: 0
Explanation: nums[0] = 1 is the only value equal to target, so the answer is abs(0 - 0) = 0.

Example 3:

Input: nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0
Output: 0
Explanation: Every value of nums is 1, but nums[0] minimizes abs(i - start), which is abs(0 - 0) = 0.
*/

public class E1848_Minimum_Distance_to_the_Target_Element {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5};
		int output = getMinDistance(input, 5, 3);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Iterate all values and check if it equals to target.
    */
	
	/*
     * @param nums: a list of integers
     * @param target: an integer
     * @param start: an integer
     * @return: abs(i - start)
     */
	public static int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans = Math.min(ans, Math.abs(i - start));
            }
        }
        return ans;
    }

}
