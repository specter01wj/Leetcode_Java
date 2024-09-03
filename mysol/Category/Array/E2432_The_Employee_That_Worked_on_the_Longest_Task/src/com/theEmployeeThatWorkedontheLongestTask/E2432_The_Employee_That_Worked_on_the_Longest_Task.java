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
	
	/*
    solution:
    1. Initialize Variables:
		. maxDuration to store the maximum task duration encountered.
		. employeeId to store the ID of the employee who worked the longest task, initialized to Integer.MAX_VALUE to handle ties.
		. previousEndTime to track the end time of the previous task.
	2. Iterate Over Logs:
		. For each log, calculate the duration of the task by subtracting previousEndTime from the current leaveTime.
		. If the current duration is greater than maxDuration, update maxDuration and set employeeId to the current employee's ID.
		. If the duration is equal to maxDuration but the current employee's ID is smaller, update employeeId to the current ID.
	3. Update Previous End Time:
		. Update previousEndTime to the current task's leaveTime for the next iteration.
	4. Return:
		. Finally, return the employeeId that corresponds to the longest task duration.
    */
	
	/*
     * @param n: an integer
     * @param logs: a list of 2D integers
     * @return: the number of good triplets
     */
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
