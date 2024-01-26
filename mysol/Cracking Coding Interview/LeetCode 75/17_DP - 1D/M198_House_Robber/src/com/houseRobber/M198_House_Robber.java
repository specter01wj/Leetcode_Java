package com.houseRobber;
import java.util.*;

/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint 
stopping you from robbing each of them is that adjacent houses have 
security systems connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without 
alerting the police.
*/

public class M198_House_Robber {

	public static void main(String[] args) {
		int[] input = {2,7,9,3,1};
		int output = rob(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        
        return dp[nums.length - 1];
    }

}
