package com.findthePeaks;
import java.util.*;

/*
You are given a 0-indexed array mountain. 
Your task is to find all the peaks in the mountain array.

Return an array that consists of indices of peaks in the given array in any order.
*/

public class E2951_Find_the_Peaks {

	public static void main(String[] args) {
		E2951_Find_the_Peaks solution = new E2951_Find_the_Peaks();
		int[] input = {1,4,3,8,5};
		List<Integer> output = solution.findPeaks(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public List<Integer> findPeaks(int[] mountain) {
        List<Integer> peaks = new ArrayList<>();
        
        // Start from the second element and go up to the second last element
        for (int i = 1; i < mountain.length - 1; i++) {
            // Check if the current element is strictly greater than its neighbors
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                peaks.add(i); // Add the index to the list of peaks
            }
        }
        
        return peaks;
    }

}
