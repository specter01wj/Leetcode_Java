package com.jinwang;

import java.util.Arrays;
import java.util.Stack;

public class M907_Sum_Of_Subarray_Minimums {

	public static void main(String[] args) {
		M907_Sum_Of_Subarray_Minimums solution =
                new M907_Sum_Of_Subarray_Minimums();

        // Example 1
        int[] arr1 = {3, 1, 2, 4};

        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + solution.sumSubarrayMins(arr1));
        System.out.println();

        // Example 2
        int[] arr2 = {11, 81, 94, 43, 3};

        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + solution.sumSubarrayMins(arr2));
	}
	
	public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Distance to previous smaller element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Distance to next smaller or equal element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        long answer = 0;

        for (int i = 0; i < n; i++) {
            answer = (answer + (long) arr[i] * left[i] * right[i]) % mod;
        }

        return (int) answer;
    }

}
