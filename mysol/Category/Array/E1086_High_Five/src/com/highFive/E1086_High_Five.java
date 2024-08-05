package com.highFive;
import java.util.*;

/*
Given a list of the scores of different students, items, 
where items[i] = [IDi, scorei] represents one score from 
a student with IDi, calculate each student's top five average.

Return the answer as an array of pairs result, where 
result[j] = [IDj, topFiveAveragej] represents the student 
with IDj and their top five average. Sort result by IDj 
in increasing order.

A student's top five average is calculated by taking the 
sum of their top five scores and dividing it by 5 using 
integer division.
*/

public class E1086_High_Five {

	public static void main(String[] args) {
		E1086_High_Five solution = new E1086_High_Five();
		int[][] input = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
		int[][] output = solution.highFive(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + Arrays.deepToString(output));
	}
	
	/*
    solution:
    1. Use a HashMap to store the list of scores for each student.
	2. Iterate through the input list and populate the HashMap with student IDs as keys and lists of their scores as values.
	3. For each student, sort their list of scores in descending order and calculate the average of the top five scores.
	4. Store the result in a list of arrays.
	5. Sort the result list by student ID and convert it to the required array format.
    */
	
	/*
     * @param items: a list of 2D integers
     * @return: the answer as an array of pairs result
     */
	public int[][] highFive(int[][] items) {
        // Step 1: Create a HashMap to store student ID and their scores
        Map<Integer, List<Integer>> scoresMap = new HashMap<>();

        // Step 2: Populate the HashMap with student IDs and their scores
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            scoresMap.computeIfAbsent(id, k -> new ArrayList<>()).add(score);
        }

        // Step 3: Calculate the top five average for each student
        List<int[]> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : scoresMap.entrySet()) {
            int id = entry.getKey();
            List<Integer> scores = entry.getValue();
            Collections.sort(scores, Collections.reverseOrder());

            int sum = 0;
            for (int i = 0; i < 5 && i < scores.size(); i++) {
                sum += scores.get(i);
            }

            int topFiveAverage = sum / 5;
            result.add(new int[]{id, topFiveAverage});
        }

        // Step 4: Sort the result by student ID
        Collections.sort(result, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 5: Convert the result list to an array
        return result.toArray(new int[result.size()][]);
    }

}
