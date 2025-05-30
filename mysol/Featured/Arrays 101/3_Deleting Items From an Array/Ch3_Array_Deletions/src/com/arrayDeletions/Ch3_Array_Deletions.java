package com.arrayDeletions;
import java.util.*;

public class Ch3_Array_Deletions {

	public static void main(String[] args) {
		
		// Declare an integer array of 10 elements.
		int[] intArray = new int[10];
		
		// The array currently contains 0 elements
		int length = 0;
		
		// Add elements at the first 6 indexes of the Array.
		for(int i = 0; i < 6; i++) {
			intArray[length] = i;
			length++;
		}
		
		
		// Deletion from the end is as simple as reducing the length
		// of the array by 1.
		length--;
		
		for (int i = 0; i < intArray.length; i++) {
		    System.out.println("Index " + i + " contains " + intArray[i]);
		}
		
		
		for (int i = 0; i < length; i++) {
		    System.out.println("Index " + i + " contains " + intArray[i]);
		}

	}

}
