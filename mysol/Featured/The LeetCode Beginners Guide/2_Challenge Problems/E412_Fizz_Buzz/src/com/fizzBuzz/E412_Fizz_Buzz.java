package com.fizzBuzz;
import java.util.*;

/*
Given an integer n, return a string array answer (1-indexed) where:

	. answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
	. answer[i] == "Fizz" if i is divisible by 3.
	. answer[i] == "Buzz" if i is divisible by 5.
	. answer[i] == i (as a string) if none of the above conditions are true.
*/

public class E412_Fizz_Buzz {

	public static void main(String[] args) {
		E412_Fizz_Buzz solution = new E412_Fizz_Buzz();
		int input = 5;
		List<String> output = solution.fizzBuzz(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	
	public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

}
