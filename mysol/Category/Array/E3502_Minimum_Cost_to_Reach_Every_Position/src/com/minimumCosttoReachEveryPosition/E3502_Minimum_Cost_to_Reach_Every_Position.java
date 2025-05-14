package com.minimumCosttoReachEveryPosition;
import java.util.*;

/*
You are given an integer array cost of size n. You are currently 
at position n (at the end of the line) in a line of n + 1 people 
(numbered from 0 to n).

You wish to move forward in the line, but each person in front of 
you charges a specific amount to swap places. The cost to swap with 
person i is given by cost[i].

You are allowed to swap places with people as follows:

	. If they are in front of you, you must pay them cost[i] to swap with them.
	. If they are behind you, they can swap with you for free.

Return an array answer of size n, where answer[i] is the minimum total 
cost to reach each position i in the line.
*/

public class E3502_Minimum_Cost_to_Reach_Every_Position {

	public static void main(String[] args) {
		E3502_Minimum_Cost_to_Reach_Every_Position solution = new E3502_Minimum_Cost_to_Reach_Every_Position();
		int[] input = {5,3,4,1,3,2};
		int[] output = solution.minCosts(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. Initialize result array:
		. Create an answer[] array of size n.
		. Fill all entries with Integer.MAX_VALUE
	2. Iterate over the cost array from left to right:
		. For each person i:
			. You pay cost[i] to reach them.
			. From person i, you can move to any person at j ≥ i for free.
			. So update all such answer[j] to min(answer[j], cost[i]).
	3. Apply early break optimization:
		. Since cost propagates forward, if answer[j] <= cost[i], we stop updating further — no better cost will be applied.
    */
	
	/*
     * @param cost: a list of integers
     * @return: an array answer of size n
     */
	public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] answer = new int[n];
        Arrays.fill(answer, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            // Pay cost[i] to reach i
            answer[i] = Math.min(answer[i], cost[i]);

            // From i, we can go to any position ahead for free
            for (int j = i + 1; j < n; j++) {
                // Only propagate if current cost is higher than cost[i]
                if (answer[j] > cost[i]) {
                    answer[j] = cost[i];
                } else {
                    break; // no need to go further since it's already cheaper
                }
            }
        }

        return answer;
    }

}
