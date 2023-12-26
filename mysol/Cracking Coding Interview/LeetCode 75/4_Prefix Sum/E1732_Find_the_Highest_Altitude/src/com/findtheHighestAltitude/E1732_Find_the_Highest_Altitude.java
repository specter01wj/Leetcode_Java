package com.findtheHighestAltitude;
import java.util.*;

/*
There is a biker going on a road trip. The road trip consists of n + 1 points 
at different altitudes. The biker starts his trip on point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is the net gain 
in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). 
Return the highest altitude of a point.


Example 1:

Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.

Example 2:

Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
*/

public class E1732_Find_the_Highest_Altitude {

	public static void main(String[] args) {
		int[] input = {-5,1,5,0,-7};
		int output = largestAltitude(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    loop and compare
    */
	
	/*
     * @param gain: a list of integers
     * @return: the highest altitude of a point
     */
	public static int largestAltitude(int[] gain) {
        int max_alt = 0;
        int curr_alt = 0;
        for (int i = 0;i < gain.length;i++) {
            curr_alt += gain[i]; 
            max_alt = Math.max(curr_alt, max_alt);
        }
        return max_alt;
    }

}
