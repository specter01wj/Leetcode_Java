package com.keepMultiplyingFoundValuesbyTwo;
import java.util.*;

/*
You are given an array of integers nums. You are also given an integer 
original which is the first number that needs to be searched for in nums.

You then do the following steps:

If original is found in nums, multiply it by two (i.e., set original = 2 * original).
Otherwise, stop the process.
Repeat this process with the new number as long as you keep finding the number.
Return the final value of original.


Example 1:

Input: nums = [5,3,6,1,12], original = 3
Output: 24
Explanation: 
- 3 is found in nums. 3 is multiplied by 2 to obtain 6.
- 6 is found in nums. 6 is multiplied by 2 to obtain 12.
- 12 is found in nums. 12 is multiplied by 2 to obtain 24.
- 24 is not found in nums. Thus, 24 is returned.

Example 2:

Input: nums = [2,7,9], original = 4
Output: 4
Explanation:
- 4 is not found in nums. Thus, 4 is returned.
*/

public class E2154_Keep_Multiplying_Found_Values_by_Two {

	public static void main(String[] args) {
		int[] input = {5,3,6,1,12};
		int original = 3;
		int output = findFinalValue(input, original);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    HashSet
    */
	
	/*
     * @param nums: a list of integers
     * @param original: an integer
     * @return: the final value of original
     */
	public static int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (i >= original) {
                set.add(i);
            }
        }
        while (true) {
            if (set.contains(original)) {
                original *= 2;
            } else {
                break;
            }
        }
        return original;
    }

}
