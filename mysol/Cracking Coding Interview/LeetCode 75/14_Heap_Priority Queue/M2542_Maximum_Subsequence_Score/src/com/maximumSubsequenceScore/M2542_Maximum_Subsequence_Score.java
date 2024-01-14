package com.maximumSubsequenceScore;
import java.util.*;

/*
You are given two 0-indexed integer arrays nums1 and nums2 of equal 
length n and a positive integer k. You must choose a subsequence of 
indices from nums1 of length k.

For chosen indices i0, i1, ..., ik - 1, your score is defined as:

 .The sum of the selected elements from nums1 multiplied with the 
  minimum of the selected elements from nums2.
 .It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) 
  * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).

Return the maximum possible score.

A subsequence of indices of an array is a set that can be derived 
from the set {0, 1, ..., n-1} by deleting some or no elements.
*/

public class M2542_Maximum_Subsequence_Score {

	public static void main(String[] args) {
		int[] input1 = {1,3,3,2}, input2 = {2,1,3,4};
		int k = 3;
		long output = maxScore(input1, input2, k);
        System.out.println("input: " + Arrays.toString(input1) + "\noutput: " + (output));
	}
	
	
	public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] ess = new int[n][2];
        for (int i = 0; i < n; ++i) {
            ess[i] = new int[] {nums2[i], nums1[i]};
        }
        Arrays.sort(ess, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = 0, sumS = 0;
        for (int[] es : ess) {
            pq.add(es[1]);
            sumS = (sumS + es[1]);
            if (pq.size() > k) {
                sumS -= pq.poll();
            }
            if (pq.size() == k) {
                res = Math.max(res, (sumS * es[0]));
            }
        }
        return res;
    }

}
