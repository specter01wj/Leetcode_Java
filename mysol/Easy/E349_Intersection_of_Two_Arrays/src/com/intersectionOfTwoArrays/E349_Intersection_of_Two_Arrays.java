package com.intersectionOfTwoArrays;
import java.util.*;

/*Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.*/

public class E349_Intersection_of_Two_Arrays {

	public static void main(String[] args) {
		int[] input1 = {4,9,4,5}, input2 = {9,4,9,4,8,4};
        int[] output = intersection(input1, input2);
        System.out.println("input1: " + Arrays.toString(input1) + 
        		" input2: " + Arrays.toString(input2) + 
        		"\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    hashset
	解题思路
		使用两个集合解决这个问题。
		
		首先，将nums1中的元素加入到集合set1中。
		
		依次检查nums2中的元素是否在set1中，如果在，说明属于交集元素，加入到交集集合set2中。
		
		遍历set2，把所有元素加入到数组res中，返回res。
	
	复杂度分析
		时间复杂度：
		O(m+n)，m和n分别表示nums1和nums2的长度。算法中对nums1和nums2分别进行遍历。
		
		空间复杂度: 
		O(max(n,m)，m表示nums1的长度。集合set1的长度最长为m，set2和res的长度不会超过set1。
    */
	
	/**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
	public static int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null) {
			return null;
		}
		
		HashSet<Integer> hash = new HashSet<>();
		for(int i = 0; i < nums1.length; i++) {
			hash.add(nums1[i]);
		}
		
		HashSet<Integer> resultHash = new HashSet<>();
		for(int i = 0; i < nums2.length; i++) {
			if(hash.contains(nums2[i]) && !resultHash.contains(nums2[i])) {
				resultHash.add(nums2[i]);
			}
		}
		
		int[] result = new int[resultHash.size()];
		int index = 0;
		for(Integer num : resultHash) {
			result[index++] = num;
		}
		
		return result;
	}

}
