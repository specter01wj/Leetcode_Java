package com.countingBits;
import java.util.*;

/*
Given an integer n, return an array ans of length n + 1 such that 
for each i (0 <= i <= n), ans[i] is the number of 1's in the binary 
representation of i.
*/

public class E338_Counting_Bits {

	public static void main(String[] args) {
		int input = 5;
		int[] output = countBits(input);
        System.out.println("input: " + (input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    Bit Manipulation
    */
	
	/*
     * @param n: an integer
     * @return: an array ans of length n + 1
     */
	public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }

        return ans;
    }

}
