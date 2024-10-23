package com.numberofSeniorCitizens;
import java.util.*;

/*
You are given a 0-indexed array of strings details. 
Each element of details provides information about a given passenger 
compressed into a string of length 15. The system is such that:

	. The first ten characters consist of the phone number of passengers.
	. The next character denotes the gender of the person.
	. The following two characters are used to indicate the age of the person.
	. The last two characters determine the seat allotted to that person.

Return the number of passengers who are strictly more than 60 years old.
*/

public class E2678_Number_of_Senior_Citizens {

	public static void main(String[] args) {
		E2678_Number_of_Senior_Citizens solution = new E2678_Number_of_Senior_Citizens();
		String[] input = {"7868190130M7522","5303914400F9211","9273338290F4010"};
		int output = solution.countSeniors(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int countSeniors(String[] details) {
        int seniorCount = 0;

        // Iterate through each passenger's details
        for (String detail : details) {
            // Extract the age portion from the string (11th and 12th characters)
            int age = Integer.parseInt(detail.substring(11, 13));

            // Check if the age is strictly more than 60
            if (age > 60) {
                seniorCount++;
            }
        }

        return seniorCount;
    }

}
