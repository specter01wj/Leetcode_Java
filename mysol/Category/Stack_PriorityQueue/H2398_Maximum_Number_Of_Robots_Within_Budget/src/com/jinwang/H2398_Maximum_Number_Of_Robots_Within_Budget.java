package com.jinwang;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class H2398_Maximum_Number_Of_Robots_Within_Budget {

	public static void main(String[] args) {
		H2398_Maximum_Number_Of_Robots_Within_Budget solution =
                new H2398_Maximum_Number_Of_Robots_Within_Budget();

        // Example 1
        int[] chargeTimes1 = {3, 6, 1, 3, 4};
        int[] runningCosts1 = {2, 1, 3, 4, 5};
        long budget1 = 25;

        System.out.println("Input: chargeTimes = " + Arrays.toString(chargeTimes1)
                + ", runningCosts = " + Arrays.toString(runningCosts1)
                + ", budget = " + budget1);
        System.out.println("Output: "
                + solution.maximumRobots(chargeTimes1, runningCosts1, budget1));
        System.out.println();

        // Example 2
        int[] chargeTimes2 = {11, 12, 19};
        int[] runningCosts2 = {10, 8, 7};
        long budget2 = 19;

        System.out.println("Input: chargeTimes = " + Arrays.toString(chargeTimes2)
                + ", runningCosts = " + Arrays.toString(runningCosts2)
                + ", budget = " + budget2);
        System.out.println("Output: "
                + solution.maximumRobots(chargeTimes2, runningCosts2, budget2));
	}
	
	public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> deque = new ArrayDeque<>();

        long runningSum = 0;
        int left = 0;
        int answer = 0;

        for (int right = 0; right < chargeTimes.length; right++) {
            runningSum += runningCosts[right];

            while (!deque.isEmpty()
                    && chargeTimes[deque.peekLast()] <= chargeTimes[right]) {
                deque.pollLast();
            }

            deque.offerLast(right);

            while (!deque.isEmpty()
                    && chargeTimes[deque.peekFirst()]
                    + (long) (right - left + 1) * runningSum > budget) {

                if (deque.peekFirst() == left) {
                    deque.pollFirst();
                }

                runningSum -= runningCosts[left];
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }

}
