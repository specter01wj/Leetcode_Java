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
		E3450_Maximum_Students_on_a_Single_Bench solution = new E3450_Maximum_Students_on_a_Single_Bench();
		int[][] input = {{1,2},{2,2},{3,3},{1,3},{2,3}};
		int output = solution.maxStudentsOnBench(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Check for Edge Case:
		. If the students array is null or empty (length == 0), immediately return 0.
	2. Use a Map<Integer, Set<Integer>>:
		. Key: benchId
		. Value: Set of studentIds (to ensure uniqueness).
	3. Traverse the students array:
		. For each [studentId, benchId] pair:
			. If the benchId is not already in the map, create a new empty HashSet.
			. Add studentId to the set corresponding to benchId.
			. Because it's a Set, duplicates are automatically ignored.
	4. Find the Maximum:
		. Iterate through each entry in the map.
		. For each Set of students, update the maxStudents with the maximum size found.
	5. Return the result:
		. After processing all benches, return the maximum number of unique students found.
    */
	
	/*
     * @param students: a list of 2D integers
     * @return: the maximum number of unique students sitting on any single bench
     */
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
