package com.numberofEquivalentDominoPairs;
import java.util.*;

/*
Given a list of dominoes, dominoes[i] = [a, b] is equivalent 
to dominoes[j] = [c, d] if and only if either (a == c and b == d), 
or (a == d and b == c) - that is, one domino can be rotated to be 
equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, 
and dominoes[i] is equivalent to dominoes[j].


Example 1:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1

Example 2:

Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
Output: 3
*/

public class E1128_Number_of_Equivalent_Domino_Pairs {

	public static void main(String[] args) {
		int[][] input = {{1,2},{2,1},{3,4},{5,6}};
		int output = numEquivDominoPairs(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    need to distinguish the different dominoes and count the same.
	in this way: f(domino) = min(d[0], d[1]) * 10 + max(d[0], d[1])
	For each domino d, calculate min(d[0], d[1]) * 10 + max(d[0], d[1])
	This will put the smaller number on the left and bigger one on the right (in decimal).
	So same number same domino, different number different domino.
	
	Take the example from the problem:
	dominoes = [[1,2],[2,1],[3,4],[5,6]]
	now we transform it into [12,12,34,56].
	
	We sum up the pair in the end after the loop,
	using the guass formula sum = v * (v + 1) / 2,
	where v is the number of count.
    */
	
	/*
     * @param dominoes: a list of integer
     * @return: the number of pairs (i, j)
     */
	public static int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int[] d : dominoes) {
            int k = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            count.put(k, count.getOrDefault(k, 0) + 1);
        }
        for (int v : count.values()) {
            res += v * (v - 1) / 2;
        }
        return res;
    }

}
