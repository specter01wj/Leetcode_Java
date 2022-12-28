package com.mostVisitedSectorinaCircularTrack;
import java.util.*;

/*
Given an integer n and an integer array rounds. We have a circular track 
which consists of n sectors labeled from 1 to n. 
A marathon will be held on this track, the marathon consists of m rounds. 
The ith round starts at sector rounds[i - 1] and ends at sector rounds[i]. 
For example, round 1 starts at sector rounds[0] and ends at sector rounds[1]

Return an array of the most visited sectors sorted in ascending order.

Notice that you circulate the track in ascending order of sector numbers 
in the counter-clockwise direction (See the first example).


Example 1:


Input: n = 4, rounds = [1,3,1,2]
Output: [1,2]
Explanation: The marathon starts at sector 1. 
The order of the visited sectors is as follows:
1 --> 2 --> 3 (end of round 1) --> 4 --> 1 (end of round 2) --> 2 (end of round 3 and the marathon)
We can see that both sectors 1 and 2 are visited twice and they are the most visited sectors. 
Sectors 3 and 4 are visited only once.

Example 2:

Input: n = 2, rounds = [2,1,2,1,2,1,2,1,2]
Output: [2]

Example 3:

Input: n = 7, rounds = [1,3,5,7]
Output: [1,2,3,4,5,6,7]
*/

public class E1560_Most_Visited_Sector_in_a_Circular_Track {

	public static void main(String[] args) {
		int[] input = {1,3,1,2};
		int n = 4;
		List<Integer> output = mostVisited(n, input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    We only need to care the start point and the end point.
    
    If start <= end, return the range [start, end].
	If end < start, return the range [1, end] + range [start, n].
    */
	
	/*
     * @param n: an integer
     * @param rounds: a list of integers
     * @return: an array of the most visited sectors sorted in ascending order
     */
	public static List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        for (int i = rounds[0]; i <= rounds[rounds.length - 1]; ++i) {
            res.add(i);
        }
        if (res.size() > 0) {
            return res;
        }
        for (int i = 1; i <= rounds[rounds.length - 1]; ++i) {
            res.add(i);
        }
        for (int i = rounds[0]; i <= n; ++i) {
            res.add(i);
        }
        return res;
    }

}
