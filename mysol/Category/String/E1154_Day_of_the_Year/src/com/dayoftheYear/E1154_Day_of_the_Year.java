package com.dayoftheYear;
import java.util.*;

/*
Given a string date representing a Gregorian calendar date 
formatted as YYYY-MM-DD, return the day number of the year.


Example 1:

Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.

Example 2:

Input: date = "2019-02-10"
Output: 41
*/

public class E1154_Day_of_the_Year {

	public static void main(String[] args) {
		String input = "2019-02-10";
        int output = dayOfYear(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public static int dayOfYear(String date) {
        String[] s = date.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[2]);
        boolean isLeap = checkYear(year);
        int noOfDays = 0;
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) {
            if (isLeap && i == 1) {
                noOfDays += days[i] + 1;
                continue;
            }
            noOfDays += days[i];
        }
        return noOfDays + day;
    }
    
    static boolean checkYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        
        return false;
    }

}
