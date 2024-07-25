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
	
	/*
    solution:
    1. Map Creation: We first create a HashMap to store the mapping of values in nums2 to their indices.
	2. Mapping Indices: We iterate over nums2 and populate the map with the value as the key and its index as the value.
	3. Result Array: We create a result array of the same length as nums1.
	4. Fill Result Array: We iterate over nums1 and use the map to find the corresponding index of each element in nums2.
	5. Return Result: Finally, we return the result array.
    */
	
	/*
     * @param nums1: a list of integers
     * @param nums2: a list of integers
     * @return: an index mapping array mapping from nums1 to nums2
     */
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
