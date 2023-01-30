package com.maximumPopulationYear;
import java.util.*;

/*
You are given a 2D integer array logs where each logs[i] = [birthi, deathi] 
indicates the birth and death years of the ith person.

The population of some year x is the number of people alive during that year. 
The ith person is counted in year x's population if x is in the inclusive range 
[birthi, deathi - 1]. Note that the person is not counted in the year that they die.

Return the earliest year with the maximum population.


Example 1:

Input: logs = [[1993,1999],[2000,2010]]
Output: 1993
Explanation: The maximum population is 1, and 1993 is the earliest year with this population.

Example 2:

Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
Output: 1960
Explanation: 
The maximum population is 2, and it had happened in years 1960 and 1970.
The earlier year between them is 1960.
*/

public class E1854_Maximum_Population_Year {

	public static void main(String[] args) {
		int[][] input = {{1950,1961},{1960,1971},{1970,1981}};
		int output = maximumPopulation(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Let's understand with an example
	Suppose we are given the log [1950, 1961]
	This means birth year is 1950 and death year is 1961
	Therefore, years from 1950 to 1960 will be incremented by 1.
	
	We can do it by iterating from 1950 to 1960 but that will increase time complexity 
	if we have to do it for every query in logs array.
	
	To do this in O(1), we increment year[1950] by 1 and decrement year[1961] by 1.
	We can reapeat this for every query in logs array.
    */
	
	/*
     * @param logs: a list of 2D integers
     * @return: the earliest year with the maximum population
     */
	public static int maximumPopulation(int[][] logs) {
        int[] year = new int[2051];
        
        for(int[] log : logs){
            year[log[0]] += 1;
            year[log[1]] -= 1;
        }
        
        int maxNum = year[1950], maxYear = 1950;

        for(int i = 1951; i < year.length; i++){
            year[i] += year[i - 1];
            
            if(year[i] > maxNum){
                maxNum = year[i];
                maxYear = i;
            }
        }
        
        return maxYear;
    }

}
