package com.singleNumber;
import java.util.*;

/*
Given a non-empty array of integers nums, every element appears 
twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity 
and use only constant extra space.
*/

public class E136_Single_Number {

	public static void main(String[] args) {
		int[] input = {4,1,2,1,2};
		int output = singleNumber(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public static int singleNumber(int[] nums) {
        int single = 0;

        for (int num : nums) {
            single ^= num;
        }

        return single;
    }

}
