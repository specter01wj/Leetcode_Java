package com.arrayCapacityVSLength;
import java.util.*;

public class Ch1_Array_Capacity_VS_Length {

	public static void main(String[] args) {
		// Create a new array with a capacity of 6.
		int[] array = new int[6];

		// Current length is 0, because it has 0 elements.
		int length = 0;

		// Add 3 items into it.
		for (int i = 0; i < 3; i++) {
		    array[i] = i * i;
		    // Each time we add an element, the length goes up by one.
		    length++;
		}

		System.out.println("The Array has a capacity of " + array.length);
		System.out.println("The Array has a length of " + length);
	}
	
	public static class DVD {
	    public String name;
	    public int releaseYear;
	    public String director;

	    public DVD(String name, int releaseYear, String director) {
	        this.name = name;
	        this.releaseYear = releaseYear;
	        this.director = director;
	    }

	    public String toString() {
	        return this.name + ", directed by " + this.director + ", released in " + this.releaseYear;
	    }
	}

}
