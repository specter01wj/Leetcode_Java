package com.findAllNumbersDisappearedinanArray;
import java.util.*;

/*
Given an array nums of n integers where nums[i] is in the range [1, n], 
return an array of all the integers in the range [1, n] that do not appear in nums.
*/

public class E448_Find_All_Numbers_Disappeared_in_an_Array {

	public static void main(String[] args) {
		E448_Find_All_Numbers_Disappeared_in_an_Array solution = new E448_Find_All_Numbers_Disappeared_in_an_Array();
		int[] input = {4,3,2,7,8,2,3,1};
		List<Integer> output = solution.findDisappearedNumbers(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

}
