package com.addTwoIntegers;
import java.util.*;

/*
Given two integers num1 and num2, return the sum of the two integers.
*/

public class E2235_Add_Two_Integers {

	public static void main(String[] args) {
		E2235_Add_Two_Integers solution = new E2235_Add_Two_Integers();
		int num1 = 12, num2 = 5;
		int output = solution.sum(num1, num2);
        System.out.println("input: " + (num1) + "; " + (num2) + "\noutput: " + (output));
	}
	
	
	public int sum(int num1, int num2) {
        return num1 + num2;
    }

}
