package com.lastStoneWeight;
import java.util.*;

/*
You are given an array of integers stones where stones[i] is the 
weight of the ith stone.

We are playing a game with the stones. On each turn, we choose 
the heaviest two stones and smash them together. 
Suppose the heaviest two stones have weights x and y with x <= y. 
The result of this smash is:

. If x == y, both stones are destroyed, and
. If x != y, the stone of weight x is destroyed, and the stone of 
	weight y has new weight y - x.

At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. 
If there are no stones left, return 0.


Example 1:

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's 
the value of the last stone.

Example 2:

Input: stones = [1]
Output: 1
*/

public class E1046_Last_Stone_Weight {

	public static void main(String[] args) {
//		int[] input = {2,7,4,1,8,1};
//		int[] input = {7,6,7,6,9};
		int[] input = {9,10,1,7,3};
		int output = lastStoneWeight(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Put all elements into a priority queue.
	Pop out the two biggest, push back the difference,
	until there are no more two elements left.
    */
	
	/*
     * @param stones: an array
     * @return: the weight of the last remaining stone
     */
	public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        for (int a : stones) {
            pq.offer(a);
        }
        while (pq.size() > 1) {
            pq.offer(pq.poll() - pq.poll());
        }
        return pq.poll();
    }

}
