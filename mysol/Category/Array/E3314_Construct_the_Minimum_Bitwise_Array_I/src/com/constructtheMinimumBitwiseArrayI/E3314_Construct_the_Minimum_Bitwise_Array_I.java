package com.constructtheMinimumBitwiseArrayI;
import java.util.*;

/*
You are given an array nums consisting of n prime integers.

You need to construct an array ans of length n, such that, for each index i, 
the bitwise OR of ans[i] and ans[i] + 1 is equal to nums[i], i.e. ans[i] OR 
(ans[i] + 1) == nums[i].

Additionally, you must minimize each value of ans[i] in the resulting array.

If it is not possible to find such a value for ans[i] that satisfies the condition, 
then set ans[i] = -1.
*/

public class E3314_Construct_the_Minimum_Bitwise_Array_I {

	public static void main(String[] args) {
		E3314_Construct_the_Minimum_Bitwise_Array_I solution = new E3314_Construct_the_Minimum_Bitwise_Array_I();
		List<Integer> input = Arrays.asList(2, 3, 5, 7);
		int[] output = solution.minBitwiseArray(input);
        System.out.println("input: " + (input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    For each num in the list:
	1. Try all possible x from 0 up to num.
	2. For each x, check: if (x | (x + 1)) == num
	3. If such an x is found, take the smallest one and break the loop.
	4. If no such x exists, set the answer to -1.
    */
	
	/*
     * @param nums: a list of integers
     * @return: an array ans of length n
     */
	public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            boolean found = false;
            for (int x = 0; x <= num; x++) {
                if ((x | (x + 1)) == num) {
                    ans[i] = x;
                    found = true;
                    break;
                }
            }
            if (!found) {
                ans[i] = -1;
            }
        }
        
        return ans;
    }

}
