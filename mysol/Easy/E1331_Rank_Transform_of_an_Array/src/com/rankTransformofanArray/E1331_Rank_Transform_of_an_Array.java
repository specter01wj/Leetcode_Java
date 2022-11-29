package com.rankTransformofanArray;
import java.util.*;

/*
Given an array of integers arr, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

 .Rank is an integer starting from 1.
 .The larger the element, the larger the rank. If two elements are equal, 
  their rank must be the same.
 .Rank should be as small as possible.


Example 1:

Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 
20 is the second smallest. 30 is the third smallest.

Example 2:

Input: arr = [100,100,100]
Output: [1,1,1]
Explanation: Same elements share the same rank.

Example 3:

Input: arr = [37,12,28,9,100,56,80,5,12]
Output: [5,3,4,2,8,6,7,1,3]
*/

public class E1331_Rank_Transform_of_an_Array {

	public static void main(String[] args) {
//		int[] input = {40,10,20,30};
		int[] input = {100,100,100};
		int[] output = arrayRankTransform(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    Copy arr into A and sort it.
	Iterate sorted array A and record the rank for each element in hashmap rank.
	Iterate arr again, and assign rank[arr[i]] to A[i].
	return the final result A.
    */
	
	/*
     * @param arr: a list of integers
     * @return: replace each element with its rank
     */
	public static int[] arrayRankTransform(int[] arr) {
        int[] res = Arrays.copyOf(arr, arr.length);
        Arrays.sort(res);
        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int x : res) {
          rank.putIfAbsent(x, rank.size() + 1);
        }
        for (int i = 0; i < arr.length; ++i) {
          res[i] = rank.get(arr[i]);
        }
        return res;
    }

}
