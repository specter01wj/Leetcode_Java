package com.nonoverlappingIntervals;
import java.util.*;

/*
Given an array of intervals intervals where intervals[i] = [starti, endi], 
return the minimum number of intervals you need to remove to make the rest 
of the intervals non-overlapping.
*/

public class M435_Nonoverlapping_Intervals {

	public static void main(String[] args) {
		int[][] input = {{1,2},{2,3},{3,4},{1,3}};
		int output = eraseOverlapIntervals(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        // Sort intervals based on the end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0; // To keep track of intervals to remove
        int end = intervals[0][1]; // Initialize end to the end time of the first interval
        
        // Start from the second interval
        for (int i = 1; i < intervals.length; i++) {
            // If the start time of the current interval is less than the end time of the previous interval,
            // it means they overlap, so we need to remove an interval.
            if (intervals[i][0] < end) {
                count++;
            } else {
                // If they don't overlap, update the end to the end time of the current interval
                end = intervals[i][1];
            }
        }
        
        return count;
    }

}
