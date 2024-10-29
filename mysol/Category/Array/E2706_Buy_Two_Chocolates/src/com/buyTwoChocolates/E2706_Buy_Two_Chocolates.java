package com.buyTwoChocolates;
import java.util.*;

/*
You are given an integer array prices representing the prices of 
various chocolates in a store. You are also given a single integer money, 
which represents your initial amount of money.

You must buy exactly two chocolates in such a way that you still have 
some non-negative leftover money. You would like to minimize the sum of 
the prices of the two chocolates you buy.

Return the amount of money you will have leftover after buying the two 
chocolates. If there is no way for you to buy two chocolates without 
ending up in debt, return money. Note that the leftover must be non-negative.
*/

public class E2706_Buy_Two_Chocolates {

	public static void main(String[] args) {
		E2706_Buy_Two_Chocolates solution = new E2706_Buy_Two_Chocolates();
		int[] input = {3,2,3};
		int money = 3;
		int output = solution.buyChoco(input, money);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int buyChoco(int[] prices, int money) {
        // Sort the array to get the two cheapest chocolates
        Arrays.sort(prices);

        // Calculate the sum of the two cheapest chocolates
        int cost = prices[0] + prices[1];

        // Check if the total cost is within the available money
        if (cost <= money) {
            return money - cost; // Return the remaining money
        } else {
            return money; // Not enough money, return original amount
        }
    }

}
