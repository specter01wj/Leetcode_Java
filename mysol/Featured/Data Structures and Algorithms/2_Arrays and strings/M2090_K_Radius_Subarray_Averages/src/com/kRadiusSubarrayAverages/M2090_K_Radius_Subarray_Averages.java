package com.kRadiusSubarrayAverages;
import java.util.*;

/*
You are given a 0-indexed array nums of n integers, and an integer k.

The k-radius average for a subarray of nums centered at some index i 
with the radius k is the average of all elements in nums between the 
indices i - k and i + k (inclusive). If there are less than k elements 
before or after the index i, then the k-radius average is -1.

Build and return an array avgs of length n where avgs[i] is the k-radius 
average for the subarray centered at index i.

The average of x elements is the sum of the x elements divided by x, 
using integer division. The integer division truncates toward zero, 
which means losing its fractional part.

	. For example, the average of four elements 2, 3, 1, 
	and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.
*/

public class M2090_K_Radius_Subarray_Averages {

	public static void main(String[] args) {
		M2090_K_Radius_Subarray_Averages solution = new M2090_K_Radius_Subarray_Averages();
		int[] input = {7,4,3,9,1,8,5,2,6};
		int k = 3;
		int[] output = solution.getAverages(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        if (k == 0) return nums;
        if (2 * k + 1 > n) return ans;

        long windowSum = 0;
        int windowSize = 2 * k + 1;

        for (int i = 0; i < n; i++) {
            windowSum += nums[i];

            if (i >= windowSize - 1) {
                int center = i - k;
                ans[center] = (int)(windowSum / windowSize);
                windowSum -= nums[i - windowSize + 1];
            }
        }

        return ans;
    }

}
