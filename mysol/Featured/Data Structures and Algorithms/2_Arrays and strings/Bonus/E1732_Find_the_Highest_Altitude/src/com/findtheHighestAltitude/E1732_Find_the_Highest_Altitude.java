package com.findtheHighestAltitude;
import java.util.*;

/*
There is a biker going on a road trip. The road trip consists of 
n + 1 points at different altitudes. The biker starts his trip on 
point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is 
the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). 
Return the highest altitude of a point.
*/

public class E1732_Find_the_Highest_Altitude {

	public static void main(String[] args) {
		E1732_Find_the_Highest_Altitude solution = new E1732_Find_the_Highest_Altitude();
		int[] input = {-5,1,5,0,-7};
		int output = solution.largestAltitude(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;

        for (int g : gain) {
            currentAltitude += g;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }

}
