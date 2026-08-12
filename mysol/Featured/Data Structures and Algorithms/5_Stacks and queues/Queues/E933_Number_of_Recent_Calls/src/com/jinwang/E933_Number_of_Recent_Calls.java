package com.jinwang;

import java.util.LinkedList;
import java.util.Queue;

public class E933_Number_of_Recent_Calls {

	public static void main(String[] args) {
		RecentCounter recentCounter = new RecentCounter();

		int input1 = 1;
		int output1 = recentCounter.ping(input1);
		System.out.println("Input: " + input1 + "\nOutput: " + output1);
		
		int input2 = 100;
		int output2 = recentCounter.ping(input2);
		System.out.println("\nInput: " + input2 + "\nOutput: " + output2);
		
		int input3 = 3001;
		int output3 = recentCounter.ping(input3);
		System.out.println("\nInput: " + input3 + "\nOutput: " + output3);
		
		int input4 = 3002;
		int output4 = recentCounter.ping(input4);
		System.out.println("\nInput: " + input4 + "\nOutput: " + output4);
	}

}

class RecentCounter {

	private Queue<Integer> requests;
	
	public RecentCounter() {
		this.requests = new LinkedList<>();
	}
	public int ping(int t) {
		// Add new request timestamp
		requests.offer(t);
		
		// Remove older requests outside the 3000ms window
		while (!requests.isEmpty() && requests.peek() < t - 3000) {
			requests.poll();
		}
		
		// Return the number of requests in the window
		return requests.size();
	}

}