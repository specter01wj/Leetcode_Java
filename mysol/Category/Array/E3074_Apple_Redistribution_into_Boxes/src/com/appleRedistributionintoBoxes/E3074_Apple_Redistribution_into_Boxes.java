package com.appleRedistributionintoBoxes;
import java.util.*;

/*
You are given an array apple of size n and an array capacity of size m.

There are n packs where the ith pack contains apple[i] apples. 
There are m boxes as well, and the ith box has a capacity of capacity[i] apples.

Return the minimum number of boxes you need to select to redistribute 
these n packs of apples into boxes.

Note that, apples from the same pack can be distributed into different boxes.
*/

public class E3074_Apple_Redistribution_into_Boxes {

	public static void main(String[] args) {
		E3074_Apple_Redistribution_into_Boxes solution = new E3074_Apple_Redistribution_into_Boxes();
		int[] input = {1,3,2}, capacity = {4,3,1,5,2};
		int output = solution.minimumBoxes(input, capacity);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int minimumBoxes(int[] apple, int[] capacity) {
        // Calculate the total number of apples
        int totalApples = 0;
        for (int count : apple) {
            totalApples += count;
        }
        
        // Sort the capacity array in descending order
        Arrays.sort(capacity);
        int boxesUsed = 0;
        int currentCapacity = 0;

        // Use a reverse loop to pick the largest boxes first
        for (int i = capacity.length - 1; i >= 0; i--) {
            currentCapacity += capacity[i];
            boxesUsed++;
            if (currentCapacity >= totalApples) {
                break;
            }
        }

        return boxesUsed;
    }

}
