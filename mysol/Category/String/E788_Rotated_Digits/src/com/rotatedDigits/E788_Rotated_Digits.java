package com.rotatedDigits;
import java.util.*;

/*X is a good number if after rotating each digit individually 
by 180 degrees, we get a valid number that is different from X.  
Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 
0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other 
(on this case they are rotated in a different direction, 
in other words 2 or 5 gets mirrored); 6 and 9 rotate to each other, 
and the rest of the numbers do not rotate to any other number 
and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation: 
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged 
after rotating.*/

public class E788_Rotated_Digits {

	public static void main(String[] args) {
		int input = 10;
        int output = rotatedDigits(input);
        System.out.println("input: " + (input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    遍历每一个数，由题意可知，6可以变成9，2可以变成5，是好数。
    1、8、0本身转变后没有改变，因此不考虑。
    如果存在3、4、7直接返回false，节约时间。
    */
	
	/*
     * @param N: an integer
     * @return: rotated digits
     */
	public static int rotatedDigits(int N) {
		int count = 0;
		
        for(int i = 1; i <= N; i ++) {
            if(isValid(i)) {
            	count ++;
            }
        }
        
        return count;
	}
	
	public static boolean isValid(int N) {
        boolean validFound = false;
        
        while(N > 0) {
            if(N % 10 == 2) validFound = true;
            if(N % 10 == 5) validFound = true;
            if(N % 10 == 6) validFound = true;
            if(N % 10 == 9) validFound = true;
            if(N % 10 == 3) return false;
            if(N % 10 == 4) return false;
            if(N % 10 == 7) return false;
            N = N / 10;
        }
        
        return validFound;
    }

}
