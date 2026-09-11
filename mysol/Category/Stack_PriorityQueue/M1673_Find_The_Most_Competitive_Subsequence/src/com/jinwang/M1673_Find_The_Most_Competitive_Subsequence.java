package com.jinwang;

import java.util.Arrays;
import java.util.Stack;

public class M1673_Find_The_Most_Competitive_Subsequence {

	public static void main(String[] args) {
		M1673_Find_The_Most_Competitive_Subsequence solution =
                new M1673_Find_The_Most_Competitive_Subsequence();

        // Example 1
        int[] nums1 = {3, 5, 2, 6};
        int k1 = 2;

        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + Arrays.toString(solution.mostCompetitive(nums1, k1)));
        System.out.println();

        // Example 2
        int[] nums2 = {2, 4, 3, 3, 5, 4, 9, 6};
        int k2 = 4;

        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + Arrays.toString(solution.mostCompetitive(nums2, k2)));
	}
	
	public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty()
                    && stack.peek() > nums[i]
                    && stack.size() + nums.length - i > k) {
                stack.pop();
            }

            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }

        int[] answer = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }

}
