import java.util.*;

/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell 
the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

public class H123_Best_Time_to_Buy_and_Sell_Stock_III {

	public static void main(String[] args) {
		int[] input = {3,3,5,0,0,3,1,4};//{7,1,5,3,6,4};
        int output = maxProfit3(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    
    */
	
	/*
     * @param prices: a list of integers
     * @return: find a maximum profit
     */
	public static int maxProfit3(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int [][]dp = new int[n + 1][5 + 1];
        
        for (int k = 1; k <= 5; k++) {
            dp[0][k] = Integer.MIN_VALUE;
        }
        dp[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            // 手中未持有股票
            for (int j = 1; j <= 5; j += 2) {
                // 前一天也未持有
                dp[i][j] = dp[i - 1][j];
                if (j > 1 && i > 1 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    // 前一天持有，今天卖了获利。
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            // 手中持有股票
            for (int j = 2; j <= 5; j += 2) {
                //前一天未持有，今天买进
                dp[i][j] = dp[i - 1][j - 1];
                if (i > 1 && dp[i - 1][j] != Integer.MIN_VALUE) {
                    // 前一天持有了，计算今天的利润
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
            }
        }
        
        int res = 0;
        for (int j = 1; j <= 5; j += 2) {
            res = Math.max(res, dp[n][j]);
        }
        return res;
    }

}
