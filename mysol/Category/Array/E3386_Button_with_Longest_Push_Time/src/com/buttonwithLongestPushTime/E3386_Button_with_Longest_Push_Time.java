package com.buttonwithLongestPushTime;
import java.util.*;

/*
You are given a 2D array events which represents a sequence of events 
where a child pushes a series of buttons on a keyboard.

Each events[i] = [indexi, timei] indicates that the button at index 
indexi was pressed at time timei.

	. The array is sorted in increasing order of time.
	. The time taken to press a button is the difference in time between 
		consecutive button presses. The time for the first button is simply 
		the time at which it was pressed.

Return the index of the button that took the longest time to push. 
If multiple buttons have the same longest time, return the button with 
the smallest index.
*/

public class E3386_Button_with_Longest_Push_Time {

	public static void main(String[] args) {
		E3386_Button_with_Longest_Push_Time solution = new E3386_Button_with_Longest_Push_Time();
		int[][] input = {{1,2},{2,5},{3,9},{1,15}};
		int output = solution.buttonWithLongestTime(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public int buttonWithLongestTime(int[][] events) {
        // Initialize with the first event
        int longestDuration = events[0][1]; // First press time
        int buttonIndex = events[0][0];     // First button index

        for (int i = 1; i < events.length; i++) {
            int duration = events[i][1] - events[i - 1][1];
            int currentButton = events[i][0];

            if (duration > longestDuration) {
                longestDuration = duration;
                buttonIndex = currentButton;
            } else if (duration == longestDuration && currentButton < buttonIndex) {
                buttonIndex = currentButton;
            }
        }

        return buttonIndex;
    }

}
