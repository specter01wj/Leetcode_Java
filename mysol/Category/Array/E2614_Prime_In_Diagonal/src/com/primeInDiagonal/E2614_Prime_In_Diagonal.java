package com.primeInDiagonal;
import java.util.*;

/*
You are given a 0-indexed two-dimensional integer array nums.

Return the largest prime number that lies on at least one of the 
diagonals of nums. In case, no prime is present on any of the 
diagonals, return 0.
*/

public class E2614_Prime_In_Diagonal {

	public static void main(String[] args) {
		E2614_Prime_In_Diagonal solution = new E2614_Prime_In_Diagonal();
		int[][] input = {{1,2,3},{5,6,7},{9,10,11}};
		int output = solution.diagonalPrime(input);
        System.out.println("input: " + Arrays.deepToString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    1. isPrime function: This function checks if a number is prime. 
    	If the number is less than or equal to 1, it is not prime. 
    	Otherwise, we check divisibility from 2 to the square root of the number.
	2. Loop through diagonals: We iterate through both diagonals 
		(nums[i][i] and nums[i][nums.length - i - 1]). For each number 
		on the diagonals, we check if it's prime using the isPrime function.
	3. Return the result: We keep track of the maximum prime number found 
		on the diagonals and return it. If no prime number is found, we return 0.
    */
	
	/*
     * @param nums: a list of 2D integers
     * @return: the largest prime number
     */
	public int diagonalPrime(int[][] nums) {
	       int maxPrime = 0;
	        int n = nums.length;

	        for (int i = 0; i < n; i++) {
	            // Check the first diagonal (nums[i][i])
	            if (isPrime(nums[i][i])) {
	                maxPrime = Math.max(maxPrime, nums[i][i]);
	            }
	            
	            // Check the second diagonal (nums[i][n - i - 1])
	            if (isPrime(nums[i][n - i - 1])) {
	                maxPrime = Math.max(maxPrime, nums[i][n - i - 1]);
	            }
	        }

	        return maxPrime; 
	    }

	    // Helper function to check if a number is prime
	    private boolean isPrime(int num) {
	        if (num <= 1) return false;
	        for (int i = 2; i * i <= num; i++) {
	            if (num % i == 0) return false;
	        }
	        return true;
	    }

}
