package com.lastVisitedIntegers;
import java.util.*;

/*
Given an integer array nums where nums[i] is either a positive 
integer or -1. We need to find for each -1 the respective 
positive integer, which we call the last visited integer.

To achieve this goal, let's define two empty arrays: seen and ans.

Start iterating from the beginning of the array nums.

	. If a positive integer is encountered, prepend it to the front of seen.
	. If -1 is encountered, let k be the number of consecutive -1s seen 
		so far (including the current -1),
		. If k is less than or equal to the length of seen, append the k-th 
			element of seen to ans.
		. If k is strictly greater than the length of seen, append -1 to ans.

Return the array ans.
*/

public class E2899_Last_Visited_Integers {

	public static void main(String[] args) {
		int[] input = {3,0,1,1,9,7};
		int output = lastVisitedIntegers(input, 7, 2, 3);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public List<Integer> lastVisitedIntegers(int[] nums) {
        LinkedList<Integer> seen = new LinkedList<>(); // Used for efficient prepending
        List<Integer> ans = new ArrayList<>();
        int consecutiveNegativeCount = 0;

        for (int num : nums) {
            if (num > 0) {
                // Positive integer: prepend to seen and reset consecutive negatives count
                seen.addFirst(num);
                consecutiveNegativeCount = 0;
            } else if (num == -1) {
                // Negative integer: handle consecutive negatives
                consecutiveNegativeCount++;
                if (consecutiveNegativeCount <= seen.size()) {
                    ans.add(seen.get(consecutiveNegativeCount - 1));
                } else {
                    ans.add(-1);
                }
            }
        }

        return ans;
    }

}
