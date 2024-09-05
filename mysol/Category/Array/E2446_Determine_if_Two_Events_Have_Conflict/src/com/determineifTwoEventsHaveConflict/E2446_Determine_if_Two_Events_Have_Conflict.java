package com.determineifTwoEventsHaveConflict;
import java.util.*;

/*
You are given two arrays of strings that represent two inclusive 
events that happened on the same day, event1 and event2, where:

	. event1 = [startTime1, endTime1] and
	. event2 = [startTime2, endTime2].

Event times are valid 24 hours format in the form of HH:MM.

A conflict happens when two events have some non-empty intersection 
(i.e., some moment is common to both events).

Return true if there is a conflict between two events. Otherwise, return false.
*/

public class E2446_Determine_if_Two_Events_Have_Conflict {

	public static void main(String[] args) {
		E2446_Determine_if_Two_Events_Have_Conflict solution = new E2446_Determine_if_Two_Events_Have_Conflict();
		String[] event1 = {"01:15", "02:00"};
        String[] event2 = {"02:00", "03:00"};
		boolean output = solution.haveConflict(event1, event2);
        System.out.println("input1: " + Arrays.toString(event1) + "; input2: " + Arrays.toString(event2) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Helper function timeToMinutes: This function converts the "HH:MM" 
    	format into the total number of minutes since 00:00. It splits 
    	the time string into hours and minutes, then converts each to 
    	integers and calculates the total minutes.
	2. Time comparison: After converting the event times into minutes, 
		we check for overlaps:
		. If the end time of the first event is before the start time of 
			the second event (end1 < start2) or the end time of the second 
			event is before the start time of the first event (end2 < start1), 
			there is no conflict.
		. If neither condition holds, the events overlap, and we return true.
    */
	
	/*
     * @param event1: a list of strings
     * @param event2: a list of strings
     * @return: true if there is a conflict between two events. Otherwise, return false
     */
	public boolean haveConflict(String[] event1, String[] event2) {
        // Convert event start and end times to minutes since 00:00
        int start1 = timeToMinutes(event1[0]);
        int end1 = timeToMinutes(event1[1]);
        int start2 = timeToMinutes(event2[0]);
        int end2 = timeToMinutes(event2[1]);

        // Check if there is an overlap between event1 and event2
        return !(end1 < start2 || end2 < start1);
    }

    // Helper method to convert "HH:MM" string to minutes since 00:00
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

}
