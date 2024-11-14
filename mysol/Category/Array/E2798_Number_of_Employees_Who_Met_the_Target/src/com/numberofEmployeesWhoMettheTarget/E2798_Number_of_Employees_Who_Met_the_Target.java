package com.numberofEmployeesWhoMettheTarget;
import java.util.*;

/*
There are n employees in a company, numbered from 0 to n - 1. 
Each employee i has worked for hours[i] hours in the company.

The company requires each employee to work for at least target hours.

You are given a 0-indexed array of non-negative integers hours of 
length n and a non-negative integer target.

Return the integer denoting the number of employees who worked at 
least target hours.
*/

public class E2798_Number_of_Employees_Who_Met_the_Target {

	public static void main(String[] args) {
		E2798_Number_of_Employees_Who_Met_the_Target solution = new E2798_Number_of_Employees_Who_Met_the_Target();
		int[] input = {0,1,2,3,4};
		int target = 2;
		int output = solution.numberOfEmployeesWhoMetTarget(input, target);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	
	public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
		int count = 0;
		
		for (int hour : hours) {
			if (hour >= target) {
				count++;
			}
		}
		
		return count;
	}

}
