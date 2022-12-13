package com.createTargetArrayintheGivenOrder;
import java.util.*;

/*
Given two arrays of integers nums and index. Your task is to create target 
array under the following rules:

	.Initially target array is empty.
	.From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
	.Repeat the previous step until there are no elements to read in nums and index.

Return the target array.

It is guaranteed that the insertion operations will be valid.


Example 1:

Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]

Example 2:

Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
Output: [0,1,2,3,4]
Explanation:
nums       index     target
1            0        [1]
2            1        [1,2]
3            2        [1,2,3]
4            3        [1,2,3,4]
0            0        [0,1,2,3,4]

Example 3:

Input: nums = [1], index = [0]
Output: [1]
*/

public class E1389_Create_Target_Array_in_the_Given_Order {

	public static void main(String[] args) {
		int[] input = {0,1,2,3,4};
		int[] index = {0,1,2,2,1};
		int[] output = createTargetArray(input, index);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public static int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0;i < nums.length;i++) {
            arr.add(index[i],nums[i]);
        }
        int target[] = new int[nums.length];
        for(int i = 0;i < nums.length;i++) {
            target[i] = arr.get(i);
        }
        return target;
    }

}
