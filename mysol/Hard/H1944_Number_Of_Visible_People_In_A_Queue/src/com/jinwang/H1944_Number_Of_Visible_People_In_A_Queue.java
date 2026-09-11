package com.jinwang;

import java.util.Arrays;
import java.util.Stack;

public class H1944_Number_Of_Visible_People_In_A_Queue {

	public static void main(String[] args) {
		H1944_Number_Of_Visible_People_In_A_Queue solution =
                new H1944_Number_Of_Visible_People_In_A_Queue();

        // Example 1
        int[] heights1 = {10, 6, 8, 5, 11, 9};

        System.out.println("Input: " + Arrays.toString(heights1));
        System.out.println("Output: " + Arrays.toString(solution.canSeePersonsCount(heights1)));
        System.out.println();

        // Example 2
        int[] heights2 = {5, 1, 2, 3, 10};

        System.out.println("Input: " + Arrays.toString(heights2));
        System.out.println("Output: " + Arrays.toString(solution.canSeePersonsCount(heights2)));
	}
	
	public int[] canSeePersonsCount(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                answer[i]++;
            }

            if (!stack.isEmpty()) {
                answer[i]++;
            }

            stack.push(heights[i]);
        }

        return answer;
    }

}
