package com.kthLargestElementinanArray;
import java.util.*;

/*
Given an integer array nums and an integer k, return the kth 
largest element in the array.

Note that it is the kth largest element in the sorted order, 
not the kth distinct element.

Can you solve it without sorting?
*/

public class M215_Kth_Largest_Element_in_an_Array {

	public static void main(String[] args) {
		int[] input = {3,2,1,5,6,4};
		int k = 2;
		int output = findKthLargest(input, k);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Heap
    */
	
	/*
     * @param nums: a list of integers
     * @param k: an integer
     * @return: the kth largest element in the array
     */
	public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }
    
    private static int quickSort(int[] nums, int left, int right, int k) {
        if (left <= right) {
            int p = partion(nums, left, right);
            if (p == nums.length - k) {
                return nums[p];
            } else if (p > nums.length - k) {
                return quickSort(nums, left, p - 1, k);
            } else {
                return quickSort(nums, p + 1, right, k);
            }
        }
        return -1;
    }

    private static int partion(int[] nums, int left, int right) {
        int i = left + 1, j = right;
        while (true) {
            while (i <= right && nums[i] < nums[left]) {
                i++;
            }
            while (j >= left + 1 && nums[j] > nums[left]) {
                j--;
            }
            if (i > j) {
                break;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        int temp = nums[left];
        nums[left] = nums[j];
        nums[j] = temp;
        return j;
    }

}
