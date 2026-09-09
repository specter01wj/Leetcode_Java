package com.jinwang;

import java.util.Arrays;
import java.util.Stack;

public class E1475_Final_Prices_With_A_Special_Discount_In_A_Shop {

	public static void main(String[] args) {
		E1475_Final_Prices_With_A_Special_Discount_In_A_Shop solution =
                new E1475_Final_Prices_With_A_Special_Discount_In_A_Shop();

        // Example 1
        int[] prices1 = {8, 4, 6, 2, 3};

        System.out.println("Input: " + Arrays.toString(prices1));
        System.out.println("Output: " + Arrays.toString(solution.finalPrices(prices1)));
        System.out.println();

        // Example 2
        int[] prices2 = {1, 2, 3, 4, 5};

        System.out.println("Input: " + Arrays.toString(prices2));
        System.out.println("Output: " + Arrays.toString(solution.finalPrices(prices2)));
        System.out.println();

        // Example 3
        int[] prices3 = {10, 1, 1, 6};

        System.out.println("Input: " + Arrays.toString(prices3));
        System.out.println("Output: " + Arrays.toString(solution.finalPrices(prices3)));
	}
	
	public int[] finalPrices(int[] prices) {
        int[] answer = Arrays.copyOf(prices, prices.length);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                answer[index] = prices[index] - prices[i];
            }

            stack.push(i);
        }

        return answer;
    }

}
