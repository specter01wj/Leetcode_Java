package com.countNumberofPairsWithAbsoluteDifferenceK;
import java.util.*;

/*
Given an integer array nums and an integer k, return the number of pairs (i, j) 
where i < j such that |nums[i] - nums[j]| == k.

The value of |x| is defined as:

	.x if x >= 0.
	.-x if x < 0.


Example 1:

Input: nums = [1,2,2,1], k = 1
Output: 4
Explanation: The pairs with an absolute difference of 1 are:
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]

Example 2:

Input: nums = [1,3], k = 3
Output: 0
Explanation: There are no pairs with an absolute difference of 3.

Example 3:

Input: nums = [3,2,1,5,4], k = 2
Output: 3
Explanation: The pairs with an absolute difference of 2 are:
- [3,2,1,5,4]
- [3,2,1,5,4]
- [3,2,1,5,4]
*/

public class E2006_Count_Number_of_Pairs_With_Absolute_Difference_K {

	public static void main(String[] args) {
		int[] input = {1,2,2,1};
		int k = 1;
		int output = countKDifference(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int countKDifference(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        
        for (int i = 0;i< nums.length;i++){
            if (map.containsKey(nums[i] - k)) {
                res += map.get(nums[i] - k);
            }
            if (map.containsKey(nums[i] + k)) {
                res += map.get(nums[i] + k);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        return res;
    }

}
