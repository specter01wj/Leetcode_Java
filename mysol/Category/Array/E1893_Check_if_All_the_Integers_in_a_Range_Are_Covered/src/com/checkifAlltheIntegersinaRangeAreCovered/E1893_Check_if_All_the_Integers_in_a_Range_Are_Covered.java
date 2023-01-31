package com.checkifAlltheIntegersinaRangeAreCovered;
import java.util.*;

/*
You are given a 2D integer array ranges and two integers left and right. 
Each ranges[i] = [starti, endi] represents an inclusive interval between starti and endi.

Return true if each integer in the inclusive range [left, right] is covered by 
at least one interval in ranges. Return false otherwise.

An integer x is covered by an interval ranges[i] = [starti, endi] if starti <= x <= endi.


Example 1:

Input: ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
Output: true
Explanation: Every integer between 2 and 5 is covered:
- 2 is covered by the first range.
- 3 and 4 are covered by the second range.
- 5 is covered by the third range.

Example 2:

Input: ranges = [[1,10],[10,20]], left = 21, right = 21
Output: false
Explanation: 21 is not covered by any range.
*/

public class E1893_Check_if_All_the_Integers_in_a_Range_Are_Covered {

	public static void main(String[] args) {
		int[][] input = {{1,2},{3,4},{5,6}};
		boolean output = isCovered(input, 2, 5);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public static boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (x,y)->x[0]-y[0]);
        for(int[] range: ranges) {
            if(left >= range[0] && left <= range[1]) {
                left = range[1] + 1;
            }
        }
        return left > right;
    }

}
