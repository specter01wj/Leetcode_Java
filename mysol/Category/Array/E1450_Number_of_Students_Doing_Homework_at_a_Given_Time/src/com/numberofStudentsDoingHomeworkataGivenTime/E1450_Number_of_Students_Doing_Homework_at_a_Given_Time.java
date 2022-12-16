package com.numberofStudentsDoingHomeworkataGivenTime;
import java.util.*;

/*
Given two integer arrays startTime and endTime and given an integer queryTime.

The ith student started doing their homework at the time startTime[i] and 
finished it at time endTime[i].

Return the number of students doing their homework at time queryTime. 
More formally, return the number of students where queryTime lays in the 
interval [startTime[i], endTime[i]] inclusive.


Example 1:

Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
Output: 1
Explanation: We have 3 students where:
The first student started doing homework at time 1 and finished at time 3 
and wasn't doing anything at time 4.
The second student started doing homework at time 2 and finished at time 2 
and also wasn't doing anything at time 4.
The third student started doing homework at time 3 and finished at time 7 
and was the only student doing homework at time 4.

Example 2:

Input: startTime = [4], endTime = [4], queryTime = 4
Output: 1
Explanation: The only student was doing their homework at the queryTime.
*/

public class E1450_Number_of_Students_Doing_Homework_at_a_Given_Time {

	public static void main(String[] args) {
		int[] startTime = {1,2,3};
		int[] endTime = {3,2,7};
		int queryTime = 4;
		int output = busyStudent(startTime, endTime, queryTime);
        System.out.println("input: " + Arrays.toString(startTime) + "\noutput: " + (output));
	}
	
	/*
    solution:
    iterate and count
    */
	
	/*
     * @param startTime: a list of integers
     * @param endTime: a list of integers
     * @param queryTime: an integer
     * @return: the number of students doing their homework at time queryTime
     */
	public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; ++i) {
            res += (startTime[i] <= queryTime) && (queryTime <= endTime[i]) ? 1 : 0;
        }
        return res; 
    }

}
