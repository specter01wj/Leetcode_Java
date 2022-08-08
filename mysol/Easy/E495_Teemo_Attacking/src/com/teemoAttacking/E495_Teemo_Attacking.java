package com.teemoAttacking;
import java.util.*;

/*Our hero Teemo is attacking an enemy Ashe with poison attacks! 
 When Teemo attacks Ashe, Ashe gets poisoned for a exactly duration seconds. 
 More formally, an attack at second t will mean Ashe is poisoned during 
 the inclusive time interval [t, t + duration - 1]. 
 If Teemo attacks again before the poison effect ends, the timer for it is reset, 
 and the poison effect will end duration seconds after the new attack.

You are given a non-decreasing integer array timeSeries, where timeSeries[i] 
denotes that Teemo attacks Ashe at second timeSeries[i], and an integer duration.

Return the total number of seconds that Ashe is poisoned.


Example 1:

Input: timeSeries = [1,4], duration = 2
Output: 4
Explanation: Teemo's attacks on Ashe go as follows:
- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
- At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.

Example 2:

Input: timeSeries = [1,2], duration = 2
Output: 3
Explanation: Teemo's attacks on Ashe go as follows:
- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
- At second 2 however, Teemo attacks again and resets the poison timer. 
Ashe is poisoned for seconds 2 and 3.
Ashe is poisoned for seconds 1, 2, and 3, which is 3 seconds in total.*/

public class E495_Teemo_Attacking {

	public static void main(String[] args) {
		int[] input = {1,2};
        int output = findPoisonedDuration(input, 2);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
	solution:
	对每次攻击与上次攻击的时间差与毒的持续时间进行对比，将较小值算入毒的持续时间即可。
	*/
	
	/**
     * @param timeSeries: the Teemo's attacking ascending time series towards Ashe
     * @param duration: the poisoning time duration per Teemo's attacking
     * @return: the total time that Ashe is in poisoned condition
     */
	public static int findPoisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries == null || timeSeries.length == 0 || duration == 0) {
            return 0;
        }
		
		int result = 0, start = timeSeries[0], end = timeSeries[0] + duration;
		for (int i = 1; i < timeSeries.length; i++) {
			if (timeSeries[i] > end) {
				result += end - start;
				start = timeSeries[i];
			}
			end = timeSeries[i] + duration;
		}
		result += end - start;
		
		return result;
	}

}
