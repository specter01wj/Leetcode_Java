package com.minimumNumberofOperationstoMakeElementsinArrayDistinct;
import java.util.*;

/*
You are given an integer array nums. You need to ensure that the 
elements in the array are distinct. To achieve this, you can perform 
the following operation any number of times:

	. Remove 3 elements from the beginning of the array. If the array has 
		fewer than 3 elements, remove all remaining elements.

Note that an empty array is considered to have distinct elements. 
Return the minimum number of operations needed to make the elements 
in the array distinct.
*/

public class E3396_Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct {

	public static void main(String[] args) {
		E3396_Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct solution = new E3396_Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct();
		int[] input = {1,2,3,4,2,3,3,5,7};
		int output = solution.minimumOperations(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Initialization:
		. n is the length of the input array nums.
		. ops counts the number of operations performed.
		. i is the current starting index of the array after successive removals.
	2. Main Loop:
		. While i < n, do the following:
			. Initialize a HashSet<Integer> to track seen elements.
			. Scan from index i to end of array:
				. If a duplicate is found (!seen.add(nums[j])), mark hasDuplicate = true and break.
			. If no duplicate is found, return the number of operations ops.
	3. Simulate Removal:
		. If duplicates are found, increment i by 3 (remove first 3 elements).
		. Increase operation count ops.
	4. Termination:
		. Once all elements are removed or no duplicates remain, return ops.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the minimum number of operations
     */
	public int minimumOperations(int[] nums) {
        int n = nums.length;
        int ops = 0;

        // simulate removing first 3 elements repeatedly
        int i = 0;
        while (i < n) {
            // create a new array from i to end
            Set<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = i; j < n; j++) {
                if (!seen.add(nums[j])) {
                    hasDuplicate = true;
                    break;
                }
            }

            if (!hasDuplicate) {
                return ops;
            }

            // remove 3 elements from front (increment i by 3)
            i += 3;
            ops++;
        }

        return ops;
    }

}
