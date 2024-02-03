package com.dailyTemperatures;
import java.util.*;

/*
Given an array of integers temperatures represents the daily temperatures, 
return an array answer such that answer[i] is the number of days you have 
to wait after the ith day to get a warmer temperature. If there is no future 
day for which this is possible, keep answer[i] == 0 instead.
*/

public class M739_Daily_Temperatures {

	public static void main(String[] args) {
		int[] input = {73,74,75,71,69,72,76,73};
		int[] output = dailyTemperatures(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        return answer;
    }

}
