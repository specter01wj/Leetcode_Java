package com.bestTimetoBuyandSellStockwithTransactionFee;
import java.util.*;

/*
You are given an array prices where prices[i] is the price of a given 
stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many 
transactions as you like, but you need to pay the transaction fee for 
each transaction.
*/

public class M714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

	public static void main(String[] args) {
		int[] input = {1,3,2,8,4,9};
		int fee = 2;
		int output = maxProfit(input, fee);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Dynamic Programming
    */
	
	/*
     * @param prices: a list of integers
     * @param fee: an integer
     * @return: the maximum profit you can achieve
     */
	public static int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int cash = 0;  // Maximum profit we can have if we do not hold a stock
        int hold = -prices[0];  // Maximum profit we can have if we hold a stock

        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);  // Sell the stock
            hold = Math.max(hold, cash - prices[i]);  // Buy the stock
        }

        return cash;
    }

}
