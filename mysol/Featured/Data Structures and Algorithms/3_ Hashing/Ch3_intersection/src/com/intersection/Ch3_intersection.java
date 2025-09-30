package com.intersection;
import java.util.*;

/*
Given a 2D integer array nums where nums[i] is a non-empty array of 
distinct positive integers, return the list of integers that are 
present in each array of nums sorted in ascending order.
*/

public class Ch3_intersection {

	public static void main(String[] args) {
		Ch3_intersection solution = new Ch3_intersection();
		int[][] input = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
		List<Integer> output = solution.intersection(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int numArrays = nums.length;

        for (int[] arr : nums) {
            Set<Integer> uniqueInThisRow = new HashSet<>();
            for (int num : arr) {
                uniqueInThisRow.add(num); // avoid double-counting within the same row
            }
            for (int num : uniqueInThisRow) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == numArrays) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result); // required: ascending order
        return result;
    }

}
