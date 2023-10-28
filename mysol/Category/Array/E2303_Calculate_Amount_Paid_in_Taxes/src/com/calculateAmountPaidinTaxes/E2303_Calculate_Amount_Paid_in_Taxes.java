package com.calculateAmountPaidinTaxes;
import java.util.*;

/*
You are given a 0-indexed 2D integer array brackets where brackets[i] = 
[upperi, percenti] means that the ith tax bracket has an upper bound of 
upperi and is taxed at a rate of percenti. 
The brackets are sorted by upper bound (i.e. upperi-1 < upperi for 0 < i < brackets.length).

Tax is calculated as follows:

. The first upper0 dollars earned are taxed at a rate of percent0.
. The next upper1 - upper0 dollars earned are taxed at a rate of percent1.
. The next upper2 - upper1 dollars earned are taxed at a rate of percent2.
. And so on.

You are given an integer income representing the amount of money you earned. 
Return the amount of money that you have to pay in taxes. 
Answers within 10-5 of the actual answer will be accepted.


Example 1:

Input: brackets = [[3,50],[7,10],[12,25]], income = 10
Output: 2.65000
Explanation:
Based on your income, you have 3 dollars in the 1st tax bracket, 
4 dollars in the 2nd tax bracket, and 3 dollars in the 3rd tax bracket.
The tax rate for the three tax brackets is 50%, 10%, and 25%, respectively.
In total, you pay $3 * 50% + $4 * 10% + $3 * 25% = $2.65 in taxes.

Example 2:

Input: brackets = [[1,0],[4,25],[5,50]], income = 2
Output: 0.25000
Explanation:
Based on your income, you have 1 dollar in the 1st tax bracket and 1 dollar 
in the 2nd tax bracket.
The tax rate for the two tax brackets is 0% and 25%, respectively.
In total, you pay $1 * 0% + $1 * 25% = $0.25 in taxes.

Example 3:

Input: brackets = [[2,50]], income = 0
Output: 0.00000
Explanation:
You have no income to tax, so you have to pay a total of $0 in taxes.
*/

public class E2303_Calculate_Amount_Paid_in_Taxes {

	public static void main(String[] args) {
		int[][] input = {{3,50},{7,10},{12,25}};
		double output = calculateTax(input, 10);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	
	public static double calculateTax(int[][] brackets, int income) {
		double tax = 0;
		int prev = 0;
		for (int[] bracket : brackets) {
			int upper = bracket[0], percent = bracket[1];
			if (income >= upper) {
				tax += (upper - prev) * percent / 100d;
				prev = upper;
			} else {
				tax += (income - prev) * percent / 100d;
				return tax;
			}
		}
		
		return tax;
	}

}
