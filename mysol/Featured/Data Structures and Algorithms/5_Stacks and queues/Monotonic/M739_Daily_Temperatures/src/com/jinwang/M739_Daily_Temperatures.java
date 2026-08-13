package com.jinwang;

import java.util.Arrays;
import java.util.Stack;

public class M739_Daily_Temperatures {

	public static void main(String[] args) {
		M739_Daily_Temperatures solution = new M739_Daily_Temperatures();

		int[] input1 = {73, 74, 75, 71, 69, 72, 76, 73};
		int[] output1 = solution.dailyTemperatures(input1);
		System.out.println("Input: " + Arrays.toString(input1));
		System.out.println("Output: " + Arrays.toString(output1));
		System.out.println();
		
		int[] input2 = {30, 40, 50, 60};
		int[] output2 = solution.dailyTemperatures(input2);
		System.out.println("Input: " + Arrays.toString(input2));
		System.out.println("Output: " + Arrays.toString(output2));
		System.out.println();
		
		int[] input3 = {30, 60, 90};
		int[] output3 = solution.dailyTemperatures(input3);
		System.out.println("Input: " + Arrays.toString(input3));
		System.out.println("Output: " + Arrays.toString(output3));
	}
	
	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[temperatures.length];
		
		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
				int j = stack.pop();
				answer[j] = i - j;
			}
			stack.push(i);
		}
		return answer;
	}

}
