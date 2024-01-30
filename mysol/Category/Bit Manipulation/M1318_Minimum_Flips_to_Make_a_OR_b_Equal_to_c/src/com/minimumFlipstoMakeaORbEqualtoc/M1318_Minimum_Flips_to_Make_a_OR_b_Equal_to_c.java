package com.minimumFlipstoMakeaORbEqualtoc;
import java.util.*;

/*
Given 3 positives numbers a, b and c. Return the minimum flips 
required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).

Flip operation consists of change any single bit 1 to 0 or change the 
bit 0 to 1 in their binary representation.
*/

public class M1318_Minimum_Flips_to_Make_a_OR_b_Equal_to_c {

	public static void main(String[] args) {
		int a = 2, b = 6, c = 5;
		int output = minFlips(a, b, c);
        System.out.println("input: " + (a) + "\noutput: " + (output));
	}
	
	/*
    solution:
    Bit Manipulation
    */
	
	/*
     * @param a: an integer
     * @param b: an integer
     * @param c: an integer
     * @return: the minimum flips required in some bits of a and b to make ( a OR b == c )
     */
	public static int minFlips(int a, int b, int c) {
        int flips = 0;

        while (a > 0 || b > 0 || c > 0) {
            int lastBitA = a & 1;
            int lastBitB = b & 1;
            int lastBitC = c & 1;

            // Check if the current bits of a and b do not match the bit in c
            if ((lastBitA | lastBitB) != lastBitC) {
                flips += (lastBitC == 0) ? (lastBitA + lastBitB) : 1;
            }

            // Move to the next set of bits
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }

}
