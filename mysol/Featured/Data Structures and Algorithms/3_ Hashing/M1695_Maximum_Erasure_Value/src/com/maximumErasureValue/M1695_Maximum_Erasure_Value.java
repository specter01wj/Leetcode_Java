package com.maximumErasureValue;
import java.util.*;

/*
You are given an array of positive integers nums and want to 
erase a subarray containing unique elements. The score you get 
by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous 
subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
*/

public class M1695_Maximum_Erasure_Value {

	public static void main(String[] args) {
		M1695_Maximum_Erasure_Value solution = new M1695_Maximum_Erasure_Value();
		int[] input = {4,2,4,5,6};
		int output = solution.maximumUniqueSubarray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int left = 0, right = 0;
        int currentSum = 0, maxSum = 0;

        while (right < nums.length) {
            if (!seen.contains(nums[right])) {
                seen.add(nums[right]);
                currentSum += nums[right];
                maxSum = Math.max(maxSum, currentSum);
                right++;
            } else {
                // Remove from the left until nums[right] can be added
                seen.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }

}
