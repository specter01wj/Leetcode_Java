import java.util.*;

/*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/

public class E88_Merge_Sorted_Array {

	public static void main(String[] args) {
		int[] input1 = {1,2,3,0,0,0};
		int[] input2 = {2,5,6};
        int[] output = merge(input1, 3, input2, 3);
        System.out.println("input1: " + Arrays.toString(input1) + 
        		" / input2: " + Arrays.toString(input2) + 
        		"\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    涉及两个有序数组合并,设置i和j双指针,分别从两个数组的尾部想头部移动,并判断A[i]和B[j]的大小关系,
    从而保证最终数组有序,同时每次index从尾部向头部移动。
    */
	
	/**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: merged array
     */
	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, index = m + n - 1;
        int[] result;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[index--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
        
        result = nums1;
        
        return result;
    }

}
