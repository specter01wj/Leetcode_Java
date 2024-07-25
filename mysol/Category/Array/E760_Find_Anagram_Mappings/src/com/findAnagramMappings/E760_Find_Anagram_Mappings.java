package com.findAnagramMappings;
import java.util.*;

/*
You are given two integer arrays nums1 and nums2 where nums2 
is an anagram of nums1. Both arrays may contain duplicates.

Return an index mapping array mapping from nums1 to nums2 
where mapping[i] = j means the ith element in nums1 appears 
in nums2 at index j. If there are multiple answers, 
return any of them.

An array a is an anagram of an array b means b is made by 
randomizing the order of the elements in a.
*/

public class E760_Find_Anagram_Mappings {

	public static void main(String[] args) {
		E760_Find_Anagram_Mappings solution = new E760_Find_Anagram_Mappings();
		int[] nums1 = {12, 28, 46, 32, 50};
        int[] nums2 = {50, 12, 32, 46, 28};
		int[] output = solution.anagramMappings(nums1, nums2);
        System.out.println("input1: " + Arrays.toString(nums1) + 
        		"; input2: " + Arrays.toString(nums2) + 
        		"\noutput: " + Arrays.toString(output));
	}
	
	
	public int[] anagramMappings(int[] nums1, int[] nums2) {
        // Create a map to store the value-to-index mappings for nums2
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            indexMap.put(nums2[i], i);
        }

        // Create the result array to store the mappings
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = indexMap.get(nums1[i]);
        }

        return result;
    }

}
