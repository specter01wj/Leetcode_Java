package com.intersectionofThreeSortedArrays;
import java.util.*;

/*
Given three integer arrays arr1, arr2 and arr3 sorted in strictly 
increasing order, return a sorted array of only the integers that 
appeared in all three arrays.
*/

public class E1213_Intersection_of_Three_Sorted_Arrays {

	public static void main(String[] args) {
		E1213_Intersection_of_Three_Sorted_Arrays solution = new E1213_Intersection_of_Three_Sorted_Arrays();
		int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 5, 7, 9};
        int[] arr3 = {1, 3, 4, 5, 8};
        List<Integer> output = solution.arraysIntersection(arr1, arr2, arr3);
        System.out.println("input1: " + Arrays.toString(arr1) +
        		"; input2: " + Arrays.toString(arr2) + 
        		"; input3: " + Arrays.toString(arr3) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Three Pointers: The algorithm uses three pointers i, j, and k to 
       traverse the three arrays arr1, arr2, and arr3 respectively.
	2. Comparison:
		. If arr1[i], arr2[j], and arr3[k] are all equal, the element is present in 
		  all three arrays, and it's added to the result list.
		. If arr1[i] is the smallest, increment i to check the next element in arr1.
		. If arr2[j] is smaller than arr3[k], increment j to check the next element in arr2.
		. Otherwise, increment k to check the next element in arr3.
	3. Termination: The loop continues until one of the arrays is fully traversed.
    */
	
	/*
     * @param arr1: a list of integers
     * @param arr2: a list of integers
     * @param arr3: a list of integers
     * @return: a sorted array of only the integers that appeared in all three arrays
     */
	public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0, k = 0;
        
        // Use three pointers to traverse the arrays
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
                // If all three elements are equal, add to result
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        
        return result;
    }

}
