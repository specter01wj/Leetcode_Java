package com.xofaKindinaDeckofCards;
import java.util.*;

/*In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that 
it is possible to split the entire deck into 1 or more groups of cards, 
where:

Each group has exactly X cards.
All the cards in each group have the same integer.
 

Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false´
Explanation: No possible partition.

Example 3:

Input: deck = [1]
Output: false
Explanation: No possible partition.

Example 4:

Input: deck = [1,1]
Output: true
Explanation: Possible partition [1,1].

Example 5:

Input: deck = [1,1,2,2,2,2]
Output: true
Explanation: Possible partition [1,1],[2,2],[2,2].*/

public class E914_X_of_a_Kind_in_a_Deck_of_Cards {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,4,3,2,1};
        boolean output = hasGroupsSizeX(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    计数统计出现的数字的次数，然后对于出现的次数进行去最大公约数。若最大公约数小于2，
    则返回False，否则返回True
    */
	
	/**
     * @param deck: a integer array
     * @return: return a value of bool
     */
	public static boolean hasGroupsSizeX(int[] deck) {
		Map<Integer, Integer> map = new HashMap<>();
		int answer = 0;
		
		for(int i : deck) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		for(int i : map.values()) {
			answer = greatest_common_divisor(i, answer);
		}
		
		return answer > 1;
	}
	
	public static int greatest_common_divisor(int a, int b) {
		return b > 0 ? greatest_common_divisor(b, a % b) : a;
	}

}
