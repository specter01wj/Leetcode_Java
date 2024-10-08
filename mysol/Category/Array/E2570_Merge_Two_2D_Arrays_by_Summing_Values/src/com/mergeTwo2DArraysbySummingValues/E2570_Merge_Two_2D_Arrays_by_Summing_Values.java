package com.mergeTwo2DArraysbySummingValues;
import java.util.*;

/*
You are given two 2D integer arrays nums1 and nums2.

	. nums1[i] = [idi, vali] indicate that the number with 
		the id idi has a value equal to vali.
	. nums2[i] = [idi, vali] indicate that the number with 
		the id idi has a value equal to vali.

Each array contains unique ids and is sorted in ascending order by id.

Merge the two arrays into one array that is sorted in ascending order by id, 
respecting the following conditions:

	. Only ids that appear in at least one of the two arrays should be 
		included in the resulting array.
	. Each id should be included only once and its value should be the 
		sum of the values of this id in the two arrays. If the id does 
		not exist in one of the two arrays then its value in that array 
		is considered to be 0.

Return the resulting array. The returned array must be sorted in ascending 
order by id.
*/

public class E2570_Merge_Two_2D_Arrays_by_Summing_Values {

	public static void main(String[] args) {
		E2570_Merge_Two_2D_Arrays_by_Summing_Values solution = new E2570_Merge_Two_2D_Arrays_by_Summing_Values();
		int[][] nums1 = {{1,2},{2,3},{4,5}};
		int[][] nums2 = {{1,4},{3,2},{4,1}};
		int[][] output = solution.mergeArrays(nums1, nums2);
        System.out.println("input: " + Arrays.deepToString(nums1) + "\noutput: " + Arrays.deepToString(output));
	}
	
	/*
    solution:
    1. Two Pointer Approach: We use two pointers i and j to traverse both arrays nums1 and nums2. 
    	Since both arrays are sorted by id, we can compare the current elements in both arrays.
		. If id values are equal, we sum the values and move both pointers.
		. If nums1[i][0] < nums2[j][0], we add the entry from nums1 and increment i.
		. If nums1[i][0] > nums2[j][0], we add the entry from nums2 and increment j.
	2. Remaining Elements: After processing the common elements, any remaining elements in either 
		nums1 or nums2 are added to the result.
	3. Result List: The result is collected in a list and finally converted back to a 2D array.
    */
	
	/*
     * @param nums1: a list of 2D integers
     * @param nums2: a list of 2D integers
     * @return: the resulting array
     */
	public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                // If both ids are the same, sum the values and add the merged result
                result.add(new int[] { nums1[i][0], nums1[i][1] + nums2[j][1] });
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                // If nums1 id is smaller, add nums1 entry
                result.add(new int[] { nums1[i][0], nums1[i][1] });
                i++;
            } else {
                // If nums2 id is smaller, add nums2 entry
                result.add(new int[] { nums2[j][0], nums2[j][1] });
                j++;
            }
        }

        // Add any remaining elements from nums1
        while (i < nums1.length) {
            result.add(new int[] { nums1[i][0], nums1[i][1] });
            i++;
        }

        // Add any remaining elements from nums2
        while (j < nums2.length) {
            result.add(new int[] { nums2[j][0], nums2[j][1] });
            j++;
        }

        // Convert result list to a 2D array
        return result.toArray(new int[result.size()][]);
    }

}
