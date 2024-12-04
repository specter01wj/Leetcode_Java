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
		E2899_Last_Visited_Integers solution = new E2899_Last_Visited_Integers();
		int[] input = {1,2,-1,-1,-1};
		List<Integer> output = solution.lastVisitedIntegers(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Using LinkedList for seen:
		. A LinkedList is used to allow efficient prepending of elements 
			to the front using addFirst.
	2. Tracking Consecutive -1 Count:
		. Use consecutiveNegativeCount to count how many consecutive -1s 
			have been encountered.
	3. Processing Each Element:
		. For positive integers, prepend the number to the seen list and 
			reset consecutiveNegativeCount.
		. For -1, check if consecutiveNegativeCount is less than or equal 
			to the size of seen:
			. If true, retrieve the corresponding element from seen.
			. If false, append -1 to ans.
	4. Return Result:
		. At the end of the iteration, return the ans list.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the array ans
     */
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
