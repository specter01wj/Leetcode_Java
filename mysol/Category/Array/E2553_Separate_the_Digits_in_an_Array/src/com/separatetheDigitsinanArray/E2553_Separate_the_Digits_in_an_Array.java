package com.separatetheDigitsinanArray;
import java.util.*;

/*
Given an array of positive integers nums, return an array answer 
that consists of the digits of each integer in nums after separating 
them in the same order they appear in nums.

To separate the digits of an integer is to get all the digits it has 
in the same order.

	. For example, for the integer 10921, the separation of its 
		digits is [1,0,9,2,1].
*/

public class E2553_Separate_the_Digits_in_an_Array {

	public static void main(String[] args) {
		E2553_Separate_the_Digits_in_an_Array solution = new E2553_Separate_the_Digits_in_an_Array();
		int[] input = {13,25,83,77};
		int[] output = solution.separateDigits(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    1. Input Traversal: For each integer in the input array nums, 
    	the integer is converted to a string.
	2. Digit Separation: Each character (digit) of the string is 
		then converted back to an integer and added to a List<Integer>.
	3. Final Array Construction: The list is finally converted back 
		into an array of integers and returned as the result.
    */
	
	/*
     * @param nums: a list of integers
     * @return: an array answer that consists of the digits of each integer
     */
	public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // Iterate through each number in the input array
        for (int num : nums) {
            // Convert the number to string to extract its digits
            String numStr = Integer.toString(num);
            
            // Convert each character (digit) back to an integer and add to the result list
            for (char digit : numStr.toCharArray()) {
                result.add(digit - '0');
            }
        }
        
        // Convert the list of integers to an array
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }

}
