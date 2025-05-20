package com.numberofStepstoReduceaNumbertoZero;
import java.util.*;

/*
Given an integer num, return the number of steps to reduce it to zero.

In one step, if the current number is even, you have to divide it by 2, 
otherwise, you have to subtract 1 from it.
*/

public class E1342_Number_of_Steps_to_Reduce_a_Number_to_Zero {

	public static void main(String[] args) {
		int input = 14;
		int output = numberOfSteps(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public int numberOfSteps(int num) {
        int steps = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }

            steps++;
        }

        return steps;
    }

}
