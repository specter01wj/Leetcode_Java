package com.pointsThatIntersectWithCars;
import java.util.*;

/*
You are given a 0-indexed 2D integer array nums representing the 
coordinates of the cars parking on a number line. For any index 
i, nums[i] = [starti, endi] where starti is the starting point 
of the ith car and endi is the ending point of the ith car.

Return the number of integer points on the line that are covered 
with any part of a car.
*/

public class E2848_Points_That_Intersect_With_Cars {

	public static void main(String[] args) {
		E2848_Points_That_Intersect_With_Cars solution = new E2848_Points_That_Intersect_With_Cars();
		List<List<Integer>> input = List.of(
	            List.of(3, 6),
	            List.of(1, 5),
	            List.of(4, 7)
	        );
		int output = solution.numberOfPoints(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Using a Set to Track Covered Points:
		. A HashSet is used to store unique integer points that are 
			covered by any car.
		. Sets automatically handle duplicates, so adding the same 
			point multiple times has no effect.
	2. Iterating Through Each Car:
		. For each car represented by a range [start, end], all points 
			from start to end (inclusive) are added to the HashSet.
	3. Counting the Covered Points:
		. After processing all ranges, the size of the HashSet represents 
			the number of unique points covered by the cars.
	4. Return Result:
		. Return the size of the HashSet.
    */
	
	/*
     * @param nums: a list of 2D integers
     * @return: the number of integer points on the line that are covered with any part of a car
     */
	public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> coveredPoints = new HashSet<>();

        // Iterate through each car's range
        for (List<Integer> car : nums) {
            int start = car.get(0);
            int end = car.get(1);

            // Add all points within the range [start, end] to the set
            for (int i = start; i <= end; i++) {
                coveredPoints.add(i);
            }
        }

        // Return the total number of unique points
        return coveredPoints.size();
    }

}
