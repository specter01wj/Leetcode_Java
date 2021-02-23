package com.minCostClimbingStairs;
import java.util.*;

/*On a staircase, the i-th step has some non-negative cost cost[i] 
assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. 
You need to find minimum cost to reach the top of the floor, 
and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].*/

public class E746_Min_Cost_Climbing_Stairs {

	public static void main(String[] args) {
		int[] input = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int output = minCostClimbingStairs(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    经典的动态规划问题 状态转移方程 dpi = min(dpi-1 + costi-1,dpi-2 + costi-2)
    */
	
	/**
     * @param cost: an array
     * @return: minimum cost to reach the top of the floor
     */
	public static int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length + 1];
		dp[0] = 0;
		dp[1] = 0;
		
		for(int i = 2; i < dp.length; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
		}
		
		return dp[cost.length];
	}

}
