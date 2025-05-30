package com.removeElement;
import java.util.*;

/*
Given an integer array nums and an integer val, remove all occurrences 
of val in nums in-place. The order of the elements may be changed. 
Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, 
to get accepted, you need to do the following things:

	. Change the array nums such that the first k elements of nums contain 
		the elements which are not equal to val. The remaining elements of 
		nums are not important as well as the size of nums.
	. Return k.
*/

public class E27_Remove_Element {

	public static void main(String[] args) {
		E27_Remove_Element solution = new E27_Remove_Element();
		int[] input = {0,1,2,2,3,0,4,2};
		int val = 2;
		int[] inputCopy = Arrays.copyOf(input, input.length);
		int output = solution.removeElement(inputCopy, val);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Use k to track the position where the next valid (non-val) element should go.
	2. Loop through nums:
		. If nums[i] != val, copy it to nums[k] and increment k.
	3. After the loop, the first k elements of nums will not contain val.
    */
	
	/*
     * @param nums: a list of integers
     * @param val: an integer
     * @return: k
     */
	public int removeElement(int[] nums, int val) {
        int k = 0; // Points to the next position to place a non-val element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

}
