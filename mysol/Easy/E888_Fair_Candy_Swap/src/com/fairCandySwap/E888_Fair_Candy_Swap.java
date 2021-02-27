package com.fairCandySwap;
import java.util.*;

/*Alice and Bob have candy bars of different sizes: 
A[i] is the size of the i-th bar of candy that Alice has, 
and B[j] is the size of the j-th bar of candy that Bob has.

Since they are friends, they would like to exchange one candy bar 
each so that after the exchange, they both have the same total 
amount of candy.  (The total amount of candy a person has is the 
sum of the sizes of candy bars they have.)

Return an integer array ans where ans[0] is the size of the candy 
bar that Alice must exchange, and ans[1] is the size of the candy 
bar that Bob must exchange.

If there are multiple answers, you may return any one of them.  
It is guaranteed an answer exists.

 

Example 1:

Input: A = [1,1], B = [2,2]
Output: [1,2]

Example 2:

Input: A = [1,2], B = [2,3]
Output: [1,2]

Example 3:

Input: A = [2], B = [1,3]
Output: [2,3]

Example 4:

Input: A = [1,2,5], B = [2,4]
Output: [5,4]*/

public class E888_Fair_Candy_Swap {

	public static void main(String[] args) {
		int[] input1 = {1,2,5};
		int[] input2 = {2,4};
        int[] output = fairCandySwap(input1, input2);
        System.out.println("input1: " + Arrays.toString(input1) + 
        		"input2: " + Arrays.toString(input2) + 
        		"\noutput: " + Arrays.toString(output));
	}
	
	/*
    solution:
    求出相同的糖果总量即两个数组总和的一半，计算A与相同糖果总量的差值，
    这个差值就是两个需要交换的数值的差值，然后循环比较，找到相同的即可。
    */
	
	/**
     * @param A: an array
     * @param B: an array
     * @return: an integer array
     */
	public static int[] fairCandySwap(int[] A, int[] B) {
		int[] ans = new int[2];
        int sumA = 0, sumB = 0;
        for(int i: A){
            sumA += i;
        }
        for(int j: B){
            sumB += j;
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int temp = sumA - (sumA + sumB)/2;
        int i = 0, j = 0;
        
        while(i < A.length && j < B.length){
            if(A[i] - B[j] == temp){
                ans[0] = A[i];
                ans[1] = B[j];
                break;
            }
            else if(A[i] - B[j] > temp){
                j++;
            }
            else if(A[i] - B[j] < temp){
                i++;
            }
        }
        return ans;
	}

}
