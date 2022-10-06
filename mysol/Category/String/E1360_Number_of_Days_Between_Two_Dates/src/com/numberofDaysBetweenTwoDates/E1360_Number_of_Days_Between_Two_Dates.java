package com.numberofDaysBetweenTwoDates;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
Write a program to count the number of days between two dates.

The two dates are given as strings, their format is YYYY-MM-DD 
as shown in the examples.


Example 1:

Input: date1 = "2019-06-29", date2 = "2019-06-30"
Output: 1

Example 2:

Input: date1 = "2020-01-15", date2 = "2019-12-31"
Output: 15
*/

public class E1360_Number_of_Days_Between_Two_Dates {

	public static void main(String[] args) {
		String input1 = "2019-02-19";
		String input2 = "2019-06-30";
        int output = daysBetweenDates(input1, input2);
        System.out.println("input1: " + (input1) + " Input2: " + (input2) + "\noutput: " + (output));
	}
	
	
	public static int daysBetweenDates(String date1, String date2) {
        return Math.abs((int)ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2)));
    }

}
