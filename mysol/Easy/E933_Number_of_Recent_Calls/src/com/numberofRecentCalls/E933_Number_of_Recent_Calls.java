package com.numberofRecentCalls;
import java.util.*;

/*
You have a RecentCounter class which counts the number of recent 
requests within a certain time frame.

Implement the RecentCounter class:

 .RecentCounter() Initializes the counter with zero recent requests.
 .int ping(int t) Adds a new request at time t, where t represents 
  some time in milliseconds, and returns the number of requests that 
  has happened in the past 3000 milliseconds (including the new request). 
  Specifically, return the number of requests that have happened in the 
  inclusive range [t - 3000, t].

It is guaranteed that every call to ping uses a strictly larger value 
of t than the previous call.
*/

public class E933_Number_of_Recent_Calls {

	public static void main(String[] args) {
		RecentCounter obj = new RecentCounter();
		int t1= 100;
		int param_1 = obj.ping(t1);
	}
	
	/*
    solution:
    Queue
    */
	
	/*
     * @param t: an integer
     * @return:  the number of requests
     */
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

}
