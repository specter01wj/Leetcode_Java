package com.twoOutofThree;
import java.util.*;

/*
Given three integer arrays nums1, nums2, and nums3, return a distinct 
array containing all the values that are present in at least two out 
of the three arrays. You may return the values in any order.


Example 1:

Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
Output: [3,2]
Explanation: The values that are present in at least two arrays are:
- 3, in all three arrays.
- 2, in nums1 and nums2.

Example 2:

Input: nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
Output: [2,3,1]
Explanation: The values that are present in at least two arrays are:
- 2, in nums2 and nums3.
- 3, in nums1 and nums2.
- 1, in nums1 and nums3.

Example 3:

Input: nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
Output: []
Explanation: No value is present in at least two arrays.
*/

public class E2032_Two_Out_of_Three {

	public static void main(String[] args) {
		int[] input = {1,1,3,2}, nums2 = {2,3}, nums3 = {3};
		List<Integer> output = twoOutOfThree(input, nums2, nums3);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    . We keep an array count of 1-100.
	. When we find number num in the first array, we set the bit 0 of count[num] using count[num]|=1
	. Similarly we set the second bit for the second array and the third bit for the third.
    */
	
	/*
     * @param nums1: a list of integers
     * @param nums2: a list of integers
     * @param nums3: a list of integers
     * @return: a distinct array containing all the values that are present in at least 
     * two out of the three arrays
     */
	public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] count = new int[101];
        List<Integer> result = new ArrayList<>();
        for (int num : nums1) {
            count[num] |= 1;
        }
        for (int num : nums2) {
            count[num] |= 1 << 1;
        }
        for (int num : nums3) {
            count[num] |= 1 << 2;
        }
        for (int i = 1;i <= 100;i++){
            if (count[i] == 3 || count[i] == 5 || count[i] == 6 || count[i] == 7) {
                result.add(i);
            }
        }
        return result;
    }

}
