import java.util.*;

/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell 
the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             */

public class H188_Best_Time_to_Buy_and_Sell_Stock_IV {

	public static void main(String[] args) {
		int[] input = {3,2,6,5,0,3};//{2,4,1};
        int output = maxProfit4(2, input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    The points of interest are the peaks and valleys in the given graph. 
    We need to find the largest peak following the smallest valley. 
    We can maintain two variables - minprice and maxprofit corresponding 
    to the smallest valley and maximum profit (maximum difference between 
    selling price and minprice) obtained so far respectively.
    */
	
	/*
	 * @param k: An integer
     * @param prices: a list of integers
     * @return: find a maximum profit
     */
	public static int maxProfit4(int k, int[] prices) {
		int n = prices.length;
        if (k >= n / 2) k = n / 2;
        if(n == 0 || k == 0) return 0;
        int[][] dp = new int[2][n];
        
        for(int t=1; t <= k; t++){
            int max = -Integer.MAX_VALUE;
            for(int d=1; d < n; d++){
                max = Math.max(max, dp[0][d-1] - prices[d-1]);
                dp[1][d] = Math.max(dp[1][d-1], max + prices[d]);
            }
            dp[0] = Arrays.copyOf(dp[1], n);
        }
        return dp[1][n-1];
	}

}
