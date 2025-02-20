package com.findMinimumOperationstoMakeAllElementsDivisiblebyThree;
import java.util.*;

/*
You are given an integer array nums. In one operation, 
you can add or subtract 1 from any element of nums.

Return the minimum number of operations to make all 
elements of nums divisible by 3.
*/

public class E3190_Find_Minimum_Operations_to_Make_All_Elements_Divisible_by_Three {

	public static void main(String[] args) {
		E3190_Find_Minimum_Operations_to_Make_All_Elements_Divisible_by_Three solution = new E3190_Find_Minimum_Operations_to_Make_All_Elements_Divisible_by_Three();
		int[] input = {1,2,3,4};
		int output = solution.minimumOperations(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int minimumOperations(int[] nums) {
        int count = 0;
        
        for (int num : nums) {
            if (num % 3 != 0) {
                count++;
            }
        }

        return count;
    }

}
