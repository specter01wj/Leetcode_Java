package com.intersectionOfTwoArrays2;
import java.util.*;

/*Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that 
you cannot load all elements into the memory at once?*/

public class E350_Intersection_of_Two_Arrays_II {

	public static void main(String[] args) {
		int[] input1 = {4,9,4,5}, input2 = {9,4,9,4,8,4};
        int[] output = intersect(input1, input2);
        System.out.println("input1: " + Arrays.toString(input1) + 
        		" input2: " + Arrays.toString(input2) + 
        		"\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    用map维护前一个数组中每个值出现的次数 然后遍历第二个数组，对于每个遍历到的数，在map中将这个数出现的次数-1
    解题思路
		使用排序+双指针的方法。我们对两个数组进行排序，并且使用两个指针在一次扫描中找出公共的数字。
	算法流程
		对数组nums1和nums2排序。
		
		初始化指针i和j为 0。指针i 指向nums1，指针j指向nums2
		
		如果nums1[i] < nums2[j]，则i++。
		
		如果nums1[i] > nums2[j]，则j++。
		
		如果nums1[i] == nums2[j]，将元素添加到res，且i++，j++。
		
	复杂度分析
		时间复杂度：
		O(mlog(m)+nlog(n))，其中m和n分别是nums1和nums2长度。排序算法的时间复杂度是
		O(mlog(m)+nlog(n))，双指针扫描的复杂度是O(m+n)。
		
		空间复杂度：
		O(1)，常量空间。
    */
	
	/**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums1.length; ++i) {
			if(map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			} else {
				map.put(nums1[i], 1);
			}
		}
		
		List<Integer> results = new ArrayList<Integer>();
		for(int i = 0; i < nums2.length; ++i) {
			if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				results.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}
		
		int result[] = new int[results.size()];
		for(int i = 0; i < results.size(); ++i) {
			result[i] = results.get(i);
		}
		
		return result;
	}

}
