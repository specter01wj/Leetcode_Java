package com.nextGreaterElementI;
import java.util.*;

/*The next greater element of some element x in an array is the 
first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, 
where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] 
and determine the next greater element of nums2[j] in nums2. If there is no next 
greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater 
element as described above.


Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.*/

public class E496_Next_Greater_Element_I {

	public static void main(String[] args) {
		int[] input1 = {4,1,2}, input2 = {1,3,4,2};
		System.out.println("input1: " + Arrays.toString(input1) + " input2: " + 
        		Arrays.toString(input2));
        int[] output = nextGreaterElement(input1, input2);
        System.out.println("output: " + Arrays.toString(output));
	}
	
	/*
	solution:
	用栈来存储结果。对于数字x，若栈顶元素小于x，则将栈顶元素的答案置为x，直到栈顶大于元素x，此时将x入栈，
	重复此过程从左到右遍历nums2即可得到所有数字的答案。
	*/
	
	/**
     * @param nums1: an array
     * @param nums2: an array
     * @return: find all the next greater numbers for nums1's elements in the corresponding places of nums2
     */
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }   
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

}
