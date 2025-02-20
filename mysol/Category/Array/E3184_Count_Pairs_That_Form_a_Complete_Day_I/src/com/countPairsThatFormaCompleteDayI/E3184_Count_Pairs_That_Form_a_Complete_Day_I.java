package com.countPairsThatFormaCompleteDayI;
import java.util.*;

/*
Given an integer array hours representing times in hours, 
return an integer denoting the number of pairs i, j where 
i < j and hours[i] + hours[j] forms a complete day.

A complete day is defined as a time duration that is an 
exact multiple of 24 hours.

For example, 1 day is 24 hours, 2 days is 48 hours, 3 days 
is 72 hours, and so on.
*/

public class E3184_Count_Pairs_That_Form_a_Complete_Day_I {

	public static void main(String[] args) {
		E3184_Count_Pairs_That_Form_a_Complete_Day_I solution = new E3184_Count_Pairs_That_Form_a_Complete_Day_I();
		int[] input = {12,12,30,24,24};
		int output = solution.countCompleteDayPairs(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Use a HashMap to store the remainder of each element when divided by 24.
	2. For each number hour, compute remainder = hour % 24.
	3. Check how many times the complement (24 - remainder) % 24 has appeared before.
	4. Increment the count accordingly.
	5. Finally, update the map to record the occurrence of the current remainder.
    */
	
	/*
     * @param hours: a list of integers
     * @return: an integer denoting the number of pairs i, j
     */
	public int countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        int count = 0;

        for (int hour : hours) {
            int remainder = hour % 24;
            int complement = (24 - remainder) % 24;
            
            count += remainderCount.getOrDefault(complement, 0);
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

}
