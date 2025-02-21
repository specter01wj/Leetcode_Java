package com.countTripletswithEvenXORSetBitsI;
import java.util.*;

/*
Given three integer arrays a, b, and c, return the number of 
triplets (a[i], b[j], c[k]), such that the bitwise XOR of the 
elements of each triplet has an even number of set bits.
*/

public class E3199_Count_Triplets_with_Even_XOR_Set_Bits_I {

	public static void main(String[] args) {
		E3199_Count_Triplets_with_Even_XOR_Set_Bits_I solution = new E3199_Count_Triplets_with_Even_XOR_Set_Bits_I();
		int[] input1 = {1, 1}, input2 = {2, 3}, input3 = {1, 5};
		int output = solution.tripletCount(input1, input2, input3);
        System.out.println("input: " + Arrays.toString(input1) + "\noutput: " + (output));
	}
	
	
	public int tripletCount(int[] a, int[] b, int[] c) {
        int count = 0;
        
        for (int numA : a) {
            for (int numB : b) {
                for (int numC : c) {
                    int xorValue = numA ^ numB ^ numC;
                    if (Integer.bitCount(xorValue) % 2 == 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }

}
