package com.theEmployeeThatWorkedontheLongestTask;
import java.util.*;

/*
There are n employees, each with a unique id from 0 to n - 1.

You are given a 2D integer array logs where logs[i] = [idi, leaveTimei] where:

	. idi is the id of the employee that worked on the ith task, and
	. leaveTimei is the time at which the employee finished the ith task. 
		All the values leaveTimei are unique.

Note that the ith task starts the moment right after the (i - 1)th task ends, 
and the 0th task starts at time 0.

Return the id of the employee that worked the task with the longest time. 
If there is a tie between two or more employees, return the smallest id among them.
*/

public class E2432_The_Employee_That_Worked_on_the_Longest_Task {

	public static void main(String[] args) {
		E2432_The_Employee_That_Worked_on_the_Longest_Task solution = new E2432_The_Employee_That_Worked_on_the_Longest_Task();
		int[][] input = {{0, 3}, {2, 5}, {0, 9}, {1, 15}};
		int n = 10;
		int output = solution.hardestWorker(n, input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public int hardestWorker(int n, int[][] logs) {
        int maxDuration = 0;
        int employeeId = Integer.MAX_VALUE;
        int previousEndTime = 0;

        for (int[] log : logs) {
            int id = log[0];
            int leaveTime = log[1];
            int duration = leaveTime - previousEndTime;

            if (duration > maxDuration) {
                maxDuration = duration;
                employeeId = id;
            } else if (duration == maxDuration && id < employeeId) {
                employeeId = id;
            }

            previousEndTime = leaveTime;
        }

        return employeeId;
    }

}
