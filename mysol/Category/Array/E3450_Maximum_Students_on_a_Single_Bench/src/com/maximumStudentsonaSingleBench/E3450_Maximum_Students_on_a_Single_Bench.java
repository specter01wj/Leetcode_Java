package com.maximumStudentsonaSingleBench;
import java.util.*;

/*
You are given a 2D integer array of student data students, 
where students[i] = [student_id, bench_id] represents that 
student student_id is sitting on the bench bench_id.

Return the maximum number of unique students sitting on any 
single bench. If no students are present, return 0.

Note: A student can appear multiple times on the same bench 
in the input, but they should be counted only once per bench.
*/

public class E3450_Maximum_Students_on_a_Single_Bench {

	public static void main(String[] args) {
		int[][] input = {{1,2},{2,2},{3,3},{1,3},{2,3}};
		int output = maxStudentsOnBench(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int maxStudentsOnBench(int[][] students) {
        if (students == null || students.length == 0) {
            return 0;
        }

        // Map to track which students are sitting on which bench
        Map<Integer, Set<Integer>> benchMap = new HashMap<>();

        for (int[] pair : students) {
            int studentId = pair[0];
            int benchId = pair[1];

            // For each bench, maintain a Set of unique student IDs
            benchMap.putIfAbsent(benchId, new HashSet<>());
            benchMap.get(benchId).add(studentId);
        }

        int maxStudents = 0;

        // Iterate over the map to find the maximum number of students on any bench
        for (Set<Integer> studentSet : benchMap.values()) {
            maxStudents = Math.max(maxStudents, studentSet.size());
        }

        return maxStudents;
    }

}
