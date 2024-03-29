package com.minimumAbsoluteDifference;
import java.util.*;

/*
Given an array of distinct integers arr, find all pairs of 
elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), 
each pair [a, b] follows

. a, b are from arr
. a < b
. b - a equals to the minimum absolute difference of any two elements in arr


Example 1:

Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. 
List all pairs with difference equal to 1 in ascending order.

Example 2:

Input: arr = [1,3,6,10,15]
Output: [[1,3]]

Example 3:

Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]
*/

public class E1200_Minimum_Absolute_Difference {

	public static void main(String[] args) {
		int[] input = {4,2,1,3};
		List<List<Integer>> output = minimumAbsDifference(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    We check for min difference as we go, adding to result list everytime 
    our difference == min difference. When we met new min difference we 
    clear the result list and start a new one.
    */
	
	/*
     * @param arr: a list of integer
     * @return: a list of pairs in ascending order
     */
	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) {
                min = diff;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (diff == min) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }

}
