package com.inPlaceArrayOperationsIntroduction;
import java.util.*;

public class Ch5_InPlace_Array_Operations_Introduction {

	public static void main(String[] args) {
		int[] array = {9, -2, -9, 11, 56, -12, -3};
	    int length = array.length;

	    int[] result = Ch5_InPlace_Array_Operations_Introduction.squareEven1(array, length);

	    System.out.println("Output: " + Arrays.toString(result));
	}
	
	
	public static int[] squareEven1(int[] array, int length) {
	    // Check for edge cases.
		if (array == null) {
		    return null;
		}

		// Create a resultant Array which would hold the result.
		int result[] = new int[length];

		// Iterate through the original Array.
		for (int i = 0; i < length; i++) {

			// Get the element from slot i of the input Array.
			int element = array[i];

		    // If the index is an even number, then we need to square element.
		    if (i % 2 == 0) {
		    	element *= element;
		    }

		    // Write element into the result Array.
		    result[i] = element;
		}

		// Return the result Array.
		return result;
	}

}
