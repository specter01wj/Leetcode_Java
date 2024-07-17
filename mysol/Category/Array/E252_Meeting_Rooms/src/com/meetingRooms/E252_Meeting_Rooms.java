package com.meetingRooms;
import java.util.*;

/*
Given an array of meeting time intervals where 
intervals[i] = [starti, endi], determine if a person 
could attend all meetings.
*/

public class E252_Meeting_Rooms {

	public static void main(String[] args) {
		int[][] input = { {0, 30}, {5, 10}, {15, 20} };
		boolean output = canAttendMeetings(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	/*
    solution:
    count good triplets
    */
	
	/*
     * @param intervals: a list of 2D integers
     * @return: determine if a person could attend all meetings
     */
	public static boolean canAttendMeetings(int[][] intervals) {
		// Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Check for any overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false; // Found overlapping intervals
            }
        }
        
        return true; // No overlapping intervals found
    }

}
