package com.minimumCosttoMoveChipstoTheSamePosition;
import java.util.*;

/*
We have n chips, where the position of the ith chip is position[i].

We need to move all the chips to the same position. In one step, 
we can change the position of the ith chip from position[i] to:

. position[i] + 2 or position[i] - 2 with cost = 0.
. position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.


Example 1:

Input: position = [1,2,3]
Output: 1
Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
Second step: Move the chip at position 2 to position 1 with cost = 1.
Total cost is 1.

Example 2:

Input: position = [2,2,2,3,3]
Output: 2
Explanation: We can move the two chips at position  3 to position 2. 
Each move has cost = 1. The total cost = 2.

Example 3:

Input: position = [1,1000000000]
Output: 1
*/

public class E1217_Minimum_Cost_to_Move_Chips_to_The_Same_Position {

	public static void main(String[] args) {
		int[] input = {2,2,2,3,3};
		int output = minCostToMoveChips(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Since no cost to move even steps, all elements at even/odd indices 
    	can move to index 0/1 respectively without cost;
	2. Compare the count of elements at index 0 with that at 1, each of 
		them need cost 1 to move to index 1/0 respectively; return the lesser.
    */
	
	/*
     * @param position: a list of integer
     * @return: the minimum cost needed to move all the chips to the same position
     */
	public static int minCostToMoveChips(int[] position) {
        int[] cnt = new int[2];
        for (int i : position) {
            ++cnt[i % 2];
        }
        return Math.min(cnt[0], cnt[1]);
    }

}
