package com.arrayInsertions;
import java.util.*;

public class Ch2_Array_Insertions {

	public static void main(String[] args) {
		// Declare an integer array of 6 elements
		int[] intArray = new int[6];
		int length = 0;

		// Add 3 elements to the Array
		for (int i = 0; i < 3; i++) {
		    intArray[length] = i;
		    length++;
		}
		

		// Insert a new element at the end of the Array. Again,
		// it's important to ensure that there is enough space
		// in the array for inserting a new element.
		intArray[length] = 10;
		length++;
		
		for (int i = 0; i < intArray.length; i++) {
		    System.out.println("Index " + i + " contains " + intArray[i]);
		}
	}

}
