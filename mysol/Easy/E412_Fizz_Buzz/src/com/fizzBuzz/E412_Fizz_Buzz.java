package com.fizzBuzz;
import java.util.*;

/*
Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.


Example 1:

Input: n = 3
Output: ["1","2","Fizz"]

Example 2:

Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]

Example 3:

Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11",
"Fizz","13","14","FizzBuzz"]
*/

public class E412_Fizz_Buzz {

	public static void main(String[] args) {
		int input = 15;
		List<String> output = fizzBuzz(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    能同时被3跟5整除的数，肯定也能被3整除，也能被5整除，所以要先判断能否被15整除
    */
	
	/**
     * param n: As description.
     * return: A list of strings.
     */
	public static List<String> fizzBuzz(int n) {
		ArrayList<String> results = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                results.add("FizzBuzz");
            } else if (i % 5 == 0) {
                results.add("Buzz");
            } else if (i % 3 == 0) {
                results.add("Fizz");
            } else {
                results.add(String.valueOf(i));
            }
        }
        return results;
	}

}
