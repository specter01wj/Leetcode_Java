package com.onlineStockSpan;
import java.util.*;

/*
Design an algorithm that collects daily price quotes for some stock 
and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of 
consecutive days (starting from that day and going backward) for 
which the stock price was less than or equal to the price of that day.

 .For example, if the prices of the stock in the last four days is [7,2,1,2] 
  and the price of the stock today is 2, then the span of today is 4 because 
  starting from today, the price of the stock was less than or equal 2 for 4 
  consecutive days.
 .Also, if the prices of the stock in the last four days is [7,34,1,2] and the 
  price of the stock today is 8, then the span of today is 3 because starting 
  from today, the price of the stock was less than or equal 8 for 3 consecutive days.

Implement the StockSpanner class:

 .StockSpanner() Initializes the object of the class.
 .int next(int price) Returns the span of the stock's price given that today's 
  price is price.
*/

public class M901_Online_Stock_Span {

	public static void main(String[] args) {
		StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // Output: 1
        System.out.println(stockSpanner.next(80));  // Output: 1
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(70));  // Output: 2
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(75));  // Output: 4
        System.out.println(stockSpanner.next(85));  // Output: 6
	}
	
	
	static class StockSpanner {
	    private Stack<int[]> stack;

	    public StockSpanner() {
	        stack = new Stack<>();
	    }
	    
	    public int next(int price) {
	        int span = 1; // The span of the current price is at least 1
	        // While the stack is not empty and the current price is greater than or equal to
	        // the price at the top of the stack, pop the stack and add the span
	        while (!stack.isEmpty() && stack.peek()[0] <= price) {
	            span += stack.pop()[1];
	        }
	        // Push the current price and its calculated span onto the stack
	        stack.push(new int[]{price, span});
	        return span;
	    }
	}

}
