package com.maximumSubarrayWithEqualProducts;
import java.util.*;

/*
You are given an array of positive integers nums.

An array arr is called product equivalent if prod(arr) == lcm(arr) * gcd(arr), 
where:

	. prod(arr) is the product of all elements of arr.
	. gcd(arr) is the GCD of all elements of arr.
	. lcm(arr) is the LCM of all elements of arr.

Return the length of the longest product equivalent subarray of nums.
*/

public class E3411_Maximum_Subarray_With_Equal_Products {

	public static void main(String[] args) {
		int[] input = {1,2,1,2,1,1,1};
		int output = maxLength(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            long product = 1;
            int gcd = 0;
            long lcm = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                gcd = gcd == 0 ? nums[j] : gcd(gcd, nums[j]);
                lcm = lcm(nums[j], lcm);

                // Avoid overflow
                if (product > 1e18 || lcm > 1e18) break;

                if (product == gcd * lcm) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private long lcm(int a, long b) {
        return (a * (b / gcd(a, (int)b)));
    }

}
