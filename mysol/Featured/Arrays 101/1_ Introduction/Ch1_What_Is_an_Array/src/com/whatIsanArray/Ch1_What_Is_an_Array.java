package com.whatIsanArray;
import java.util.*;

public class Ch1_What_Is_an_Array {

	public static void main(String[] args) {
		Ch1_What_Is_an_Array solution = new Ch1_What_Is_an_Array();
		DVD[] dvdCollection = new DVD[15];
		dvdCollection[0] = solution.new DVD("The Matrix", 1999, "The Wachowskis");
	    dvdCollection[1] = solution.new DVD("Inception", 2010, "Christopher Nolan");
	    System.out.println("Output: " + Arrays.toString(dvdCollection));
	}
	
	
	// A simple definition for a DVD.
	public class DVD {
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
