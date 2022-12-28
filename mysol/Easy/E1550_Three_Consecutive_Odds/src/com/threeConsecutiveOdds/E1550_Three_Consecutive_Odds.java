package com.threeConsecutiveOdds;
import java.util.*;

/*
Given an integer array arr, return true if there are three consecutive 
odd numbers in the array. Otherwise, return false.


Example 1:

Input: arr = [2,6,4,1]
Output: false
Explanation: There are no three consecutive odds.

Example 2:

Input: arr = [1,2,34,3,4,5,7,23,12]
Output: true
Explanation: [5,7,23] are three consecutive odds.
*/

public class E1550_Three_Consecutive_Odds {

	public static void main(String[] args) {
		int[] input = {1,2,34,3,4,5,7,23,12};
		boolean output = threeConsecutiveOdds(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    simple loop
    */
	
	/*
     * @param arr: a list of integers
     * @return: true if there are three consecutive odd numbers in the array
     */
	public static boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0, cnt = 0; i < arr.length; i++) {
        	if (arr[i] % 2 == 0) {
        		cnt = 0;
        	} else if (++cnt == 3) {
        		return true;
        	}
        }
        
        return false;
    }

}
