package com.theTwoSneakyNumbersofDigitville;
import java.util.*;

/*
In the town of Digitville, there was a list of numbers called nums 
containing integers from 0 to n - 1. Each number was supposed to 
appear exactly once in the list, however, two mischievous numbers 
sneaked in an additional time, making the list longer than usual.

As the town detective, your task is to find these two sneaky numbers. 
Return an array of size two containing the two numbers (in any order), 
so peace can return to Digitville.
*/

public class E3289_The_Two_Sneaky_Numbers_of_Digitville {

	public static void main(String[] args) {
		E3289_The_Two_Sneaky_Numbers_of_Digitville solution = new E3289_The_Two_Sneaky_Numbers_of_Digitville();
		int[] input = {7,1,5,4,3,4,6,0,9,5,8,2};
		int[] output = solution.getSneakyNumbers(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums) {
            if (!seen.add(num)) {
                // if add returns false, it means it's already in the set
                result.add(num);
                if (result.size() == 2) break;
            }
        }
        
        return new int[]{result.get(0), result.get(1)};
    }

}
