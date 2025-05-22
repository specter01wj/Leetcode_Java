package com.accessingElementsinArrays;
import java.util.*;

public class Ch1_Accessing_Elements_in_Arrays {

	public static void main(String[] args) {
		DVD[] dvdCollection = new DVD[15];
		DVD avengersDVD = new DVD("The Avengers", 2012, "Joss Whedon");
		dvdCollection[7] = avengersDVD;
		
		DVD incrediblesDVD = new DVD("The Incredibles", 2004, "Brad Bird");
		DVD findingDoryDVD = new DVD("Finding Dory", 2016, "Andrew Stanton");
		DVD lionKingDVD = new DVD("The Lion King", 2019, "Jon Favreau");

		// Put "The Incredibles" into the 4th place: index 3.
		dvdCollection[3] = incrediblesDVD;

		// Put "Finding Dory" into the 10th place: index 9.
		dvdCollection[9] = findingDoryDVD;

		// Put "The Lion King" into the 3rd place: index 2.
		dvdCollection[2] = lionKingDVD;
		
		DVD starWarsDVD = new DVD("Star Wars", 1977, "George Lucas");
		dvdCollection[3] = starWarsDVD;
		
		System.out.println(dvdCollection[7]);
		System.out.println(dvdCollection[10]);
		System.out.println(dvdCollection[3]);
		
		
		int[] squareNumbers = new int[10];

		// Go through each of the Array indexes, from 0 to 9.
		for (int i = 0; i < 10; i++) {
		    // We need to be careful with the 0-indexing. The next square number
		    // is given by (i + 1) * (i + 1).
		    // Calculate it and insert it into the Array at index i.
		    int square = (i + 1) * (i + 1);
		    squareNumbers[i] = square;
		}
		
		// Go through each of the Array indexes, from 0 to 9.
		for (int i = 0; i < 10; i++) {
		    // Access and print what's at the i'th index.
		    System.out.println(squareNumbers[i]);
		}
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
