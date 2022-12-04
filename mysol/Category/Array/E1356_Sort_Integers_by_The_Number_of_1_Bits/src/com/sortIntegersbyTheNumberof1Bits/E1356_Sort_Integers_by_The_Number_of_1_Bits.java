package com.sortIntegersbyTheNumberof1Bits;
import java.util.*;

/*
You are given an integer array arr. Sort the integers in the array in ascending 
order by the number of 1's in their binary representation and in case of two or 
more integers have the same number of 1's you have to sort them in ascending order.

Return the array after sorting it.


Example 1:

Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]

Example 2:

Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
Output: [1,2,4,8,16,32,64,128,256,512,1024]
Explantion: All integers have 1 bit in the binary representation, 
you should just sort them in ascending order.
*/

public class E1356_Sort_Integers_by_The_Number_of_1_Bits {

	public static void main(String[] args) {
		int[] input = {0,1,2,3,4,5,6,7,8};
		int[] output = sortByBits(input);
        System.out.println("input: " + Arrays.toString(input) + "\noutput: " + Arrays.toString(output));
	}
	
	
	public static int[] sortByBits(int[] arr) {
        int n = arr.length, res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = countBitOne(arr[i])*10001 + arr[i];
        }
        
        Arrays.sort(res);
        for (int i = 0; i < n; i++) {
            res[i] %= 10001;
        }
        
        return res;
    }
    
    private static int countBitOne(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            n >>= 1;
        }
        return res;
    }

}
