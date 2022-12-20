package com.averageSalaryExcludingtheMinimumandMaximumSalary;
import java.util.*;

/*
You are given an array of unique integers salary where salary[i] is 
the salary of the ith employee.

Return the average salary of employees excluding the minimum and maximum salary. 
Answers within 10-5 of the actual answer will be accepted.


Example 1:

Input: salary = [4000,3000,1000,2000]
Output: 2500.00000
Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500

Example 2:

Input: salary = [1000,2000,3000]
Output: 2000.00000
Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
Average salary excluding minimum and maximum salary is (2000) / 1 = 2000
*/

public class E1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary {

	public static void main(String[] args) {
		int[] input = {4000,3000,1000,2000};
		double output = average(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    simple loop, One Pass
    */
	
	/*
     * @param salary: a list of integers
     * @return: the average salary of employees excluding the minimum and maximum salary
     */
	public static double average(int[] salary) {
        double sum = 0;
        int M = Integer.MIN_VALUE, m = Integer.MAX_VALUE;
        for (int s : salary) {
            m = Math.min(m, s);
            M = Math.max(M, s);
            sum += s;
        }
        return (sum - m - M) / (salary.length - 2);
    }

}
