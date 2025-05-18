package com.richestCustomerWealth;
import java.util.*;

/*
You are given an m x n integer grid accounts where accounts[i][j] 
is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. 
Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. 
The richest customer is the customer that has the maximum wealth.
*/

public class E1672_Richest_Customer_Wealth {

	public static void main(String[] args) {
		E1672_Richest_Customer_Wealth solution = new E1672_Richest_Customer_Wealth();
		int[][] input = {{1,5},{7,3},{3,5}};
		int output = solution.maximumWealth(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int[] customer : accounts) {
            int sum = 0;

            for (int money : customer) {
                sum += money;
            }
            maxWealth = Math.max(maxWealth, sum);
        }

        return maxWealth;
    }

}
