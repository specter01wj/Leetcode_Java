package com.minimumAmountofTimetoFillCups;
import java.util.*;

/*
You have a water dispenser that can dispense cold, warm, and hot water. 
Every second, you can either fill up 2 cups with different types of water, 
or 1 cup of any type of water.

You are given a 0-indexed integer array amount of length 3 where amount[0], 
amount[1], and amount[2] denote the number of cold, warm, and hot water 
cups you need to fill respectively. 
Return the minimum number of seconds needed to fill up all the cups.


Example 1:

Input: amount = [1,4,2]
Output: 4
Explanation: One way to fill up the cups is:
Second 1: Fill up a cold cup and a warm cup.
Second 2: Fill up a warm cup and a hot cup.
Second 3: Fill up a warm cup and a hot cup.
Second 4: Fill up a warm cup.
It can be proven that 4 is the minimum number of seconds needed.


Example 2:

Input: amount = [5,4,4]
Output: 7
Explanation: One way to fill up the cups is:
Second 1: Fill up a cold cup, and a hot cup.
Second 2: Fill up a cold cup, and a warm cup.
Second 3: Fill up a cold cup, and a warm cup.
Second 4: Fill up a warm cup, and a hot cup.
Second 5: Fill up a cold cup, and a hot cup.
Second 6: Fill up a cold cup, and a warm cup.
Second 7: Fill up a hot cup.
Example 3:

Input: amount = [5,0,0]
Output: 5
Explanation: Every second, we fill up a cold cup.
*/

public class E2335_Minimum_Amount_of_Time_to_Fill_Cups {

	public static void main(String[] args) {
		int[] input = {1,4,2};
		int output = fillCups(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. res >= max(A)
	Because each time,
	one type can reduce at most 1 cup,
	so the final result is bigger or equal to max(A)
	
	2. res >= ceil(sum(A) / 2)
	Because each time,
	we can fill up to 2 cups,
	so the final result is bigger or equal to ceil(sum(A) / 2)
    */
	
	/*
     * @param amount: a list of integers
     * @return: the minimum number of seconds needed to fill up all the cups
     */
	public static int fillCups(int[] amount) {
		int max = 0, sum = 0;
		for (int i : amount) {
			max = Math.max(i, max);
			sum += i;
		}
		
		return Math.max(max, (sum + 1) / 2);
	}

}
