package com.thirdMaximumNumber;
import java.util.*;

/*
Given an integer array nums, return the third distinct maximum number in this array. 
If the third maximum does not exist, return the maximum number.
*/

public class E414_Third_Maximum_Number {

	public static void main(String[] args) {
		E414_Third_Maximum_Number solution = new E414_Third_Maximum_Number();
		int[] input = {2,2,3,1};
		int output = solution.thirdMax(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int thirdMax(int[] nums) {
        Long first = null, second = null, third = null;

        for (int num : nums) {
            Long n = (long) num;

            if (n.equals(first) || n.equals(second) || n.equals(third)) continue;

            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n > second) {
                third = second;
                second = n;
            } else if (third == null || n > third) {
                third = n;
            }
        }

        return third != null ? third.intValue() : first.intValue();
    }

}
