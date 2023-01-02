package com.sortArraybyIncreasingFrequency;
import java.util.*;

/*
Given an array of integers nums, sort the array in increasing order based on the 
frequency of the values. If multiple values have the same frequency, 
sort them in decreasing order.

Return the sorted array.


Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
*/

public class E1636_Sort_Array_by_Increasing_Frequency {

	public static void main(String[] args) {
		int[] input = {1,1,2,2,2,3};
		int[] output = frequencySort(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    Sort frequency followed by value.
    */
	
	/*
     * @param nums: a list of integers
     * @return: the sorted array
     */
	public static int[] frequencySort(int[] nums) {
        var freq = new HashMap<Integer, Integer>();
        for (int n : nums) {
            freq.put(n, 1 + freq.getOrDefault(n, 0));
        }
        var pq = new PriorityQueue<Integer>(Comparator.<Integer, Integer>comparing(i -> freq.get(i)).thenComparing(i -> -i));
        for (int n : nums) {
            pq.offer(n);
        }
        int[] ans = new int[nums.length];
        for (int i = 0; !pq.isEmpty(); ++i) {
            ans[i]= pq.poll();
        }
        return ans;
    }

}
