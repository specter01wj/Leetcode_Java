package com.findAllNumDisapper;
import java.util.*;

/*Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
  some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume 
the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]*/

public class E448_Find_All_Numbers_Disappeared_in_an_Array {

	public static void main(String[] args) {
		int[] input = {4,3,2,7,8,2,3,1};
        List<Integer> output = findDisappearedNumbers(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
	 * solution:
	用一个vis数组来保存数字是否出现过即可。
	*/
	
	/**
     * @param nums: a list of integers
     * @return: return a list of integers
     */
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int[] vis = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			vis[nums[i] - 1]++;
		}
		
		for(int i = 0; i < vis.length; i++) {
			if(vis[i] == 0) {
				res.add(i + 1);
			}
		}
		
		return res;
	}

}
