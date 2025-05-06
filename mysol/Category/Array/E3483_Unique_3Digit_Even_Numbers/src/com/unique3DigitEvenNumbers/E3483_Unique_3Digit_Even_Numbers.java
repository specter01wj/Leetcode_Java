package com.unique3DigitEvenNumbers;
import java.util.*;

/*
You are given an array of digits called digits. 
Your task is to determine the number of distinct three-digit 
even numbers that can be formed using these digits.

Note: Each copy of a digit can only be used once per number, 
and there may not be leading zeros.
*/

public class E3483_Unique_3Digit_Even_Numbers {

	public static void main(String[] args) {
		E3483_Unique_3Digit_Even_Numbers solution = new E3483_Unique_3Digit_Even_Numbers();
		int[] input = {1,2,3,4};
		int output = solution.totalNumbers(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. Use 3 nested loops to try all combinations i, j, and k (where i ≠ j ≠ k).
	2. Check if the hundreds digit is not zero.
	3. Check if the last digit (ones place) is even.
	4. Construct the number and add to a Set to ensure uniqueness.
    */
	
	/*
     * @param digits: a list of integers
     * @return: the number of distinct three-digit even numbers
     */
	public int totalNumbers(int[] digits) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue; // Hundreds place can't be 0
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num % 2 == 0) {
                        uniqueNumbers.add(num);
                    }
                }
            }
        }
        
        return uniqueNumbers.size();
    }

}
