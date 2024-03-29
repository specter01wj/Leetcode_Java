package com.countSpecialQuadruplets;
import java.util.*;

/*
Given a 0-indexed integer array nums, return the number of distinct 
quadruplets (a, b, c, d) such that:

	.nums[a] + nums[b] + nums[c] == nums[d], and
	.a < b < c < d


Example 1:

Input: nums = [1,2,3,6]
Output: 1
Explanation: The only quadruplet that satisfies the requirement is (0, 1, 2, 3) 
because 1 + 2 + 3 == 6.

Example 2:

Input: nums = [3,3,6,4,5]
Output: 0
Explanation: There are no such quadruplets in [3,3,6,4,5].

Example 3:

Input: nums = [1,1,1,3,5]
Output: 4
Explanation: The 4 quadruplets that satisfy the requirement are:
- (0, 1, 2, 3): 1 + 1 + 1 == 3
- (0, 1, 3, 4): 1 + 1 + 3 == 5
- (0, 2, 3, 4): 1 + 1 + 3 == 5
- (1, 2, 3, 4): 1 + 1 + 3 == 5
*/

public class E1995_Count_Special_Quadruplets {

	public static void main(String[] args) {
		int[] input = {1,1,1,3,5};
		int output = countQuadruplets(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    a + b + c = d = > a + b = d - c
	Break array into two parts[0, i - 1] and [i, n -1]
	for each i,
	step 1: calculate all possible d - c and put them in a hashMap called diffCount .
	d - c = nums[j] - nums[i]. for all j [i + 1, n - 1]
	step 2: calculate all possible a + b in the 1st part. Then check if any a + b in the hashMap diffCount
	a + b = nums[j] + nums[i - 1], for all j [0, i - 2]
    */
	
	/*
     * @param nums: a list of integers
     * @return: the number of distinct quadruplets (a, b, c, d)
     */
	public static int countQuadruplets(int[] nums) {
        int res = 0;
        int len = nums.length;
        
        Map<Integer, Integer> count = new HashMap<>();
        count.put(nums[len-1] - nums[len-2], 1);
        
        for (int b = len - 3; b >= 1; b--) {
            for (int a = b - 1; a >= 0; a--) {
                res += count.getOrDefault(nums[a] + nums[b], 0);
            }
            
            for (int x = len - 1; x > b; x--) {
                count.put(nums[x] - nums[b], count.getOrDefault(nums[x] - nums[b], 0) + 1);
            }
        }
        
        return res;
    }

}
