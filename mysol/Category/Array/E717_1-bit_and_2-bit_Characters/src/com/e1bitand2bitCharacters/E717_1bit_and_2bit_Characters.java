package com.e1bitand2bitCharacters;
import java.util.*;

/*We have two special characters. The first character can be 
represented by one bit 0. The second character can be 
represented by two bits (10 or 11).

Now given a string represented by several bits. Return whether 
the last character must be a one-bit character or not. 
The given string will always end with a zero.

Example 1:
Input: 
bits = [1, 0, 0]
Output: True
Explanation: 
The only way to decode it is two-bit character and one-bit character. 
So the last character is one-bit character.

Example 2:
Input: 
bits = [1, 1, 1, 0]
Output: False
Explanation: 
The only way to decode it is two-bit character and two-bit character. 
So the last character is NOT one-bit character.*/

public class E717_1bit_and_2bit_Characters {

	public static void main(String[] args) {
		int[] input = {1,1,1,0};
        boolean output = isOneBitCharacter(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + (output));
	}
	
	/*
    solution:
    从头到尾遍历，如果该位数字为1，则向后前进两位，否则前进1位，
    循环的条件是i < n-1，即留出最后一位. 当循环退出后，
    i正好停留在n-1上，说明最后一位是单独分割开的。
    */
	
	/*
     * @param bits: a list of integers
     * @return:  a boolean
     */
	public static boolean isOneBitCharacter(int[] bits) {
		int n = bits.length, i = 0;
		while(i < n - 1) {
			if(bits[i] == 0) {
				i++;
			} else {
				i += 2;
			}
		}
		
		return i == n - 1;
	}

}
