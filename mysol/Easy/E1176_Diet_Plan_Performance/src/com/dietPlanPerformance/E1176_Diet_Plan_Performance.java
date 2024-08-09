package com.dietPlanPerformance;
import java.util.*;

/*
A dieter consumes calories[i] calories on the i-th day. 

Given an integer k, for every consecutive sequence of k 
days (calories[i], calories[i+1], ..., calories[i+k-1] 
for all 0 <= i <= n-k), they look at T, the total calories 
consumed during that sequence of k days (calories[i] + 
calories[i+1] + ... + calories[i+k-1]):

 . If T < lower, they performed poorly on their diet and lose 1 point; 
 . If T > upper, they performed well on their diet and gain 1 point;
 . Otherwise, they performed normally and there is no change in points.

Initially, the dieter has zero points. Return the total number 
of points the dieter has after dieting for calories.length days.
*/

public class E1176_Diet_Plan_Performance {

	public static void main(String[] args) {
		E1176_Diet_Plan_Performance solution = new E1176_Diet_Plan_Performance();
		int[] input = {1,2,3,4,5};
		int k = 1, lower = 3, upper = 3;
		int output = solution.dietPlanPerformance(input, k, lower, upper);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Initial Sum Calculation:
	  . We start by calculating the sum of the first k days (first window) and evaluate whether 
	  	this sum is below lower, above upper, or in between. We adjust the points accordingly.
	2. Sliding Window Technique:
	  . We then slide the window across the array by one element at a time.
	  . For each new element added to the window, we subtract the element that is no longer in 
	  	the window (calories[i - k]) and add the new element (calories[i]).
	  . We evaluate the sum for each window and update the points.
	3. Edge Cases:
	  . The code handles edge cases, such as when the sum of a window is exactly on the boundary 
	  	(lower or upper), ensuring no points are added or subtracted in those cases.
    */
	
	/*
     * @param calories: a list of integers
     * @param k: an integer
     * @param lower: an integer
     * @param upper: an integer
     * @return: the total number of points the dieter has after dieting for calories.length days
     */
	public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int points = 0;
        int n = calories.length;

        // Calculate the sum for the first window of size k
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += calories[i];
        }

        // Evaluate the first window
        if (currentSum < lower) {
            points--;
        } else if (currentSum > upper) {
            points++;
        }

        // Slide the window over the array
        for (int i = k; i < n; i++) {
            currentSum += calories[i] - calories[i - k];

            if (currentSum < lower) {
                points--;
            } else if (currentSum > upper) {
                points++;
            }
        }

        return points;
    }

}
