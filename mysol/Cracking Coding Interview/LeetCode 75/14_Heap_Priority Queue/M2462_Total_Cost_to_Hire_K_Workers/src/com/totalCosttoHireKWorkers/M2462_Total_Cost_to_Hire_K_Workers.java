package com.totalCosttoHireKWorkers;
import java.util.*;

/*
You are given a 0-indexed integer array costs where costs[i] is 
the cost of hiring the ith worker.

You are also given two integers k and candidates. We want to hire 
exactly k workers according to the following rules:

 .You will run k sessions and hire exactly one worker in each session.
 .In each hiring session, choose the worker with the lowest cost from 
  either the first candidates workers or the last candidates workers. 
  Break the tie by the smallest index.
	.For example, if costs = [3,2,7,7,1,2] and candidates = 2, 
	 then in the first hiring session, we will choose the 4th 
	 worker because they have the lowest cost [3,2,7,7,1,2].
	.In the second hiring session, we will choose 1st worker 
	 because they have the same lowest cost as 4th worker but 
	 they have the smallest index [3,2,7,7,2]. Please note that 
	 the indexing may be changed in the process.
 .If there are fewer than candidates workers remaining, choose 
  the worker with the lowest cost among them. Break the tie by 
  the smallest index.
 .A worker can only be chosen once.

Return the total cost to hire exactly k workers.
*/

public class M2462_Total_Cost_to_Hire_K_Workers {

	public static void main(String[] args) {
		int[] input = {17,12,10,2,7,2,11,20,8};
		int k = 3, candidates = 4;
		long output = totalCost(input, k, candidates);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Priority Queue
    */
	
	/*
     * @param costs: a list of integers
     * @param k: an integer
     * @param candidates: an integer
     * @return: the total cost to hire exactly k workers
     */
	public static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headWorkers = new PriorityQueue<>();
        PriorityQueue<Integer> tailWorkers = new PriorityQueue<>();
        
        for (int i = 0; i < candidates; i++) {
            headWorkers.add(costs[i]);
        }
        for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
            tailWorkers.add(costs[i]);
        }

        long answer = 0;
        int nextHead = candidates;
        int nextTail = costs.length - 1 - candidates;

        for (int i = 0; i < k; i++) {
            if (tailWorkers.isEmpty() || !headWorkers.isEmpty() && headWorkers.peek() <= tailWorkers.peek()) {
                answer += headWorkers.poll();
                
                if (nextHead <= nextTail) {
                    headWorkers.add(costs[nextHead]);
                    nextHead++;
                }
            } 
            
            else {
                answer += tailWorkers.poll();
                
                if (nextHead <= nextTail) {
                    tailWorkers.add(costs[nextTail]);
                    nextTail--;
                }
            }
        }

        return answer;
    }

}
