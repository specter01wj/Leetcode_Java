package com.validMountainArray;
import java.util.*;

/*Given an array of integers arr, return true if and only 
if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 

Example 1:

Input: arr = [2,1]
Output: false

Example 2:

Input: arr = [3,5,5]
Output: false

Example 3:

Input: arr = [0,3,2,1]
Output: true*/

public class E941_Valid_Mountain_Array {

	public static void main(String[] args) {
		int[] input = {0,3,2,1};
        boolean output = validMountainArray(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    根据题目要求扫描数组，若当前位置不再递增，则开始按递减的条件进行判断，
    若扫描至数组末尾，则为山形数组。
    */
	
	/**
     * @param A: the array
     * @return: true or false
     */
	public static boolean validMountainArray(int[] arr) {
		if(arr == null || arr.length < 3) return false;
		
		int i = 0;
		
		while( (i+1) <= arr.length - 1 && arr[i] < arr[i+1]) {
			i++;
		}
		
		if(i == arr.length - 1 || i == 0) return false;
		
		while( (i+1) <= arr.length - 1 && arr[i] > arr[i+1]) {
			i++;
		}
		
		if(i == arr.length - 1) return true;
		
		return false;
	}

}
